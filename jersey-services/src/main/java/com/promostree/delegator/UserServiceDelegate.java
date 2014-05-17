package com.promostree.delegator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.user.service.UserServices;

@Component
public class UserServiceDelegate {
	@Autowired
	UserServices userServices;


	// to Registration
	public User saveUserCredentials(User user) {
		User dbUser = userServices.saveUserCredentials(user);
		return dbUser;
	}

	public String saveUserPreference(UserPreference userPreference) {
		String dbuser = userServices.saveUserPreference(userPreference);
		return dbuser;

	}

	// to savetheusershout
	public String saveUserShout(UserShout userShout) {
		String ushout = userServices.saveUserShout(userShout);
		return ushout;
	}

	
	// to share
	public boolean saveUserShares(NotificationUserShare notificationUserShares) {
		Boolean save = userServices.saveUserShare(notificationUserShares);
		return save;
	}


	

   //to read notifications
	public List<Notification>  readNotifications(User user)
	{
		List<Notification> notifications=new ArrayList<Notification>();
		return notifications;// userServices.readNotifications(user);
	}
	//to save user feedback
	public boolean saveUserFeedback(NotificationUserFeedback notificationUserShare){
		return userServices.saveUserFeedback(notificationUserShare);
	}


	

}
