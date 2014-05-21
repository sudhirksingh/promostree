package com.promostree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Merchant;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserPreferenceRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.user.service.UserServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-application-context.xml")
public class UserServiceTests {
	@Autowired
	UserServices userService;
	@Autowired
	VenueRepository venueRepository;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserPreferenceRepository userPreferencesRepository;
	@Autowired
	UserFeedbackRepository userFeedbackRepository;
	@Autowired
	NotificationRepository notificationRepository;
//	@Test
//	public void saveUserShare(){
//		UserShare userShare=new UserShare();
//		userShare.setComment("its me ananth shared..");
//		Type type=new Type();
//		type.setId(2L);
//		userShare.setType(type);
//		User user=new User();
//		user.setId(2L);
//		userShare.setUser(user);
//		userShare.setValue(2L);
//		NotificationUserShare notificationUserShare=new NotificationUserShare();
//		notificationUserShare.setUserShare(userShare);
//	userService.saveUserShare(notificationUserShare);	
//	}
//	@Test
//	public void saveUserFeedback(){
//		UserFeedback userFeedback=new UserFeedback();
//		userFeedback.setComment("its me ananth");
//		
//		Type type=new Type();
//		type.setId(2L);
//		userFeedback.setType(type);
//		User user=new User();
//		user.setId(2L);
//		userFeedback.setUser(user);
//		userFeedback.setValue(2L);
//		NotificationUserFeedback notificationUserFeedback=new NotificationUserFeedback();
//		
//		notificationUserFeedback.setUserFeedback(userFeedback);
//	userService.saveUserFeedback(notificationUserFeedback);	
//	}


//	@Test
//	public void readNotificationTest(){
//		User user=new User();
//		user.setId(1L);
//		List<Notification> notifications=userService.readNotifications(user);
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		for(Notification notification:notifications){
//					
//			try{
//			String json = ow.writeValueAsString(notification);			
//			System.out.println(json+",");
//			} catch (Exception ex) {
//
//				ex.printStackTrace();
//
//			}
//			//System.out.println(notification.getPhoneNo());
//		}
//	}
//	

//	@Test
//	public void readUserPreferencesTest() {
//	User user =new User();
//	user.setId(4L);
//		List<UserPreference> userPreferences = userService
//				.readUserPreferences(user);
//		for (UserPreference userPre : userPreferences) {
//			System.out.println(userPre.getType().getId());
//		}
//	}

//	@Test
//	public void userShout() {
//		UserShout ushout = new UserShout();
//		ushout.setComment("niceproduct");
//		ushout.setCreatedDate(new Date());
//		User use = userRepository.findById(1L);
//		ushout.setUser(use);
//		Venue ven = venueRepository.findById(1L);
//		ushout.setVenue(ven);
//		userService.saveUserShout(ushout);
//	}



	/*
	 * @Test public void readUserPreferencesTest() { User user =
	 * userRepository.findById(2L); List<UserPreference> userPreferences =
	 * userService .readUserPreferences(user); for (UserPreference userPre :
	 * userPreferences) { System.out.println(userPre.getValue()); } }
	 */


	/*
	 * * @Test public void deleteUserPreferences(){ UserPreference
	 * userPreferences=userPreferencesRepository.findOne(1L);
	 * userService.deleteUserPreferences(userPreferences); }
	 */

	/*
	 * @Test public void deleteUserPreferences(){ UserPreference
	 * userPreferences=userPreferencesRepository.findOne(1L);
	 * userService.deleteUserPreferences(userPreferences); }
	 */

	/*
	 * @Test public void readUserSharesTest() { // to get shares which i posted
	 * User user = new User(); user.setId(1L); List<UserShare> us =
	 * userService.readPostedUserShares(user); for (UserShare u : us) {
	 * System.out.println(u.getComment()); } // to ge shares which i received
	 * from different users List<UserShare> uss = null; user.setId(2L); uss =
	 * userService.readRecievedUserShares(user); for (UserShare u : uss) {
	 * System.out.println(u.getComment()); } }
	 */

	// @Test
	// public void saveUserPreferencesTest() { 
	// List<UserPreference> userPreferences = new ArrayList<UserPreference>();
	// UserPreference userPreference = new UserPreference();
	// Type type = new Type();
	// type.setId(4L);
	// User user = new User();
	// user.setId(1L);
	// userPreference.setType(type);
	// userPreference.setUser(user);
	// userPreference.setValue(1L); // userPreferences.add(userPreference);
	// String userPreferences1 = userService.saveUserPreference(userPreference);
	// System.out.println(userPreferences1);
	//
	// }

	// @Test
	// public void readUserPreferencesTest() {
	// User user =new User();
	// user.setId(4L);
	// List<UserPreference> userPreferences = userService
	// .readUserPreferences(user);
	// for (UserPreference userPre : userPreferences) {
	// System.out.println(userPre.getType().getId());
	// }
	// }

	// @Test
	// public void userShout() {
	// UserShout ushout = new UserShout();
	// ushout.setComment("niceproduct");
	// ushout.setCreatedDate(new Date());
	// User use = userRepository.findById(1L);
	// ushout.setUser(use);
	// Venue ven = venueRepository.findById(1L);
	// ushout.setVenue(ven);
	// userService.saveUserShout(ushout);
	// }
//	@Test
//	public void IntialRegistration() {
//		try {
//			User user = new User();
//			user.setEmail("mnvsdd@gmail.com");
//			user.setPhoneNumber("9849386839");
//			User dbuser = userService.saveUserCredentials(user);
//			//Assert.assertNotNull(dbuser);
//			System.out.println(dbuser);
//		} catch (Exception e) {
//			Assert.fail("Exception");
//		}
//	}
	

}

