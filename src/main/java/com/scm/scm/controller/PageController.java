package com.scm.scm.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.scm.entity.User;
import com.scm.scm.entity.userInfo;
import com.scm.scm.forms.UserForm;
import com.scm.scm.repository.UserRepo;
import com.scm.scm.repository.userInfoRepo;
import com.scm.scm.service.UserService;
import com.scm.scm.service.userInfoService;

import jakarta.servlet.http.HttpSession;



@Controller
public class PageController {
	
	  @Autowired  
	  UserService service;
	  @Autowired  UserRepo userRepo;
	private User u;
	
	 @Autowired  
	  userInfoService uservice;
	  @Autowired userInfoRepo userInfoRepo;
	private userInfo uinfo;
	 
	 
	
	
	  
		/*
		
	 * @GetMapping("/home") public String home() {
	 * System.out.println("home page handler"); return "home"; }
	 */
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String home(Model model) {
		model.addAttribute("name", "Web Content");
		model.addAttribute("Youtube", "https://www.youtube.com/");
		model.addAttribute("github", "https://github.com/");
		  System.out.println("home page handler");
		return "home";
	}
	
	
	
	/*
	 * @GetMapping("/user") private List<User> getAllUser() { return
	 * service.getAlluser(); }
	 * 
	 * @PostMapping("/user") private int saveempEntity(@RequestBody User emp) {
	 * service.saveOrUpdate(emp); return emp.getUid(); }
	 */

	@GetMapping("/api/user/{uid}")
	@ResponseBody
	public User getUserById(@PathVariable Long uid) {
	    return service.getUserById(uid); // Replace with your method
	}

	
	  @GetMapping("/about")
	  @PreAuthorize("hasAuthority('ROLE_USER')")
	  public String about() {
	   System.out.println("about page handler"); return "about"; }
	  
	  
	  
	  @GetMapping("/service") 
	  @PreAuthorize("hasAuthority('ROLE_USER')")public String service() {
	  System.out.println("service page handler"); return "service"; }
	  
	  @GetMapping("/contact")
	  @PreAuthorize("hasAuthority('ROLE_USER')")public String contact() {
		  System.out.println("contact page handler"); return "contact"; }

	  
	  @GetMapping("/login")
	  @PreAuthorize("hasAuthority('ROLE_USER')")public String login() {
		  System.out.println("login page handler");
		  return "login"; }
	 
	  
	  @GetMapping("/register")
	  @PreAuthorize("hasAuthority('ROLE_USER')")
	  public String sign(Model model) {
		  UserForm userForm = new UserForm();
		  model.addAttribute("userForm",userForm);
		  System.out.println("register page handler");
		  return "register"; }
	  
	  @GetMapping("/dashboard")
	  @PreAuthorize("hasAuthority('ROLE_USER')")
	  public String db(Model model) {
		  System.out.println("dashboard page handler");
		 List<User> users = userRepo.findAll();
		 model.addAttribute("users", users);
		  return "dashboard"; }
	  
		/*
		 * @GetMapping("/dashboard/edit/{id}") public String editUser(@PathVariable Long
		 * id, Model model) { model.addAttribute("user", service.getUserById(id));
		 * return "edit"; }
		 */
	  @GetMapping("/dashboard/edit/{id}")
	  public String editUser(@PathVariable Long id, Model model) {
	      User user = service.getUserById(id);
	      model.addAttribute("user", user);
	      return "edit"; // Renders edit.html with user data
	  }

	  @PostMapping("/dashboard/edit")
	  public String updateUserByUid(@ModelAttribute("user") User user) {
	      service.updateUser(user, user.getUid());
	      return "redirect:/dashboard"; // Redirect after update
	  }
	  
	  @GetMapping("/info") 
	  @PreAuthorize("hasAuthority('ROLE_USER')")
		public String info(@RequestParam("id") Long id) {
			   System.out.println("userinfo page handler"); 
			   return "userInfoRepo.findById(id)"; 
	  }

		
			
		  @GetMapping("/dashboard/update2/{id}")
		  public String edittUser(@PathVariable("id") Long id, Model model) {
		      userInfo user = uservice.getUserById(id);
		      model.addAttribute("user", user);
		      return "userinfo"; // Renders edit.html with user data
		  }

		  @PostMapping("/dashboard/update2")
		  public String updateUserByUid(@ModelAttribute("userinfo") userInfo user) {
			  userInfoRepo.save(user);
		      uservice.updateUser(user, user.getId());
		      return "redirect:/dashboard"; // Redirect after update
		  }
		  
			/*
			 * @GetMapping("/addnew") public String addNewUser(Model model) { User user =new
			 * User(); model.addAttribute("User", user); return "newUser"; }
			 */
	  
		/*
		 * @PostMapping("/dashboard/update") public String updateUser(@ModelAttribute
		 * User user) { service.saveUser(user); return "redirect:/dashboard"; }
		 */
	  
	  @GetMapping("/dashboard/delete/{id}") 
	  public String deleteUser(@PathVariable Long id) {
	  service.deleteUser(id); 
	  return "redirect:/dashboard"; }
	  
	
	 
	 
	  
	  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
	    public String processRegister(@ModelAttribute User u, HttpSession session) {
	       
			System.out.println("Processing registration");
	        System.out.println("userForm");
			/* UUID uuid = UUID.randomUUID(); u.setUid(uuid.toString()); */
			
			  
			
	        userRepo.save(u);
	        session.setAttribute("message","User Register Sucessful!!!!");
	        return "redirect:/dashboard";
}
/*
 * @RequestMapping(value = "/do-register", method = RequestMethod.POST) public
 * String processRegister(@Valid @ModelAttribute UserForm u,BindingResult
 * rBindingResult , HttpSession session) {
 * System.out.println("Processing registration");
 * System.out.println("userForm"); UUID uuid = UUID.randomUUID();
 * u.setUid(uuid.toString());
 * 
 * 
 * //validate from data if(rBindingResult.hasErrors()) { return "register"; }
 * userRepo.save(u);
 * session.setAttribute("message","User Register Sucessful!!!!"); return
 * "redirect:/home"; }
 */ 
/*
 * @GetMapping("/dashboard") public String listUsers(Model model) {
 * model.addAttribute("user", service.getAllUsers()); return "user"; }
 * 
 * @GetMapping("/addnew") public String addNewUser(Model model) { User user =
 * new User(); model.addAttribute("User", user); return "newUser"; }
 * 
 * @GetMapping("/dashboard/edit/{id}") public String editUser(@PathVariable
 * String id, Model model) { model.addAttribute("user",
 * service.getUserById(id)); return "edit"; }
 * 
 * @PostMapping("/dashboard/update") public String updateUser(@ModelAttribute
 * User user) { service.saveUser(user); return "redirect:/dashboard"; }
 * 
 * @GetMapping("/dashboard/delete/{id}") public String deleteUser(@PathVariable
 * String id) { service.deleteUser(id); return "redirect:/dashboard"; }
 */
	    
/*
 * 
 * // Show all users on dashboard
 * 
 * @GetMapping("/dashboard") public String showDashboard(Model model) {
 * model.addAttribute("users", userRepo.findAll()); return "dashboard"; }
 * 
 * // Edit user form
 * 
 * @GetMapping("/edit/{id}") public String editUser(@PathVariable String id,
 * Model model) { User user = userRepo.findById(id).orElseThrow();
 * model.addAttribute("user", user); return "edit"; }
 * 
 * // Update user data
 * 
 * @PostMapping("/update") public String updateUser(@ModelAttribute User user) {
 * userRepo.save(user); return "redirect:/dashboard"; } // Delete user
 * 
 * @GetMapping("/delete/{id}") public String deleteUser(@PathVariable String id)
 * { userRepo.deleteById(id); return "redirect:/dashboard"; }
 */
	  
}
