package tdtu.edu.demo.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MVCConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/../home-user").setViewName("home-user");
		registry.addViewController("/../home-creator").setViewName("home-creator");
		registry.addViewController("/../home-editor").setViewName("home-editor");
		registry.addViewController("/../home-admin").setViewName("home-admin");
	}

}
