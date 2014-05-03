package com.promostree.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Location;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.TypeRepository;
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
	TypeRepository typeRepository;
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
	VenueRepository venueRepository;

	// for user Registration
	@Override
	public User saveUserCredentials(User user) {
		User dbUser = null;
		if (user!= null) {
			if (user.getPhoneNumber()!= null && user.getEmail() == null) {
				dbUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
				if (dbUser == null) {
					dbUser = userRepository.save(user);
				}
			} 
			else if (user.getEmail() != null && user.getPhoneNumber() == null) {
				dbUser = userRepository.findByEmail(user.getEmail());
				if (dbUser == null) {
					dbUser = userRepository.save(user);
				}
			} 
			//if (user.getPhoneNumber() != null && user.getEmail() != null)
			else  {
				User dbemail = userRepository.findByEmail(user.getEmail());
				User dbphone = userRepository.findByPhoneNumber(user.getPhoneNumber());
				if (dbemail.getEmail() == null && dbphone.getPhoneNumber() == null) {
					dbUser = userRepository.findByPhoneNumberAndEmail(user.getPhoneNumber(), user.getEmail());
					if (dbUser == null) {
						dbUser = userRepository.save(user);
					}
				}
					else  {
							dbUser = userRepository.findByPhoneNumberAndEmail(
									user.getPhoneNumber(), user.getEmail());
							if (!dbemail.getEmail().equals(user.getEmail())
									&& !dbphone.getPhoneNumber().equals(
											user.getPhoneNumber())) {
							if (dbUser == null) {
								dbUser = userRepository.save(user);
							}
							
						}
							return dbUser;
					}
				}
			}
		return dbUser;
	}

	// for storing the user shout

	public String saveUserShout(UserShout userShout) {
		userShout.setUser(userRepository.findById(userShout.getUser().getId()));
		userShout.setVenue(venueRepository.findById(userShout.getVenue()
				.getId()));
		UserShout dbusershout = userShoutRepository.save(userShout);
		if (dbusershout.equals(userShout))
			return "stored successfully......";
		else
			return "not stored";
	}

	public String saveUserPreference(UserPreference userPreference) {
		// List<UserPreference> userpreList = null;
		Long userid = userPreference.getUser().getId();
		userPreference.setUser(userRepository.findById(userid));
		userPreference.setType(typeRepository.findById(userPreference.getType()
				.getId()));
		UserPreference dbuserPreference = userPreferencesRepository
				.save(userPreference);
		if (userPreference.equals(dbuserPreference)) {
			// userpreList = userPreferencesRepository.findByUserId(userid);
			return "successfully Stored";
		}
		return "notStored";
	}

	public List<UserPreference> readUserPreferences(User user) {
		List<UserPreference> userpreList = null;
		userpreList = userPreferencesRepository.findByUserId(user.getId());
		return userpreList;

		/*
		 * List<UserPreference> userpreferences=user.getUserPreferences();
		 * List<UserPreference> userpreList = new ArrayList<UserPreference>();
		 * for(UserPreference userPreference:userpreferences) { Long userid =
		 * userPreference.getUser().getId();
		 * userPreference.setUser(userRepository.findById(userid));
		 * userPreference
		 * .setType(typeRepository.findById(userPreference.getType().getId()));
		 * if(userPreference!=null) userpreList =
		 * userPreferencesRepository.findByUserId(userid); } return userpreList;
		 */
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

	// to read user Preferences

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

	@Override
	public List<UserShout> readUserShout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
