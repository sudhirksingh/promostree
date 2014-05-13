package com.promostree.user.service;

import java.util.List;

import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShout;

public interface UserServices 
{
public User saveUserCredentials(User user);	
public String saveUserShout(UserShout userShout);

public String  saveUserPreference(UserPreference userPreference);
public List<UserPreference> readUserPreferences(User user);


public boolean saveUserFeedback(NotificationUserFeedback notificationUserFeedback);
public boolean saveUserShares(NotificationUserShare notificationUserShare);
public List<Notification> readNotifications(User user);



}
