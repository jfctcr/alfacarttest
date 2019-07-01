package com.wldnist.alfacarttest.model;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wldnist.alfacarttest.config.CustomerDateAndTimeDeserialize;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "full_name", length=255, nullable = true)
	private String full_name;
	
	@Column(name = "address", length=255, nullable = true)
	private String address;
	
	@Column(name = "dob", updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal (TemporalType.TIMESTAMP)
	@JsonDeserialize(using= CustomerDateAndTimeDeserialize.class)
	private Date dob;
	
	@Column(name = "role_id", nullable = false)
	private Long role_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}	
	

}
