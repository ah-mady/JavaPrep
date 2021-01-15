package com.todoapp.demo.configurations;

import com.todoapp.demo.configurations.jwt.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private JwtFilter jwtFilter;

  public SecurityConfig(JwtFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/admin/*").hasRole("ADMIN")
        .antMatchers("/user/*").hasAnyRole("USER", "ADMIN")
        .antMatchers("/register", "/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        .and()
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
