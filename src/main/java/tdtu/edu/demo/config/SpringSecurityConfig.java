package tdtu.edu.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tdtu.edu.demo.service.CustomUserDetailsService;
import tdtu.edu.demo.service.HandleLoginSuccess;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private HandleLoginSuccess handleLoginSuccess;
	
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
							"/employee/add-employee", "/product/add-product", "/home-manager",
							"/employee/update-employee/**", "/account/users/edit/**", "product/update-product/**")
			.hasAnyAuthority("MANAGER", "ADMIN")
			.requestMatchers("/employee/employeeDelete/**", "/home-admin").hasAuthority("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/account/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(handleLoginSuccess)
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/account/login").permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
		
//		httpSecurity.authorizeHttpRequests().requestMatchers("/account/users")
//		.authenticated().anyRequest().permitAll()
//		.and()
//		.formLogin()
//			.loginPage("/account/login")
//			.usernameParameter("email")
//			.passwordParameter("password")
//			.permitAll()
//			.defaultSuccessUrl("/account/users")
////			.failureUrl("/account/login")
//		.and()
//		.logout()
//			.logoutSuccessUrl("/account/login").permitAll();
		
		return httpSecurity.build();
	}

}
