package com.promostree.domain.user;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
@Entity(name="user_preference")
@Table(name="user_preference")
public class UserPreference
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@OneToOne
@JoinColumn(name="typeId")
@JsonManagedReference
private Type type;

@Temporal(TemporalType.DATE)
private Date createdDate;


private Long value;

@ManyToOne
@JoinColumn(name="userId")
@JsonBackReference
private User user;


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
public Long getValue() {
	return value;
}
public void setValue(Long value) {
	this.value = value;
}





}