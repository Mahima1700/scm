package com.scm.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.scm.scm.entity.User;
import com.scm.scm.repository.UserRepo;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo urepo;
	
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user=	urepo.findByEmail(email);
        
        if(user==null) {
        	throw new UsernameNotFoundException("user name not found");
        }else {
        	return new CustomUser(user);
        }
        
        
}

}
