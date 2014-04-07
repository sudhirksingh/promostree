package com.promostree.domain.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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


@XmlRootElement(name="user")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="user")
@Table(name="user")
public class User
{
	@XmlElement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	@XmlElement
private String phoneNumber;
	@XmlElement
private String email;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<UserEvent> userEvent;
	
	@OneToOne(mappedBy="user")
	private UserProfile userProfile; 
	
	
	@OneToMany(mappedBy="user")
	private List<UserPreferences> userPreferences;
	
	@OneToMany(mappedBy="user")
	private List<UserFeedback> userFeedback;
	
	@OneToMany(mappedBy="user")
	private List<UserShares> userShares;
	
	@OneToMany(mappedBy="user")
	private List<UserShout> userShout;
	
	
	
	public List<UserFeedback> getUserFeedback() {
		return userFeedback;
	}
	public void setUserFeedback(List<UserFeedback> userFeedback) {
		this.userFeedback = userFeedback;
	}
	public List<UserShares> getUserShares() {
		return userShares;
	}
	public void setUserShares(List<UserShares> userShares) {
		this.userShares = userShares;
	}
	public List<UserShout> getUserShout() {
		return userShout;
	}
	public void setUserShout(List<UserShout> userShout) {
		this.userShout = userShout;
	}
	public List<UserPreferences> getUserPreferences() {
		return userPreferences;
	}
	public void setUserPreferences(List<UserPreferences> userPreferences) {
		this.userPreferences = userPreferences;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public List<UserEvent> getUserEvent() {
		return userEvent;
	}
	public void setUserEvent(List<UserEvent> userEvent) {
		this.userEvent = userEvent;
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