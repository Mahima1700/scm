package com.scm.scm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.repository.UserRepo;
import com.scm.scm.entity.*;

@Service
public class UserService {
	
	 @Autowired  UserRepo userRepo;


	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	public User saveUser(User user) {
		 return userRepo.save(user);
		
	}
	
	public User updateUser(User user, Long id) {
	    User existingUser = userRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    existingUser.setName(user.getName());
	    existingUser.setUsername(user.getUsername());
	    existingUser.setEmail(user.getEmail());
	    existingUser.setRole(user.getRole());
	    // Set other fields as needed

	    return userRepo.save(existingUser);
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		}

	
	
	


	

	/*
	 * public List<User> getAlluser() { List<User> empEntity = new
	 * ArrayList<User>(); eRepo.findAll().forEach(empEntity1 ->
	 * empEntity.add(empEntity1)); return empEntity; } public void saveOrUpdate(User
	 * uid) { eRepo.save(uid); }
	 */

}
