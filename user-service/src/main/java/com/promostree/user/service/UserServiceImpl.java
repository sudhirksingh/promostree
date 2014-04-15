package com.promostree.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.TargetUsersRepository;
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
	TargetUsersRepository targetUsersRepository;
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
	private List<UserShare> userShares;

	// to post shares
	@Override
	public boolean saveUserShares(UserShare userShares) {
		UserShare userShares1 = userSharesRepository.save(userShares);
		if (userShares1.equals(userShares))
			return true;
		else
			return false;
	}

	// to get shares which i posted
	@Override
	public List<UserShare> readPostedUserShares(long userId) {
		return userSharesRepository.findByUserId(userId);
	}

	// to get shares which i received from different users
	@Override
	public List<UserShare> readRecievedUserShares(Long userId) {
		userShares = new ArrayList<UserShare>();
		List<TargetUser> targetUsers = targetUsersRepository
				.findByUserId(userId);
		for (TargetUser targetUser : targetUsers) {
			System.out.println(targetUser.getId());
			userShares.add(targetUser.getUserShares());
		}
		return userShares;
	}

	@Override
	public User saveUserCredentials(User user) {
		User u = userRepository.findByPhoneNumber(user.getPhoneNumber());
		if (u.equals(null)) {
			userRepository.save(user);
			return null;
		}
		return user;
	}
 
	@Override
	public boolean saveUserShout(UserShout userShout) {
		UserShout usershout = userShoutRepository.save(userShout);
		if (usershout.equals(userShout))
			return true;
		else
			return false;
	}
  
	@Override
	public List<UserShout> readUserShout(User user) {
		return userShoutRepository.findByUserId(user.getId());
	}

	@Override
	public UserProfile saveUserProfile(UserProfile userProfile) {
		UserProfile userProfile1 = userProfileRepository.save(userProfile);

		return userProfile1;
	}

	// to save user preferences
	@Override
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
	@Override
	public List<UserPreference> readUserPreferences(User user) {
		return userPreferencesRepository.findByUserId(user.getId());

	}

	@Override
	public UserLocation saveUserLocations(UserLocation userLocations) {
		UserLocation userLocations1 = userLocationsRepository
				.save(userLocations);
		return userLocations1;
	}

	@Override
	public boolean saveLocationType(LocationType locationType) {
		LocationType locationType1 = locationTypeRepository.save(locationType);
		if (locationType1.equals(locationType))
			return true;
		else
			return false;
	}

	@Override
	public Location saveLocation(Location location) {
		Location location1 = locationRepository.save(location);
		return location1;
	}

	@Override
	public boolean saveUserFeedback(UserFeedback userFeedback) {
		UserFeedback userfeedback = userFeedbackRepository.save(userFeedback);
		if (userfeedback.equals(userFeedback))
			return true;
		else
			return false;
	}
	

}
