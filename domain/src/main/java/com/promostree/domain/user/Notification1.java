package com.promostree.domain.user;

import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Venue;

public class Notification1 {
	private User user;
	private String activity_type;
	private String source_type;
	private UserProfile userProfile;
	private UserShare userShare;
	private UserFeedback userFeedback;
	private Venue venue;
	private Offer offer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public String getSource_type() {
		return source_type;
	}
	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public UserShare getUserShare() {
		return userShare;
	}
	public void setUserShare(UserShare userShare) {
		this.userShare = userShare;
	}
	public UserFeedback getUserFeedback() {
		return userFeedback;
	}
	public void setUserFeedback(UserFeedback userFeedback) {
		this.userFeedback = userFeedback;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
