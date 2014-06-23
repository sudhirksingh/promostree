package com.promostree.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.promostree.domain.entities.Brand;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Shout;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.BrandRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.ShoutRepository;
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
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = 100)
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
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ShoutRepository shoutRepository;

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
				if (dbemail == null && dbphone == null) {
					dbUser = userRepository.findByPhoneNumberAndEmail(
							user.getPhoneNumber(), user.getEmail());
					if (dbUser == null) {
						dbUser = userRepository.save(user);
					}
				} else {
					try {
						dbUser = userRepository.findByPhoneNumberOrEmail(
								user.getPhoneNumber(), user.getEmail());
					} catch (Exception NE) {
						NE.printStackTrace();
						// throw new Exception("");
					}

					// if(!dbemail.getEmail().equals(user.getEmail())&&
					// !dbphone.getPhoneNumber().equals(user.getPhoneNumber()))
					// {
					//
					// }
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
		userPreference.setUser(userRepository.findById(userPreference.getUser()
				.getId()));
		userPreference.setType(typeRepository.findById(userPreference.getType()
				.getId()));
		userPreference.setCreatedDate(new Date());
		int id = userPreference.getType().getId().intValue();
		switch (id) {
		case 1:
			Brand brand = brandRepository.findById(userPreference.getValue());
			userPreference.setValue(brand.getId());
		case 2:
			Venue venue = venueRepository.findById(userPreference.getValue());
			userPreference.setValue(venue.getId());
			break;
		case 3:
			Location location = locationRepository.findById(userPreference
					.getValue());
			userPreference.setValue(location.getId());
			break;
		case 4:
			Offer offer = offerRepository.findById(userPreference.getValue());
			userPreference.setValue(offer.getId());
			break;
		case 5:
			Shout shout = shoutRepository.findById(userPreference.getValue());
			userPreference.setValue(shout.getId());
			break;
		}
		// if(id==1L){
		// Brand brand=brandRepository.findById(userPreference.getValue());
		// userPreference.setValue(brand.getId());
		// }
		// else if(id==2L)
		// {
		// Venue venue=venueRepository.findById(userPreference.getValue());
		// userPreference.setValue(venue.getId());
		// }
		// else if(id==3L)
		// {
		// Location
		// location=locationRepository.findById(userPreference.getValue());
		// userPreference.setValue(location.getId());
		// }
		// else if(id==4L)
		// {
		// Offer offer=offerRepository.findById(userPreference.getValue());
		// userPreference.setValue(offer.getId());
		// }
		// else if(id==5L)
		// {
		// Shout shout=shoutRepository.findById(userPreference.getValue());
		// userPreference.setValue(shout.getId());
		// }
		UserPreference dbuserPreference = userPreferencesRepository
				.save(userPreference);
		if (userPreference.equals(dbuserPreference)) {
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
		UserShare userShare = notificationUserShare.getUserShare();
		for (String ph : userShare.getPhoneNumbersList()) {
			System.out.println(ph);
		}
		userShare.setCreatedDate(new Date());
		userEventRepository.save(userShare);
		;
		List<User> users = userRepository.findByPhoneNumberIn(userShare
				.getPhoneNumbersList());

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
		// user=userRepository.findOne(user.getId());
		return notificationRepository.findByRecipientUserId(user.getId());

	}

	@Override
	public String saveUsersProfile(UserProfile userProfile) {
		userProfile.setCreatedDate(new Date());
		userProfile.setUpdatedDate(new Date());
		userProfile.setReg(true);
		userProfile.setUser(userRepository.findById(userProfile.getUser()
				.getId()));
		UserProfile dbuserProfile = userProfileRepository.save(userProfile);
		if (dbuserProfile.equals(userProfile)) {
			return "successfully Stored";
		}
		return "notStored";
	}

}
