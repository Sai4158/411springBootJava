package psu.edu.CRUD_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails sai = User.builder()
				.username("sai")
				.password("{noop}sai123")  
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails alex = User.builder()
				.username("alex")
				.password("{noop}alex123") 
				.roles("EMPLOYEE")
				.build();

		return new InMemoryUserDetailsManager(sai, alex);
	}

}

