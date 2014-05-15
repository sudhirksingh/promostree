package com.promostree.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Location;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.entities.OfferRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserEventRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserLocationRepository;
import com.promostree.repositories.user.UserPreferenceRepository;
import com.promostree.repositories.user.UserProfileRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.repositories.user.UserShareRepository;
import com.promostree.repositories.user.UserShoutRepository;

@Component
public class UserServiceImpl implements UserServices {
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	UserShareRepository userSharesRepository;
	@Autowired
	NotificationRepository notificationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UserPreferenceRepository userPreferencesRepository;
	@Autowired
	UserLocationRepository userLocationsRepository;
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
	@Autowired
	OfferRepository offerRepository;
	@Autowired
	EventTypeRepository eventTypeRepository;
	@Autowired
	UserEventRepository userEventRepository;

	// for user Registration
	@Override
	public User saveUserCredentials(User user) {
		User dbUser = null;
		if (user != null) {
			if (user.getPhoneNumber() != null && user.getEmail() == null) {
				dbUser = userRepository
						.findByPhoneNumber(user.getPhoneNumber());
				if (dbUser == null) {
					dbUser = userRepository.save(user);
				}
			} else if (user.getEmail() != null && user.getPhoneNumber() == null) {
				dbUser = userRepository.findByEmail(user.getEmail());
				if (dbUser == null) {
					dbUser = userRepository.save(user);
				}
			}
			// if (user.getPhoneNumber() != null && user.getEmail() != null)
			else {
				User dbemail = userRepository.findByEmail(user.getEmail());
				User dbphone = userRepository.findByPhoneNumber(user
						.getPhoneNumber());
				if (dbemail.getEmail() == null
						&& dbphone.getPhoneNumber() == null) {
					dbUser = userRepository.findByPhoneNumberAndEmail(
							user.getPhoneNumber(), user.getEmail());
					if (dbUser == null) {
						dbUser = userRepository.save(user);
					}
				} else {
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
	}
	
	// to save user feedback
	@Override
	public boolean saveUserFeedback(
			NotificationUserFeedback notificationUserFeedback) {

		UserFeedback userFeedback = notificationUserFeedback.getUserFeedback();
		userFeedback.setCreatedDate(new Date());
		userFeedback.setUpdatedDate(new Date());
		userFeedbackRepository.save(userFeedback);
		
		

		List<User> users = userRepository.findByIdNotIn(userFeedback.getUser()
				.getId());
		
                                             
		for (User user : users) {
			NotificationUserFeedback notification = new NotificationUserFeedback();
			notification.setCreatedDate(new Date());
			notification.setPhoneNo(user.getPhoneNumber());
			notification.setRecipientUser(user);
			notification.setStatus(false);
			notification.setUserFeedback(userFeedback);
			notificationRepository.save(notification);

		}
		return true;
	}
	@Override
	public boolean saveUserShare(NotificationUserShare notificationUserShare) {
		UserShare userShare=notificationUserShare.getUserShare();
		userShare.setCreatedDate(new Date());
		userEventRepository.save(userShare);
		List<User> users = userRepository.findByIdNotIn(userShare.getUser()
				.getId());
	

		for (User user : users) {
			NotificationUserShare notification = new NotificationUserShare();
			notification.setCreatedDate(new Date());
			notification.setPhoneNo(user.getPhoneNumber());
			notification.setRecipientUser(user);
			notification.setStatus(false);
			notification.setUserShare(userShare);
			notificationRepository.save(notification);

		}
		return true;
	}

	/**
	 * to read notifications
	 */
	@Override
	public List<Notification> readNotifications(User user) {
		user=userRepository.findOne(1L);
		return notificationRepository.findByRecipientUserId(1L);

	}


	
	

}
