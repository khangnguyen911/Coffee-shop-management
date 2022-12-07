package tdtu.edu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String getMenu() {
		return "menu";
	}
	
	@GetMapping("/service")
	public String getService() {
		return "service";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}
}
