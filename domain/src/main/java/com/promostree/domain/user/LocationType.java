package com.promostree.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="user_location_type")
@Table(name="user_location_type")
public class LocationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;

@OneToOne(mappedBy="locationType",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JsonBackReference
private UserLocation userLocations;



public UserLocation getUserLocations() {
	return userLocations;
}
public void setUserLocations(UserLocation userLocations) {
	this.userLocations = userLocations;
}
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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	LocationType other = (LocationType) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
/*@Override
public String toString() {
	return "LocationType [id=" + id + ", name=" + name + ", userLocations="
			+ userLocations + "]";
}*/


}
