package com.promostree.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.Notification1;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserLocationsRepository;
import com.promostree.repositories.user.UserPreferencesRepository;
import com.promostree.repositories.user.UserProfileRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.repositories.user.UserSharesRepository;
import com.promostree.repositories.user.UserShoutRepository;

@Component
public class UserServiceImpl implements UserServices {

	@Autowired
	UserSharesRepository userSharesRepository;
	@Autowired
	NotificationRepository notificationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UserPreferencesRepository userPreferencesRepository;
	@Autowired
	UserLocationsRepository userLocationsRepository;
	@Autowired
	LocationTypeRepository locationTypeRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	UserFeedbackRepository userFeedbackRepository;
	@Autowired
	UserShoutRepository userShoutRepository;
	@Autowired
	EventTypeRepository eventTypeRepository;

	// for user Registration
	public UserProfile saveUserCredentials(User user) {
		User u = null;
		UserProfile uprofile = null;
		if (user != null) {
			u = userRepository.findByPhoneNumberOrEmail(user.getPhoneNumber(),
					user.getEmail());
			if (u == null) {
				User use = userRepository.save(user);
				uprofile = userProfileRepository.findOne(use.getId());
				return uprofile;
			} else
				uprofile = userProfileRepository.findOne(u.getId());
		}
		return uprofile;
	}

	// for storing the user shout

	public String saveUserShout(UserShout userShout) {
		UserShout usershout = userShoutRepository.save(userShout);
		if (usershout.equals(userShout))
			return "stored successfully......";
		else
			return "not stored";
	}

	// read user shouts
	public List<UserShout> readUserShout(User user) {
		return userShoutRepository.findByUserId(user.getId());
	}

	// to save user share
	public boolean saveUserShares(UserShare userShare) {
		UserShare userShare2 = userSharesRepository.save(userShare);

		Notification notification = new Notification();
		notification.setCreatedDate(new Date());
		EventType eventType = eventTypeRepository.findOne(1L);
		notification.setEventType(eventType);
		notification.setUser(userShare.getUser());
		notification.setUserShare(userShare2);
		notificationRepository.save(notification);

		return true;

	}

	// to get shares which i posted
	public List<UserShare> readPostedUserShares(User user) {
		return userSharesRepository.findByUserId(user.getId());
	}

	// to get shares which i received from different users

	public List<UserShare> readRecievedUserShares(User user) {
		List<UserShare> userShares = new ArrayList<UserShare>();
		List<Notification> notifications = notificationRepository
				.findByUserId(user.getId());
		for (Notification notification : notifications) {
			userShares.add(userSharesRepository.findOne(notification
					.getUserShare().getId()));
		}
		return userShares;
	}

	public UserProfile saveUserProfile(UserProfile userProfile) {
		UserProfile userProfile1 = userProfileRepository.save(userProfile);

		return userProfile1;
	}

	// to save user preferences

	public boolean saveUserPreference(List<UserPreference> userPreferences) {
		UserPreference userPreference = new UserPreference();
		for (UserPreference userPreference2 : userPreferences) {
			userPreference2.setCreatedDate(new Date());
			userPreferencesRepository.save(userPreference2);
		}
		return true;
	}

	/*
	 * @Override public UserPreference deleteUserPreferences(UserPreference
	 * userPreferences){ userPreferencesRepository.delete(userPreferences);
	 * return userPreferences; }
	 */

	// to read user Preferences wrong

	public List<UserPreference> readUserPreferences(User user) {

		return userPreferencesRepository.findByUserId(user.getId());
	}

	public UserLocation saveUserLocations(UserLocation userLocations) {
		UserLocation userLocations1 = userLocationsRepository
				.save(userLocations);
		return userLocations1;
	}

	public boolean saveLocationType(LocationType locationType) {
		LocationType locationType1 = locationTypeRepository.save(locationType);
		if (locationType1.equals(locationType))
			return true;
		else
			return false;
	}

	public Location saveLocation(Location location) {
		Location location1 = locationRepository.save(location);
		return location1;
	}

	// to save user feedback
	public boolean saveUserFeedback(UserFeedback userFeedback) {
		userFeedback.setCreatedDate(new Date());
		userFeedbackRepository.save(userFeedback);

		Notification notification = new Notification();
		notification.setCreatedDate(new Date());
		EventType eventType = eventTypeRepository.findOne(1L);
		notification.setEventType(eventType);
		// notification.setUser(userFeedback.getUser());
		notification.setUserFeedback(userFeedback);
		notificationRepository.save(notification);

		return true;
	}

	@Override
	public List<Notification1> readNotifications(User user) {
		List<Notification1> notification1s = new ArrayList<Notification1>();
	Notification1 notification1=new Notification1();
		List<Notification> notifications = notificationRepository
				.findByUserId(user.getId());
	
		for (Notification notification : notifications) {
			UserShare userShare=notification.getUserShare();
if(notification.getEventType().getId()==2 && userShare.getType().getId()==2){
	notification1.setActivity_type("shared");
	notification1.setUserShare(userShare);
    notification1.setUser(userRepository.findById(userShare.getUser().getId()));
    
}
		}
		return null;
	}

}
