package com.promostree.domain.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement(name = "user")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "user")
@Table(name = "user")
public class User {
	@XmlElement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String email;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JsonIgnore
	@JsonManagedReference
	private UserProfile userProfile;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserLocation> userLocations;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	private List<UserPreference> userPreferences;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserFeedback> userFeedback;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<UserShare> userShares;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@JsonIgnore
	private List<UserShout> userShout;

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	// @JsonBackReference
	private TargetUser targetUsers;

	@JsonIgnore
	public List<UserLocation> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}

	public TargetUser getTargetUsers() {
		return targetUsers;
	}

	public void setTargetUsers(TargetUser targetUsers) {
		this.targetUsers = targetUsers;
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
}