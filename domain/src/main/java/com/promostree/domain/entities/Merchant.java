package com.promostree.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="merchant")
@Table(name="merchant")
public class Merchant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	 @NotBlank(message = "merchant name must filled")
	private String name;
	 @NotBlank(message = "merchant loginId must filled")
	private String loginId;
	 @NotBlank(message = "merchant pwd must filled")
	private String pwd;
	
	@ManyToOne
	@JoinColumn(name="groupId")
	@JsonBackReference
	private Groups group;
	
	
	@OneToOne
	@JoinColumn(name="venueId")
	@JsonBackReference
	private Venue venue;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	

}
