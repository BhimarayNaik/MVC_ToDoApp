package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

@PostMapping("/signup")
public String signup(ToDoUser user,@RequestParam String date,ModelMap map) {
	return service.signup(user,date,map);
}
@PostMapping("./home")
public String login(ToDoUser user,@RequestParam String email,@RequestParam String password,ModelMap map) {
	return service.login(user,email,password,map);
	
}
}
