package ua.travelAgency.config;


////@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin")
//                .hasRole("Admin")
//                .antMatchers("/user").hasAnyRole("Admin","User").anyRequest()
//                .authenticated().and().formLogin();
//
//    }
//
//
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager
//                (User.builder()
//                        .username("Manager")
//                        .password(passwordEncoder().encode("admin1"))
//                        .roles("Admin")
//                        .build(),
//                User.builder().username("User")
//                        .password(passwordEncoder()
//                        .encode("user1"))
//                        .roles("User")
//                        .build()
//                );
//    }
//
//    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }
//}
