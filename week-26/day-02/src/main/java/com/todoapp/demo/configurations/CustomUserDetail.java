package com.todoapp.demo.configurations;

import com.todoapp.demo.models.UserEntity;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {

  private String username;
  private String password;
  private Collection<? extends GrantedAuthority> grantedAuthorities;

  public static CustomUserDetail fromUserEntityToCustomUserDetails(UserEntity userEntity) {
    CustomUserDetail customUserDetail = new CustomUserDetail();
    customUserDetail.username = userEntity.getUsername();
    customUserDetail.password = userEntity.getPassword();
    customUserDetail.grantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(userEntity.getRoleEntity().getRole()));
    return customUserDetail;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
