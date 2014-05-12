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
import com.promostree.domain.user.Notification1;
import com.promostree.domain.user.User;
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

	/*
	 * List<UserPreference> userpreferences=user.getUserPreferences();
	 * List<UserPreference> userpreList = new ArrayList<UserPreference>();
	 * for(UserPreference userPreference:userpreferences) { Long userid =
	 * userPreference.getUser().getId();
	 * userPreference.setUser(userRepository.findById(userid)); userPreference
	 * .setType(typeRepository.findById(userPreference.getType().getId()));
	 * if(userPreference!=null) userpreList =
	 * userPreferencesRepository.findByUserId(userid); } return userpreList;
	 */

	// to get shares which i posted
	@Override
	public List<UserShare> readPostedUserShares(User user) {
		return userSharesRepository.findByUserId(user.getId());
	}

	@Override
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

	/*
	 * @Override public UserPreference deleteUserPreferences(UserPreference
	 * userPreferences){ userPreferencesRepository.delete(userPreferences);
	 * return userPreferences; }
	 */

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

	public Location saveLocation(Location location) {
		Location location1 = locationRepository.save(location);
		return location1;
	}


	// to save user feedback
	@Override
	public boolean saveUserFeedback(UserFeedback userFeedback) {
	
		List<User>users=userRepository.findByIdNotIn(userFeedback.getUser().getId());
		userFeedback.setCreatedDate(new Date());
		userFeedback.setUpdatedDate(new Date());
		// userFeedback.setUser(userRepository.findOne(userFeedback.getUser().getId()));
		userFeedbackRepository.save(userFeedback);
		for (User user : users) {
			Notification notification = new Notification();
			notification.setCreatedDate(new Date());
			EventType eventType = eventTypeRepository.findOne(3L);
			notification.setEventType(eventType);
			notification.setUser(user);
			notification.setUserFeedback(userFeedback);
			notificationRepository.save(notification);
		}
		return true;
	}
	

	@Override
	public List<Notification1> readNotifications(User user) {

		List<Notification1> notification1s = new ArrayList<Notification1>();
		
		Notification1 notification1 = new Notification1();

		List<Notification> notifications = notificationRepository
				.findByUserId(5L);

		UserShare userShare = new UserShare();

		UserFeedback userFeedback = new UserFeedback();
		for(Notification notification:notifications){
			System.out.println(notification.getId());
		}
          
		for (Notification notification : notifications) {
			if (notification.getEventType().getId() == 2) { // if its share type
				notification1 = new Notification1();				
				userShare = notification.getUserShare();
				notification1.setActivity_type("share");
				notification1.setUserShare(userShare);
				notification1.setUser(userRepository.findById(userShare
						.getUser().getId()));

				notification1.setUserProfile(userProfileRepository
						.findByUserId(userShare.getUser().getId()));
			
				if (userShare.getType().getId() == 2) { // venue shared
					notification1.setVenue(venueRepository
							.findOne((long) userShare.getValue()));
				}
				else if (userShare.getType().getId() == 4) { // offer shared
					notification1.setOffer(offerRepository.findOne(userShare
							.getValue()));
				}
				
				notification1s.add(notification1);
			} else if (notification.getEventType().getId() == 3) { // if its a
																	// feedback
																	// type
				notification1 = new Notification1();
				userFeedback = notification.getUserFeedback();
				notification1.setActivity_type("feedback");
				notification1.setUserFeedback(userFeedback);
				notification1.setUser(userRepository.findById(userFeedback
						.getUser().getId()));
				notification1.setUserProfile(userProfileRepository
						.findByUserId(notification1.getUser().getId()));
				if (userShare.getType().getId() == 2) { // feedback on venue
					notification1.setVenue(venueRepository.findOne(userFeedback
							.getValue()));

					notification1s.add(notification1);
				}
				if (userShare.getType().getId() == 4) { // feedback on offer
					notification1.setOffer(offerRepository.findOne(userFeedback
							.getValue()));
				}

			}
		}

		return notification1s;

	}

	@Override
	public List<UserShout> readUserShout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUserShares(UserShare userShares) {
		
		
			List<User> users=userRepository.findByIdNotIn(userShares.getUser().getId());
			
			userShares.setCreateDate(new Date());
			
			// userFeedback.setUser(userRepository.findOne(userFeedback.getUser().getId()));
			userSharesRepository.save(userShares);
			for (User user : users) {
				Notification notification = new Notification();
				notification.setCreatedDate(new Date());
				EventType eventType = eventTypeRepository.findOne(2L);
				notification.setEventType(eventType);
				notification.setUser(user);
				notification.setUserShare(userShares);
				notificationRepository.save(notification);
			}
			return true;
		}

	@Override
	public UserProfile saveUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUserPreference(List<UserPreference> userPreferences) {
		// TODO Auto-generated method stub
		return false;
	}



}
