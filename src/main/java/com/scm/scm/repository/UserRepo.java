package com.scm.scm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	 //Optional<User> findByUsername(String username);
      public User findByEmail(String email);
}
