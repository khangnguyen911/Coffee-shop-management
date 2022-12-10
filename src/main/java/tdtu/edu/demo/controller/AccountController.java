package tdtu.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.repository.UserRepository;


@Controller
public class AccountController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("account/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		
		return "account/register";
	}
	
	@PostMapping("/account/register/save")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
		
		return "/account/register-success";
	}
	
	@GetMapping("/account/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "/account/users";
	}
	
	// handler method to handle login request
    @GetMapping("/account/login")
    public String login(){
        return "/account/login";
    }
}
