package com.promostree.domain.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.promostree.domain.entities.Location;

@Entity(name="userLocations")
@Table(name="userLocations")
public class UserLocations
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private Date createdDate ;

@OneToOne
@JoinColumn(name="userId")
private User user;

@OneToOne
@JoinColumn(name="locationId")
private Location location;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Location getLocation() {
	return location;
}

public void setLocation(Location location) {
	this.location = location;
} 




}