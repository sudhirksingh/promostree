package com.promostree.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.promostree.domain.entities.Location;


@Entity(name="userProfile")
@Table(name="userProfile")
public class UserProfile
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String fristName;
private String lastName;
//private String homeLocationId;
//private String officeLocationId;
private boolean isReg;

@OneToOne
@JoinColumn(name="userId")
private User user;

@OneToOne
@JoinColumn(name="homeLocationId")
private Location homeLocation;

@OneToOne
@JoinColumn(name="officeLocationId")
private Location officeLocation;




public Location getHomeLocation() {
	return homeLocation;
}
public void setHomeLocation(Location homeLocation) {
	this.homeLocation = homeLocation;
}
public Location getOfficeLocation() {
	return officeLocation;
}
public void setOfficeLocation(Location officeLocation) {
	this.officeLocation = officeLocation;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFristName() {
	return fristName;
}
public void setFristName(String fristName) {
	this.fristName = fristName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public boolean isReg() {
	return isReg;
}
public void setReg(boolean isReg) {
	this.isReg = isReg;
}





}