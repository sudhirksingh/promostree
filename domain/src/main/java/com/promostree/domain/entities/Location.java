package com.promostree.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.promostree.domain.user.UserLocation;


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
	private UserLocation userLocations;
	
	
	
	
	
	

	public UserLocation getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(UserLocation userLocations) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", lat=" + lat + ", lng=" + lng
				+ ", address=" + address + ", userLocations=" + userLocations
				+ "]";
	}

	
}
