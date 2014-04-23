package com.promostree.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
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
	//read user shouts
	public List<UserShout> readUserShout(User user) {
		return userShoutRepository.findByUserId(user.getId());
	}
	
	// to save user share
	public boolean saveUserShares(UserShare userShares) {
		UserShare userShare = userSharesRepository.save(userShares);
		if (userShare.equals(userShare))
			return true;
		else
			return false;
	}

	// to get shares which i posted
	public List<UserShare> readPostedUserShares(User user) {
		return userSharesRepository.findByUserId(user.getId());
	}

	// to get shares which i received from different users
	
	public List<UserShare> readRecievedUserShares(User user) {
	
		return null;
	}



	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		UserProfile userProfile1 = userProfileRepository.save(userProfile);

		return userProfile1;
	}

	// to save user preferences
	
	public List<UserPreference> saveUserPreference(
			List<UserPreference> userPreferences) {
		return userPreferencesRepository.save(userPreferences);
	}

	/*
	 * @Override public UserPreference deleteUserPreferences(UserPreference
	 * userPreferences){ userPreferencesRepository.delete(userPreferences);
	 * return userPreferences; }
	 */

	// to read user Preferences

	
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

	
	public boolean saveUserFeedback(UserFeedback userFeedback) {
		UserFeedback userfeedback = userFeedbackRepository.save(userFeedback);
		if (userfeedback.equals(userFeedback))
			return true;
		else
			return false;
	}

}
