package com.todoapp.demo.configurations.jwt;

import static org.springframework.util.StringUtils.hasText;

import com.todoapp.demo.configurations.CustomUserDetail;
import com.todoapp.demo.services.CustomUserDetailService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Log
public class JwtFilter extends GenericFilterBean {

  public static final String AUTHORIZATION = "Authorization";
  private JwtProvider jwtProvider;
  private CustomUserDetailService customUserDetailService;

  public JwtFilter(JwtProvider jwtProvider, CustomUserDetailService customUserDetailService) {
    this.jwtProvider = jwtProvider;
    this.customUserDetailService = customUserDetailService;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    logger.info("some filters..");
    String token = getTokenFromRequest((HttpServletRequest) request);
    if (token != null && jwtProvider.validateToken(token)) {
      String username = jwtProvider.getUsernameFromToken(token);
      CustomUserDetail customUserDetail = customUserDetailService.loadUserByUsername(username);
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customUserDetail, null, customUserDetail.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
    chain.doFilter(request, response);
  }

  private String getTokenFromRequest(HttpServletRequest request) {
    String bearer = request.getHeader(AUTHORIZATION);
    if (hasText(bearer) && bearer.startsWith("Bearer ")) {
      return bearer.substring(7);
    }
    return null;
  }

}
