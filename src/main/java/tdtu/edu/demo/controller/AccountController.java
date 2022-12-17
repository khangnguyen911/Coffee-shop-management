package tdtu.edu.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import tdtu.edu.demo.entity.Role;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.generate.Utility;
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
	public String processRegister(User user, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, MessagingException {
		String siteURL = Utility.getSiteURL(httpServletRequest);
		
		userService.saveUserWithDefaultRole(user, siteURL);
		
		return "account/register-success";
	}
	
	@GetMapping({"account/users", "account/"})
	public String listUsers(Model model) {
		return listByPage(model, 1, "username", "asc");
	}
	
	@GetMapping("/account/page/{pageNumber}")
	public String listByPage(Model model, 
			@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		Page<User> page = userService.listAll(currentPage, sortField, sortDir);
		int totalItems = (int) page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		List<User> listUsers = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc"; 
		model.addAttribute("reverseSortDir", reverseSortDir);
		
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
	
	
	// Prevent User from Going Back to Login Page if Already logged in
	@GetMapping("/account/login")
	public String login(Model model, HttpServletRequest httpServletRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "account/login";	
		} else {
			if(httpServletRequest.isUserInRole("ADMIN")) {
				return "redirect:/admin/";
			} else if(httpServletRequest.isUserInRole("MANAGER")) {
				return "redirect:/manager/";
			}
		}
		
		return "redirect:/user/";
	}
	
	// send email to active user
	@GetMapping("/account/verify")
	public String getVerifyAccount(@Param("code") String code) {
		boolean verified = userService.verify(code);
		if(verified) {
			return "account/verify-success";
		} else {
			return "account/verify-fail";
		}
	}
}
