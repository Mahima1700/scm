package com.scm.scm.entity;

import java.time.LocalDate;

import com.scm.scm.repository.userInfoRepo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "userInfo")
@Table(name = "usersInfo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userInfo {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	 @Column
	    private String address;
	 @Column
	    private String phone;
	 @Column
	    private String gender;
	 @Column
	    private String Dob;
	 
	 @Column
	    private String State;

	public String getAddress() {
		return address;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String localDate) {
		Dob = localDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
	
	@ManyToOne
	@JoinColumn(name = "uid", nullable = false)
	private User user;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	




	

	
}
