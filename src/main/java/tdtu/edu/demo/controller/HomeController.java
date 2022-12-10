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
}
