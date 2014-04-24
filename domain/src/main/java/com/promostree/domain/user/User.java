package com.promostree.domain.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.promostree.domain.tenant.Tenant;

@Entity(name = "user")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String phoneNumber;

	private String email;

	@Transient
	private Double lat;
	@Transient
	private Double lng;
	@Transient
	private Double radius;
	@Transient
	private int pageNumber;
	@Transient
	private String searchTerm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenantId")
	@JsonBackReference
	private Tenant tenant;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userProfile")
	private UserProfile userProfile;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userLocations")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserLocation> userLocations;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userPreferences")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserPreference> userPreferences;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userFeedback")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserFeedback> userFeedback;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userShares")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserShare> userShares;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference(value = "user-userShout")
	private List<UserShout> userShout;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Notification> notification;

	@JsonIgnore
	public List<UserLocation> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}

	public List<UserFeedback> getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(List<UserFeedback> userFeedback) {
		this.userFeedback = userFeedback;
	}

	public List<UserShare> getUserShares() {
		return userShares;
	}

	public void setUserShares(List<UserShare> userShares) {
		this.userShares = userShares;
	}

	public List<UserShout> getUserShout() {
		return userShout;
	}

	public void setUserShout(List<UserShout> userShout) {
		this.userShout = userShout;
	}

	public List<UserPreference> getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(List<UserPreference> userPreferences) {
		this.userPreferences = userPreferences;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result
				+ ((notification == null) ? 0 : notification.hashCode());
		result = prime * result + pageNumber;
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result
				+ ((searchTerm == null) ? 0 : searchTerm.hashCode());
		result = prime * result
				+ ((userFeedback == null) ? 0 : userFeedback.hashCode());
		result = prime * result
				+ ((userLocations == null) ? 0 : userLocations.hashCode());
		result = prime * result
				+ ((userPreferences == null) ? 0 : userPreferences.hashCode());
		result = prime * result
				+ ((userShares == null) ? 0 : userShares.hashCode());
		result = prime * result
				+ ((userShout == null) ? 0 : userShout.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		if (searchTerm == null) {
			if (other.searchTerm != null)
				return false;
		} else if (!searchTerm.equals(other.searchTerm))
			return false;
		if (userFeedback == null) {
			if (other.userFeedback != null)
				return false;
		} else if (!userFeedback.equals(other.userFeedback))
			return false;
		if (userLocations == null) {
			if (other.userLocations != null)
				return false;
		} else if (!userLocations.equals(other.userLocations))
			return false;
		if (userPreferences == null) {
			if (other.userPreferences != null)
				return false;
		} else if (!userPreferences.equals(other.userPreferences))
			return false;
		if (userShares == null) {
			if (other.userShares != null)
				return false;
		} else if (!userShares.equals(other.userShares))
			return false;
		if (userShout == null) {
			if (other.userShout != null)
				return false;
		} else if (!userShout.equals(other.userShout))
			return false;
		return true;
	}

	/*
	 * @Override public String toString() { return "User [id=" + id +
	 * ", phoneNumber=" + phoneNumber + ", email=" + email + ", lat=" + lat +
	 * ", lng=" + lng + ", radius=" + radius + ", pageNumber=" + pageNumber +
	 * ", searchTerm=" + searchTerm + ", tenant=" + tenant + ", userProfile=" +
	 * userProfile + ", userLocations=" + userLocations + ", userPreferences=" +
	 * userPreferences + ", userFeedback=" + userFeedback + ", userShares=" +
	 * userShares + ", userShout=" + userShout + ", notification=" +
	 * notification + "]"; }
	 */

}