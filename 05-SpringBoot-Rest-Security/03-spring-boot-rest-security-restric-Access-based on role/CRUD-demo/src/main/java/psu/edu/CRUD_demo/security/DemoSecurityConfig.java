package psu.edu.CRUD_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	 http.authorizeHttpRequests(configurer ->
         configurer
             .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
             .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
             .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
             .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
             .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
     );

        // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
