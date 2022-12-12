package tdtu.edu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// Phương thức xử lý yêu cầu đến trang chủ
	@GetMapping({"/index", "/"})
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String getMenu() {
		return "menu";
	}
	
	@GetMapping("/services")
	public String getService() {
		return "services";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}
	
	@GetMapping({"/user/home-user", "/user/", "/user/index"})
	public String getHomeUser() {
		return "user/home-user";
	}
	
	@GetMapping("/user/menu-user")
	public String getMenuUser() {
		return "user/menu-user";
	}
	
	@GetMapping("/user/contact-user")
	public String getContactUser() {
		return "user/contact-user";
	}
	
	@GetMapping("/user/services-user")
	public String getServicesUser() {
		return "user/services-user";
	}
	
	@GetMapping({"/manager/home-manager", "/manager/", "/manager/index"})
	public String getHomeManager() {
		return "manager/home-manager";
	}
	
	@GetMapping("/manager/menu-manager")
	public String getMenuManager() {
		return "manager/menu-manager";
	}
	
	@GetMapping("/manager/contact-manager")
	public String getContactManager() {
		return "manager/contact-manager";
	}
	
	@GetMapping("/manager/services-manager")
	public String getServicesManager() {
		return "manager/services-manager";
	}
	
	@GetMapping({"/admin/home-admin","/admin/"})
	public String getHomeAdmin() {
		return "admin/home-admin";
	}
	
	@GetMapping("/admin/menu-admin")
	public String getMenuAdmin() {
		return "admin/menu-admin";
	}
	
	@GetMapping("/admin/contact-admin")
	public String getContactAdmin() {
		return "admin/contact-admin";
	}
	
	@GetMapping("/admin/services-admin")
	public String getServicesAdmin() {
		return "admin/services-admin";
	}
}
