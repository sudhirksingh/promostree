package com.promostree.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity(name="user_location_type")
@Table(name="user_location_type")
public class LocationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;

@OneToOne(mappedBy="locationType",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JsonBackReference
private UserLocations userLocations;



public UserLocations getUserLocations() {
	return userLocations;
}
public void setUserLocations(UserLocations userLocations) {
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


}
