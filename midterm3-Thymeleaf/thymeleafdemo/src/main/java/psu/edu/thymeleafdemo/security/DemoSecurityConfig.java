package psu.edu.thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails uday = User.builder()
                .username("uday")
                .password("{noop}test123")
                .roles("SUPERVISOR")
                .build();

        UserDetails arshdeep = User.builder()
                .username("arshdeep")
                .password("{noop}test123")
                .roles("MANAGER")
                .build();

        UserDetails parthiv = User.builder()
                .username("parthiv")
                .password("{noop}test123")
                .roles("DIRECTOR")
                .build();

        UserDetails david = User.builder()
                .username("david")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(uday, arshdeep, parthiv, david);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
            configurer
                .requestMatchers("/employees/showFormForAdd").hasAnyRole("MANAGER", "DIRECTOR", "ADMIN")
                .requestMatchers("/employees/showFormForUpdate").hasAnyRole("DIRECTOR", "ADMIN")
                .requestMatchers("/employees/delete").hasAnyRole("DIRECTOR", "ADMIN")
                .requestMatchers("/employees/**").authenticated()  
                .anyRequest().permitAll()
        )
        .formLogin(form ->
            form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/employees/list", true)
                .permitAll()
        )
        .logout(logout ->
            logout
                .logoutSuccessUrl("/showMyLoginPage")
                .permitAll()
        )
        .exceptionHandling(configurer ->
            configurer.accessDeniedPage("/access-denied")
        )
        .logout(logout -> 
        logout.logoutSuccessUrl("/showMyLoginPage?logout"));

        return http.build();
    }

}
