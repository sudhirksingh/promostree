package com.promostree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Address;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.Notification1;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserPreferencesRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.user.service.UserServiceImpl;
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
	UserPreferencesRepository userPreferencesRepository;
	@Autowired
	UserFeedbackRepository userFeedbackRepository;

	/*
	 * @Test public void saveUserShareTest(){ List<User> users=new
	 * ArrayList<>();
	 * 
	 * User user1=userRepository.findById(2L); users.add(user1);
	 * user1=userRepository.findById(3L); users.add(user1);
	 * 
	 * UserShare userShare=new UserShare(); userShare.setComment("awesome...");
	 * userShare.setCreateDate(new Date()); Type
	 * type=typeRepository.findOne(2L); userShare.setType(type); User
	 * user=userRepository.findOne(1L); userShare.setUser(user);
	 * userShare.setValue(3L); userService.saveUserShares(userShare,users); }
	 */
	/*
	 * @Test public void saveUserFeedBackTest(){ List<User> users=new
	 * ArrayList<>();
	 * 
	 * User user1=userRepository.findById(2L); users.add(user1);
	 * user1=userRepository.findById(3L); users.add(user1);
	 * 
	 * UserFeedback userFeedback=new UserFeedback();
	 * userFeedback.setComment("its pretty good..");
	 * 
	 * Type type=typeRepository.findOne(4L); userFeedback.setType(type);
	 * 
	 * User user=new User(); user.setId(1L); userFeedback.setUser(user);
	 * userFeedback.setValue(4L);
	 * userService.saveUserFeedback(userFeedback,users); }
	 */

	@Test
	public void readNoitificationsTest() {
		User user = userRepository.findOne(3L);
		List<Notification1> notification1s = userService
				.readNotifications(user);
		for (Notification1 notification1 : notification1s) {

			if (notification1.getActivity_type() == "share") {
				System.out.println("notification read test :share:   "
						+ notification1.getUserProfile().getFristName());
				
			}
			if (notification1.getActivity_type() == "feedback") {
				System.out.println("notification read test :feedback:   "
						+ notification1.getUserFeedback().getComment());
				
				
			}

		}
	}

	/*
	 * @Test public void saveUserPreferencesTest() { List<UserPreference>
	 * userPreferences=new ArrayList<UserPreference>(); UserPreference
	 * userPreference = new UserPreference(); Type type =
	 * typeRepository.findOne(1L); User u1 = userRepository.findById(2L);
	 * userPreference.setType(type); userPreference.setUser(u1);
	 * userPreference.setValue("pepe"); userPreferences.add(userPreference);
	 * userService.saveUserPreference(userPreferences); }
	 */

	/*
	 * @Test public void readUserPreferencesTest() { User user =
	 * userRepository.findById(2L); List<UserPreference> userPreferences =
	 * userService .readUserPreferences(user); for (UserPreference userPre :
	 * userPreferences) { System.out.println(userPre.getValue()); } }
	 */

	/*
	 * @Test public void deleteUserPreferences(){ UserPreference
	 * userPreferences=userPreferencesRepository.findOne(1L);
	 * userService.deleteUserPreferences(userPreferences); }
	 */
	// @Test
	// public void readUserPreferencesTest(){
	// User user=userRepository.findById(2L);
	// List<UserPreference>
	// userPreferences=userService.readUserPreferences(user);
	// for(UserPreference userPre:userPreferences){
	// System.out.println(userPre.getValue());
	// }
	// }
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
	 * @Test public void IntialRegistration() { User user = new User();
	 * user.setEmail("anant@gmail.com"); user.setPhoneNumber("903520886");
	 * UserProfile uprofile = userService.saveUserCredentials(user);
	 * System.out.println(uprofile); }
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