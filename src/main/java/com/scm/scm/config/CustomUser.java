package com.scm.scm.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.scm.scm.entity.User;

public class CustomUser implements UserDetails{
	
	private User u;
	
	
	
	public CustomUser(User u) {
		super();
		this.u = u;
	}
//override
	public Collection<? extends GrandAuthority> getAuthoritites(){
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(u.getRole());
		return null;
		
		//return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		return u.getEmail();
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
