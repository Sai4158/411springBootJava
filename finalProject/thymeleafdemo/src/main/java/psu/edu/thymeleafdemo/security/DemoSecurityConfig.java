package psu.edu.thymeleafdemo.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config -> config
                .requestMatchers("/employees/showFormForAdd").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers("/employees/showFormForUpdate").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers("/employees/delete").hasRole("ADMIN")
                .requestMatchers("/employees/**").authenticated()
                .anyRequest().permitAll()
        )
        .formLogin(form -> form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/employees/list", true)
                .permitAll()
        )
        .logout(logout -> logout
                .logoutSuccessUrl("/showMyLoginPage?logout")
                .permitAll()
        )
        .exceptionHandling(config -> config.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
