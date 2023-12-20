package todo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import todo.dto.ToDoUser;

@Controller
public class ToDoController {
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
@ResponseBody
public String signup(ToDoUser user,@RequestParam String date) {
	user.setDob(LocalDate.parse(date));
	return user.toString();
}
}