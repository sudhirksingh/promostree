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

@Entity(name = "type")
@Table(name = "type")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@OneToOne(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private UserPreference userPreferences;

	@OneToOne(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private UserFeedback userFeedback;

	@OneToOne(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private UserShare userShares;

	public UserFeedback getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(UserFeedback userFeedback) {
		this.userFeedback = userFeedback;
	}

	public UserShare getUserShares() {
		return userShares;
	}

	public void setUserShares(UserShare userShares) {
		this.userShares = userShares;
	}

	public UserPreference getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(UserPreference userPreferences) {
		this.userPreferences = userPreferences;
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

<<<<<<< HEAD
	public void setName(String name) {
		this.name = name;
	}
=======

public UserPreference getUserPreferences() {
	return userPreferences;
}
public void setUserPreferences(UserPreference userPreferences) {
	this.userPreferences = userPreferences;
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
	Type other = (Type) obj;
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
	return "Type [id=" + id + ", name=" + name + ", userPreferences="
			+ userPreferences + ", userFeedback=" + userFeedback
			+ ", userShares=" + userShares + "]";
}*/





>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95

}