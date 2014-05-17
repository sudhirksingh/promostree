package com.promostree.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="UserShare")
public class NotificationUserShare extends Notification{

	@ManyToOne
	@JoinColumn(name="UserShareId")
	private UserShare userShare;

	public UserShare getUserShare() {
		return userShare;
	}

	public void setUserShare(UserShare userShare) {
		this.userShare = userShare;
	}

	
}




