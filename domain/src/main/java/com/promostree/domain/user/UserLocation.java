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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.promostree.domain.entities.Location;

@Entity(name = "user_location")
@Table(name = "user_location")
public class UserLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
<<<<<<< HEAD
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;

	@OneToOne
	@JoinColumn(name = "locationTypeId")
	@JsonManagedReference
	private LocationType locationType;

	@OneToOne
	@JoinColumn(name = "locationId")
	@JsonManagedReference
	private Location location;

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
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
=======
private Date createdDate ;

@ManyToOne
@JoinColumn(name="userId")
@JsonBackReference(value="user-userLocations")
private User user;

@OneToOne
@JoinColumn(name="locationTypeId")
@JsonManagedReference
private LocationType locationType;

@OneToOne
@JoinColumn(name="locationId")
@JsonManagedReference
private Location location;





public LocationType getLocationType() {
	return locationType;
}

public void setLocationType(LocationType locationType) {
	this.locationType = locationType;
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((createdDate == null) ? 0 : createdDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result
			+ ((locationType == null) ? 0 : locationType.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	UserLocation other = (UserLocation) obj;
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
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (locationType == null) {
		if (other.locationType != null)
			return false;
	} else if (!locationType.equals(other.locationType))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}

/*@Override
public String toString() {
	return "UserLocation [id=" + id + ", createdDate=" + createdDate
			+ ", user=" + user + ", locationType=" + locationType
			+ ", location=" + location + "]";
} */



>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95

}