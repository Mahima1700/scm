package com.scm.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm.entity.User;
import com.scm.scm.entity.userInfo;


	
	@Repository
	public interface userInfoRepo extends JpaRepository<userInfo, Long> {

		userInfo save(User user1);

	}




