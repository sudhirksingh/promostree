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

@Entity(name="userFeedback")
@Table(name="userFeedback")
public class UserFeedback
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String comment;
private Date createdDate;
private Date updatedDate;

private String value;

@ManyToOne
@JoinColumn(name="userId")
private User user;

@OneToOne
@JoinColumn(name="typeId")
private Type type;



public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
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

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public Date getUpdatedDate() {
	return updatedDate;
}

public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}

public Type getType() {
	return type;
}

public void setType(Type type) {
	this.type = type;
}




}