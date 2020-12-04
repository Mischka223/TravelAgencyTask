package com.softserve.travelAgency.config;


import com.softserve.travelAgency.model.Permission;
import com.softserve.travelAgency.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority(Permission.PERSON_WRITE.getPermission())
                .antMatchers("/**").hasAuthority(Permission.PERSON_READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login/page").permitAll()
                .defaultSuccessUrl("/home").and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/login/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login/page");

    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager
                (User.builder()
                        .username("Manager")
                        .password("{noop}hdjdd333555677345")
                        .authorities(Role.ADMIN.getAuthorities())
                        .build(),
                        User.builder()
                                .username("User")
                                .password("{noop}us44gtsq2245683")
                                .authorities(Role.USER.getAuthorities())
                                .build()
                );
    }

}
