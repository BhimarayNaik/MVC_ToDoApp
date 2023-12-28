package todo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.dto.ToDoTask;
import todo.dto.ToDoUser;
import todo.service.ToDoService;

@Controller
public class ToDoController {
	@Autowired
	ToDoService service;
	
@GetMapping({"/","login"})
public String loadLogin()
{
	return "Login";
}
@GetMapping("/signup")
public String loadSignup() {
	return "Signup";
}
@GetMapping("/home")
public String loadHome(HttpSession session,ModelMap map) {
	 return service.loadHome(session,map);
}

@PostMapping("/signup")
public String signup(ToDoUser user,@RequestParam String date,ModelMap map) {
	return service.signup(user,date,map);
}
@PostMapping("/login")
public String login(@RequestParam String email,@RequestParam String password,ModelMap map,HttpSession session) {
	return service.login(email,password,map,session);
}
@GetMapping("/logout")
public String logout(HttpSession session,ModelMap map) {
	return service.logout(session,map);
}
@GetMapping("/add-task")
public String loadAddTask(HttpSession session,ModelMap map) {
	return service.addTask(session, map);
}

@PostMapping("/add-task")
public String addTask(ToDoTask task,HttpSession session, ModelMap map) {
	return service.addTask(task,session,map);
}
@GetMapping("/change-status")
public String changeStatus(@RequestParam int id,HttpSession session,ModelMap map) {
return service.changeStatus(session,id,map);
}
@GetMapping("/delete")
public String deleteTask(@RequestParam int id,HttpSession session,ModelMap map) {
return service.deleteTask(session,id,map);
}
}