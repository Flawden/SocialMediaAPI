//package ru.flawden.SocialMediaAPI.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import ru.flawden.SocialMediaAPI.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
//                    .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .defaultSuccessUrl("/")
//                    .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//
//}
//
