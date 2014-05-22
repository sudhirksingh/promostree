package com.promostree.test;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.promostree.domain.user.User;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.UserPreference;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")
public class UserRepositoryTest {
	@Autowired
	TypeRepository typeRepo;
	@Autowired
	UserRepository userRep;
	@Autowired
	UserEventRepository userEventRep;
	@Autowired
	UserProfileRepository userProfileRep;
	@Autowired
	LocationRepository LocationRep;
	@Autowired
	UserLocationRepository userLocationRep;
	@Autowired
	UserPreferenceRepository userPreferencesRep;
	@Autowired
	UserFeedbackRepository userFeedbackRep;
	@Autowired
	UserShareRepository userSharesRep;
	@Autowired
	NotificationRepository userNotificationRep;
	@Autowired
	UserShoutRepository userShoutRep;
	@Autowired
	VenueRepository venueRep;
	@Autowired
	LocationTypeRepository locationRep;
	

	@Test
	public void readNotificationTest() {
         List<String> ids=new ArrayList<String>();
         ids.add("9542128262");
         ids.add("9000208863");
         List<User> users=userRep.findByPhoneNumberIn(ids);
         for(User user:users){
        	 System.out.println(user.getId());
         }
         
	}

//	@Test
//	public void userLoginTest() {
//		User user = userRep.findByPhoneNumberOrEmail("432211111111",
//				"dddd@gmail.com");
//		System.out.println(user.getPhoneNumber() + "  " + user.getEmail());
//	}

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

	/*
	 * @Test public void readPreferenceTest(){ List<UserPreference>
	 * userPreferences = userPreferencesRep.findByUserId(4L); for(UserPreference
	 * userPre:userPreferences){
	 * System.out.println("readPreferenceTest:: "+userPre.getId()); } }
	 */

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

}
