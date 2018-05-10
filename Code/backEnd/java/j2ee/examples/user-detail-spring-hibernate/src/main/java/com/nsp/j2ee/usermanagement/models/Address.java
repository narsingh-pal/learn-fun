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
@Table(name = "addressDetail")
@SequenceGenerator(name = "addressDetail_seq", allocationSize = 1, sequenceName = "addressDetail_seq")
public class Address implements Serializable{
	private static final long serialVersionUID = 1183355946535119625L;
	private Long addressDetailId;
	private String addressId;
	private String address_line1;
	private String address_line2;
	private String zipcode;
	private String city;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "addressDetail_seq")
	@Column(name = "addressDetailId", unique = true, nullable = false)
	public Long getAddressDetailId() {
		return addressDetailId;
	}
	public void setAddressDetailId(Long id) {
		this.addressDetailId = id;
	}
	
	@Column(name = "addressId", length = 50)
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "addressLine1", length = 50)
	public String getAddressLine1() {
		return address_line1;
	}
	public void setAddressLine1(String address_line1) {
		this.address_line1 = address_line1;
	}
	
	@Column(name = "addressLine2", length = 50)
	public String getAddressLine2() {
		return address_line2;
	}
	public void setAddressLine2(String address_line2) {
		this.address_line2 = address_line2;
	}
	
	@Column(name = "zipcode", length = 50)
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Column(name = "city", length = 50)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
	
	
	
}
