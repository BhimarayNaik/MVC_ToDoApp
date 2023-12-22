package todo.service;

import java.time.LocalDate;
import java.util.List;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ServerWebInputException;

import todo.dao.TodoDao;
import todo.dto.ToDoUser;
import todo.helper.AES;

@Component
public class ToDoService {

	@Autowired
	TodoDao dao;
	@Autowired
	ToDoService service;

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
				map.put("pass", "Account Created Successfully");
				return "Login";
			} else {
				map.put("email", "Email should be Unique");
				return "Signup";
			}
		}
	}

	public String login(ToDoUser user, String email, String password, ModelMap map) {
		
		user.setPassword(AES.decrypt(user.getPassword(),"123"));
		if(service.login(user.getEmail(),user.getPassword(), map)) {
         map.put("login","Login Success");
        return "Home";
	}else {
		map.put("cred","Invalid Credentials");
		return "Login";
	}
}
}
