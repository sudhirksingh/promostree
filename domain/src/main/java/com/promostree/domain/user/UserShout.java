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

import com.promostree.domain.entities.Venue;

@Entity(name="userShout")
@Table(name="userShout")
public class UserShout
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;


private Date createdDate;
private String comment;

@ManyToOne
@JoinColumn(name="userId")
private User user;

@OneToOne
@JoinColumn(name="venueId")
private Venue venue;




public Venue getVenue() {
	return venue;
}

public void setVenue(Venue venue) {
	this.venue = venue;
}

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

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}






}