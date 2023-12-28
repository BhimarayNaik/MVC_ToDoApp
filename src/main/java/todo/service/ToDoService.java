package todo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ServerWebInputException;

import com.mysql.cj.Session;

import todo.dao.TodoDao;
import todo.dto.ToDoTask;
import todo.dto.ToDoUser;
import todo.helper.AES;

@Component
public class ToDoService {

	@Autowired
	TodoDao dao;

	public String signup(ToDoUser user, String date, ModelMap map) {
		user.setDob(LocalDate.parse(date));
		user.setAge(Period.between(user.getDob(), LocalDate.now()).getYears());
		user.setPassword(AES.encrypt(user.getPassword(), "123"));
		if (user.getAge() < 18) {
			map.put("msg", "you have to be 18+ to create account");
			return "Signup";
		} else {
			List<ToDoUser> list = dao.findByEmail(user.getEmail());
			if (list.isEmpty()) {
				dao.saveUser(user);
				map.put("account", "Account Created Successfully");
				return "Login";
			} else {
				map.put("email", "Email should be Unique");
				return "Signup";
			}
		}
	}

	public String login(String email, String password, ModelMap map,HttpSession session) {
		List<ToDoUser> list=dao.findByEmail(email);
		if(list.isEmpty()) {
			map.put("email","Email is Incorrect");
			return "Login";
		}else{
			if(password.equals(AES.decrypt(list.get(0).getPassword(),"123")))
			{
				session.setAttribute("todouser",list.get(0));
				map.put("list", dao.fetchAllTask(list.get(0).getId()));
				map.put("pass","Login Success");
				return "Home";
			}else {
				map.put("password", "Invalid Password");
				return "Login";
			}
		}
	}
	
	public String loadHome(HttpSession session,ModelMap map) {
		ToDoUser user=(ToDoUser) session.getAttribute("todouser");
		if(user==null) {
			map.put("fail","Invalid Session");
			return "Login";
		}else{
			map.put("list", dao.fetchAllTask(user.getId()));
			return "Home";
		}
	}
	
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.put("logout","Logout Success");
		return "Login";
	}
	
	public String addTask(HttpSession session, ModelMap map) {
		ToDoUser user=(ToDoUser) session.getAttribute("todouser");
		if(user==null) {
			map.put("fail","Invalid Session");
			return "Login";
		}else{
			return "AddTask";
		}
	}
	
	public String addTask(ToDoTask task, HttpSession session, ModelMap map) {
		ToDoUser user = (ToDoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else {
			task.setCreatedTime(LocalDateTime.now());
			task.setUser(user);
			dao.saveTask(task);
			
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Data Saved Success");
			return "Home";
		}
	}

	public String changeStatus(HttpSession session, int id, ModelMap map) {
		ToDoUser user = (ToDoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else{
			ToDoTask task=dao.fetchTaskById(id);
			task.setStatus(true);
			dao.updateUser(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Status Changed Success");
			return "Home";
		}
	}

	public String deleteTask(HttpSession session, int id, ModelMap map) {
		ToDoUser user = (ToDoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "Login";
		} else{
			ToDoTask task=dao.fetchTaskById(id);
			dao.deleteTask(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Task Deleted Success");
			return "Home";
		}
	}
}
	
