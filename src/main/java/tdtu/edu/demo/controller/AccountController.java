package tdtu.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tdtu.edu.demo.entity.Role;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.repository.UserRepository;
import tdtu.edu.demo.service.UserService;


@Controller
public class AccountController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("account/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		
		return "account/register";
	}
	
	@PostMapping("/account/register/save")
	public String processRegister(User user) {
		userService.saveUserWithDefaultRole(user);
		
		return "account/register-success";
	}
	
	@GetMapping("account/users")
	public String listUsers(Model model) {
		List<User> listUsers = userService.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "account/users";
	}
	
	@GetMapping("/account/users/edit/{id}")
	public String editUserRole(@PathVariable("id") Integer id, Model model) {
		User user = userService.get(id);
		List<Role> listRoles = userService.getRoles();
		
		model.addAttribute("user",user);
		model.addAttribute("listRoles",listRoles);
		return "/account/user-form";
		
	}
	
	@PostMapping("/account/users/save")
	public String saveUser(User user) {
		userService.save(user);
		
		return "redirect:/account/users";
	}
	
	@GetMapping("/account/login")
	public String login() {
		return "/account/login";
	}
	
	
}
