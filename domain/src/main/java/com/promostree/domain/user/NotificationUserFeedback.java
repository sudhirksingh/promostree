package com.promostree.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue(value="UserFeedback")
public class NotificationUserFeedback extends Notification {
	
	@ManyToOne
	@JoinColumn(name="UserFeedbackId")
	private UserFeedback userFeedback;

	public UserFeedback getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(UserFeedback userFeedback) {
		this.userFeedback = userFeedback;
	}
	
	

}
