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

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.Notification;

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

	@Test
	public void ShareTest() {
		List<User> users = userRepository.findByIdNotIn(2L);
		for (User user : users) {
			System.out.println(user.getEmail());
		}
	}

	/*
	 * @Test public void saveUserShareTest(){
	 * 
	 * 
	 * 
	 * 
	 * 
	 * UserShare userShare=new UserShare(); userShare.setComment("awesome...");
	 * userShare.setCreateDate(new Date()); Type
	 * type=typeRepository.findOne(2L); userShare.setType(type); User
	 * user=userRepository.findOne(2L); userShare.setUser(user);
	 * userShare.setValue(3L); userService.saveUserShares(userShare);
	 * 
	 * }
	 */

	@Test
	public void saveUserFeedBackTest() {
		List<User> users = new ArrayList<User>();

		User user1 = userRepository.findById(1L);
		users.add(user1);
		user1 = userRepository.findById(3L);
		users.add(user1);

		UserFeedback userFeedback = new UserFeedback();
		userFeedback.setComment("nice place..");

		Type type = typeRepository.findOne(4L);
		userFeedback.setType(type);

		User user = new User();
		user.setId(1L);
		userFeedback.setUser(user);
		userFeedback.setValue(4L);
		userService.saveUserFeedback(userFeedback);
	}

	/*
	 * @Test public void readNoitificationsTest() { UserShare userShare = new
	 * UserShare(); UserFeedback userFeedback = new UserFeedback();
	 * 
	 * 
	 * List<Notification> u=notificationRepository.findById(1L);
	 * 
	 * List<Notification> notifications = notificationRepository .findById(5L);
	 * 
	 * for(Notification notification:u){
	 * System.out.println(notification.getId()); } }
	 * 
	 * User user = userRepository.findOne(3L); List<Notification1>
	 * notification1s = userService .readNotifications(user); for (Notification1
	 * notification1 : notification1s) {
	 * 
	 * if (notification1.getActivity_type() == "share") {
	 * System.out.println("notification read test :share:   " +
	 * notification1.getUserShare().getComment());
	 * 
	 * } if (notification1.getActivity_type() == "feedback") {
	 * System.out.println("notification read test :feedback:   " +
	 * notification1.getUserFeedback().getId());
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

	// @Test
	// public void saveUserPreferencesTest() { // List<UserPreference>
	// ArrayList<UserPreference> userPreferences = new
	// ArrayList<UserPreference>();
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

	/*
	 * @Test public void IntialRegistration() { try { User user = new User();
	 * user.setEmail("naresh@gmail.com"); user.setPhoneNumber("9035288863");
	 * User dbuser = userService.saveUserCredentials(user);
	 * //Assert.assertNotNull(dbuser); System.out.println(dbuser); } catch
	 * (Exception e) { Assert.fail("Exception"); } }
	 */
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

	/*
	 * @Test public void readShouts() { User user = new User(); user.setId(1L);
	 * List<UserShout> userShouts = userService.readUserShout(user); for
	 * (UserShout shout : userShouts) { System.out.println("read shouts ::  " +
	 * shout.getComment()); } }
	 */

	/*
	 * @Test public void savelocation() { Location loca = new Location();
	 * loca.setLat(17.2451); loca.setLng(78.21452);
	 * locationRepository.save(loca); }
	 */

	/*
	 * @Test public void saveAddress() { Location l =
	 * locationRepository.findOne(1L); Address a = new Address();
	 * a.setCity("ramanthapur"); a.setCountry("india"); a.setLandMark("kuki");
	 * a.setState("andhrapradesh"); a.setZip("500013"); a.setLocation(l);
	 * addressRepository.save(a); }
	 */

	/*
	 * @Test public void saveFeedback() { UserFeedback feedback = new
	 * UserFeedback(); feedback.setComment("nice product...");
	 * feedback.setCreatedDate(new Date()); feedback.setUpdatedDate(new Date());
	 * User user = userRepository.findById(2L); feedback.setUser(user);
	 * feedback.setValue("showroom"); Type t =typeRepository.findOne(1L);
	 * feedback.setType(t); userService.saveUserFeedback(feedback); }
	 */

}