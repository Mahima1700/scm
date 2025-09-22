package com.scm.scm.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long uid;
	   
	    @Column(name = "username", nullable = false)
	    private String username;
	    
	    @Column
	    private String name;
	    
	    @Column(unique = true, nullable = false)
	    private String email;
	    
	    @Column
	    private String password;
	    
	    @Column
	    private String role;

		public Long getUid() {
			return uid;
		}

		public void setUid(Long uid) {
			this.uid = uid;
		}

		public String getUsername() {
			return username;
		}

		public void setUname(String username) {
			this.username = username;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	    
	
		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<userInfo> userInfo;

		public User save(User user) {
			// TODO Auto-generated method stub
			return null;
		}

	 


}
