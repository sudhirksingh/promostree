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

import com.promostree.domain.entities.Venue;

@Entity(name="user_shout")
@Table(name="user_shout")
public class UserShout
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

	@Temporal(TemporalType.DATE)
private Date createdDate;
private String comment;

@ManyToOne
@JoinColumn(name="userId")
@JsonBackReference(value="user-userShout")
private User user;

@OneToOne
@JoinColumn(name="venueId")
@JsonManagedReference
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((comment == null) ? 0 : comment.hashCode());
	result = prime * result
			+ ((createdDate == null) ? 0 : createdDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	result = prime * result + ((venue == null) ? 0 : venue.hashCode());
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
	UserShout other = (UserShout) obj;
	if (comment == null) {
		if (other.comment != null)
			return false;
	} else if (!comment.equals(other.comment))
		return false;
	if (createdDate == null) {
		if (other.createdDate != null)
			return false;
	} else if (!createdDate.equals(other.createdDate))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	if (venue == null) {
		if (other.venue != null)
			return false;
	} else if (!venue.equals(other.venue))
		return false;
	return true;
}

/*@Override
public String toString() {
	return "UserShout [id=" + id + ", createdDate=" + createdDate
			+ ", comment=" + comment + ", user=" + user + ", venue=" + venue
			+ "]";
}
*/





}