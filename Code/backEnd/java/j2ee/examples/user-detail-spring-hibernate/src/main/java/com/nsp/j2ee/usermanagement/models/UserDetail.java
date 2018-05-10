package com.nsp.j2ee.usermanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userDetail")
@SequenceGenerator(name = "userDetail_seq", allocationSize = 1, sequenceName = "userDetail_seq")
public class UserDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8470074838125378510L;
	private Long userDetailId;
	private String userId;
	private String screenName;
	private String email;
	private String firstName;
	private String lastName;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userDetail_seq")
	@Column(name = "userDetailId", unique = true, nullable = false)
	public Long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(Long id) {
		this.userDetailId = id;
	}
	
	@Column(name = "userId", length = 50)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "screenName", length = 50)
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "firstName", length = 50)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "lastName", length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public UserDetail(Long id, String userId, String screenName, String email, String firstName, String lastName) {
		super();
		this.userDetailId = id;
		this.userId = userId;
		this.screenName = screenName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserDetail(String email) {
		super();
		this.email = email;
	}
	
	public UserDetail(String userId, String screenName, String email, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.screenName = screenName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserDetail() {
		super();
	}

	public UserDetail(Long id) {
		super();
		this.userDetailId = id;
	}
	
	
	@Override
	public String toString() {
		return "UserDetail [id=" + userDetailId + ", userId=" + userId + ", screenName=" + screenName + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
}
