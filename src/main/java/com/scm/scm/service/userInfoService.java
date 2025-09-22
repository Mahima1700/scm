package com.scm.scm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.entity.User;
import com.scm.scm.entity.userInfo;
import com.scm.scm.repository. userInfoRepo ;

@Service
public class userInfoService {
	
	
	 @Autowired  userInfoRepo  userRe;
	 public userInfo getUserById(Long id) {
			return userRe.findById(id).orElse(null);
		}

	
	public List<userInfo> getAllUsers() {
		return userRe.findAll();
	}

	/*
	 * public userInfo getUserById1(Long id) { return
	 * userRe.findById(id).orElse(null); }
	 */
	public userInfo saveUser(User user) {
		
		 return userRe.save(user);
		
	}

	//public User saveUser(User user) {
		// return userRe.save(user);
		
	//}
	public userInfo updateUser(userInfo user, Long id) {
	    userInfo existingUser = userRe.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	   existingUser.setAddress(user.getAddress());
	   existingUser.setPhone(user.getPhone());
	   existingUser.setGender(user.getGender());
	   existingUser.setDob(user.getDob());
	   existingUser.setState(user.getState());

	    return userRe.save(existingUser);
	}

	

	

}
