package com.promostree.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserEventRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserLocationsRepository;
import com.promostree.repositories.user.UserPreferencesRepository;
import com.promostree.repositories.user.UserProfileRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.repositories.user.UserSharesRepository;
import com.promostree.repositories.user.UserShoutRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")
public class UserRepositoryTest {
	@Autowired
	UserRepository userRep;
	@Autowired
	UserEventRepository userEventRep;
	@Autowired
	UserProfileRepository userProfileRep;
	@Autowired
	LocationRepository LocationRep;
	@Autowired
	UserLocationsRepository userLocationRep;
	@Autowired
	UserPreferencesRepository userPreferencesRep;
	@Autowired
	TypeRepository typeRep;
	@Autowired
	UserFeedbackRepository userFeedbackRep;
	@Autowired
	UserSharesRepository userSharesRep;
	@Autowired
	NotificationRepository userNotificationRep;
	@Autowired
	UserShoutRepository userShoutRep;
	@Autowired
	VenueRepository venueRep;
	@Autowired
	LocationTypeRepository locationRep;

//			@Test
//	public void readUserProfile(){
//		UserProfile userProfiles=userProfileRep.findByUserId(3L);
//		//for(UserProfile userProfile :userProfiles){
//		System.out.println("profile   "+userProfiles.getFristName());
//		//}
//	}
//	@Test
//	public void readReceivedShares() {
//		List<Notification> notifications = userNotificationRep.findByUserId(5L);
//		for(Notification notification:notifications){
//			User user=notification.getUser();
//		
//		System.out.println("notification by userId: "+notification.getId() );
//			
//			}
//	}


/*	@Test
	public void userLoginTest() {
		User user = userRep.findByPhoneNumberOrEmail("9000208863",
				"swaroopkasaraneni@gmail.com");
		System.out.println(user.getPhoneNumber() + "  " + user.getEmail());
	}*/

	/*
	 * @Test public void usershoutTest() { UserShout ushout= new UserShout();
	 * ushout.setComment("nice product"); ushout.setCreatedDate(new Date());
	 * User use= userRep.findById(1L); ushout.setUser(use); Venue ven =
	 * venueRep.findById(1L); ushout.setVenue(ven); UserShout
	 * ushout1=userShoutRep.save(ushout);
	 * 
	 * }
	 */
	//
	// @Test
	// public void savePreference(){
	// UserPreferences userPreference=new UserPreferences();
	// Type type=typeRep.findOne(1L);
	// User u1=userRep.findById(2L);
	// userPreference.setType(type);
	// userPreference.setUser(u1);
	// userPreference.setValue("pepe");
	// userPreferencesRep.save(userPreference);
	// }

	/*
	 * @Test public void savePreferenceTest(){ List<UserPreference>
	 * userPreferences=new ArrayList<UserPreference>() UserPreference
	 * userPreference=new UserPreference(); Type type=typeRep.findOne(1L); User
	 * u1=userRep.findById(2L); userPreference.setType(type);
	 * userPreference.setUser(u1); //userPreference.setValue();
	 * userPreferencesRep.save(userPreference); userPreference.setValue(1L);
	 * userPreferences.add(userPreference);
	 * userPreferencesRep.save(userPreferences); }
	 */

	 @Test
	 public void readPreferenceTest(){
	 List<UserPreference> userPreferences =
	 userPreferencesRep.findByUserId(4L);
	 for(UserPreference userPre:userPreferences){
	 System.out.println("readPreferenceTest:: "+userPre.getId());
	 }
	 }
//	 @Test
//	 public void deletePreferenceTest(){
//	 UserPreference userPref=userPreferencesRep.findOne(1L);
//	 userPreferencesRep.delete(userPref);
//	 }

/*	@Test
	public void readPreferenceTest() {
		List<UserPreference> userPreferences = userPreferencesRep
				.findByUserId(1L);
		for (UserPreference userPre : userPreferences) {
			System.out.println("preference :: " + userPre.getId());
		}
	}*/

	/*
	 * @Test public void saveShout(){ UserShout userShout=new UserShout();
	 * userShout.setComment("its good .."); userShout.setCreatedDate(new
	 * Date()); User user=userRep.findById(1L); Venue
	 * venue=venueRep.findById(1L); userShout.setUser(user);
	 * userShout.setVenue(venue); UserShout
	 * userShout1=userShoutRep.save(userShout);
	 * 
	 * }
	 */

	/*@Test
	public void readShouts() {
		List<UserShout> userShouts = userShoutRep.findByUserId(1L);
		for (UserShout userShout : userShouts) {
			System.out.println("shout.." + userShout.getComment());
		}

	}*/
	/*
	 * @Test public void readUserFeedbackOfVenue(){
	 * 
	 * UserFeedback userFeedback=userFeedbackRep.findOne(1L);
	 * 
	 * System.out.println("feedback on venue :: "+userFeedback.getComment());
	 * 
	 * }
	 */
	/*
	 * @Test public void deletePreferenceTest(){ UserPreference
	 * userPref=userPreferencesRep.findOne(1L);
	 * userPreferencesRep.delete(userPref); }
	 */

}
