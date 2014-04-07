package com.promostree.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity(name="userPreferences")
@Table(name="userPreferences")
public class UserPreferences
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@OneToOne
@JoinColumn(name="preferenceTypeId")
private Type type;
private String value;

@ManyToOne
@JoinColumn(name="userId")
private User user;


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



public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}





}