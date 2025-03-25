package psu.edu.quiz.security;

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
	        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

	        // Define query to retrieve a user by username
	        jdbcUserDetailsManager.setUsersByUsernameQuery(
	                "SELECT user_id, pw, active FROM members WHERE user_id=?"
	        );

	        // Define query to retrieve the authorities/roles by username
	        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
	                "SELECT user_id, role FROM roles WHERE user_id=?"
	        );

	        return jdbcUserDetailsManager;
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http.authorizeHttpRequests(configurer ->
	            configurer
	           
	            // EMPLOYEE: GET only
	            .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE", "SUPERVISOR", "MANAGER", "ADMIN")
	            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE", "SUPERVISOR", "MANAGER", "ADMIN")

	            // SUPERVISOR: GET + POST
	            .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("SUPERVISOR", "MANAGER", "ADMIN")

	            // MANAGER: GET + POST + PUT
	            .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("MANAGER", "ADMIN")

	            // ADMIN: GET + POST + PUT + DELETE
	            .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
	        );

	        http.httpBasic(Customizer.withDefaults());

	        http.csrf(csrf -> csrf.disable());

	        return http.build();
	        
	    }
}