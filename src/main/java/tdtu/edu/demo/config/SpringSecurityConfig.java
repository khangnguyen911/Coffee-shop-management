package tdtu.edu.demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tdtu.edu.demo.service.CustomUserDetailsService;
import tdtu.edu.demo.service.HandleLoginFailure;
import tdtu.edu.demo.service.HandleLoginSuccess;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private HandleLoginSuccess handleLoginSuccess;
	
	@Autowired
	private HandleLoginFailure handleLoginFailure;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests()
			.requestMatchers("/employee/list-employee", "/account/users", "/product/list-product",
							"/employee/add-employee", "/product/add-product", "/manager/**",
							"/employee/update-employee/**", "/account/users/edit/**", "product/update-product/**")
			.hasAnyAuthority("MANAGER", "ADMIN")
			.requestMatchers("/employee/employeeDelete/**", "/admin/**", "/manager/**").hasAuthority("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.permitAll()
				.loginPage("/account/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(handleLoginSuccess)
				.failureHandler(handleLoginFailure)
			
			.and()
			.logout()
				.permitAll()
				.logoutSuccessHandler(new LogoutSuccessHandler() {
					
					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
							throws IOException, ServletException {
						// TODO Auto-generated method stub
						System.out.println("User name: "+authentication.getName()+" logged out !!!");
						
						response.sendRedirect("/account/logout-success");
					}
				})
				.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling()
				.accessDeniedPage("/403")
			.and()
			.rememberMe()
				.tokenValiditySeconds(60*60) // expiration 1 hour
				.key("uniqueAndSecret") // cookies will survive if restarted
			;
		
		return httpSecurity.build();
	}
}
