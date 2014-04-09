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
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import com.promostree.domain.user.UserLocations;
import com.promostree.domain.user.UserPreferences;
import com.promostree.domain.user.UserProfile;


@Entity(name="location")
@Table(name="location")
public class Location {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
		private double lat;
	@NotNull
		private double lng;
	
	
	
	
	@OneToOne(mappedBy="location",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonBackReference
	private Address address;
	
	
	@OneToOne(mappedBy="location",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private UserLocations userLocations;
	
	
	
	
	
	

	public UserLocations getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(UserLocations userLocations) {
		this.userLocations = userLocations;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	
}
