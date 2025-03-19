package psu.edu.CRUD_demo.security;

import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	
	 @Bean
	    public UserDetailsManager userDetailsManager(DataSource dataSource) {
	        return new JdbcUserDetailsManager(dataSource);
	    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer ->
		configurer
		.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				);

		http.httpBasic(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());

		return http.build();
	}



	//    @Bean
	//    public UserDetailsService userDetailsService() {
	//        UserDetails sai = User.builder()
	//                .username("sai")
	//                .password("{noop}sai123")  
	//                .roles("EMPLOYEE")
	//                .build();
	//
	//        UserDetails alex = User.builder()
	//                .username("alex")
	//                .password("{noop}alex123") 
	//                .roles("EMPLOYEE")
	//                .build();
	//
	//        UserDetails managerUser = User.builder()
	//                .username("manager")
	//                .password("{noop}manager123") 
	//                .roles("MANAGER")
	//                .build();
	//        
	//        UserDetails adminUser = User.builder()
	//                .username("admin")
	//                .password("{noop}admin123") 
	//                .roles("ADMIN")
	//                .build();
	//
	//        return new InMemoryUserDetailsManager(sai, alex, managerUser, adminUser);
	//    }

}