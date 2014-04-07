package com.promostree.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="address")
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String landMark;
	@NotBlank(message = "city must filled")
	private String city;
	private String state;
	 @NotBlank(message = "country must filled")
	private String country;
	private String zip;
	
	@OneToOne
	@JoinColumn(name="locationId",nullable=true)
	@JsonBackReference
	private Location location;
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}
