package com.scm.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm.entity.userInfo;
import com.scm.scm.repository.userInfoRepo;
import com.scm.scm.service.userInfoService;

import jakarta.servlet.http.HttpSession;

public class userInfoController {

	 @Autowired  
	  userInfoService uservice;
	  @Autowired userInfoRepo userInfoRepo;
	private userInfo uinfo;
	 
	
	/*
	 * @GetMapping("/info") public String info() {
	 * System.out.println("userinfo page handler"); return "userinfo"; }
	 */
		/*
		 * @RequestMapping(value = "/do-register", method = RequestMethod.POST) public
		 * String processRegister(@ModelAttribute userInfo uinfo, HttpSession session) {
		 * 
		 * System.out.println("Processing registration");
		 * 
		 * 
		 * 
		 * 
		 * userInfoRepo.save(uinfo);
		 * session.setAttribute("message","User Register Sucessful!!!!"); return
		 * "redirect:/dashboard"; }
		 */
}
