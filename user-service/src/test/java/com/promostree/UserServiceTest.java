package com.promostree;

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
import com.promostree.domain.entities.Category;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserPreferences;
import com.promostree.domain.user.UserShares;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserPreferencesRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.user.service.UserServiceImpl;
import com.promostree.user.service.UserServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:user-service-application-context.xml")
public class UserServiceTest {
	@Autowired
	UserServices userService;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	UserRepository userRepository;

	/*
	 * @Test public void saveUserPreferencesTest(){ UserPreferences
	 * userPreference=new UserPreferences(); Type
	 * type=typeRepository.findOne(1L); User u1=userRepository.findById(2L);
	 * userPreference.setType(type); userPreference.setUser(u1);
	 * userPreference.setValue("pepe");
	 * userService.saveUserPreferences(userPreference); }
	 */
@Test
public void readUserPreferencesTest(){
	User user=userRepository.findById(2L);
	List<UserPreferences> userPreferences=userService.readUserPreferences(user);
	for(UserPreferences userPre:userPreferences){
		System.out.println(userPre.getValue());
	}
}
	/*
	 * @Test public void saveUserSharesTest() { Type pt = new Type();
	 * pt.setId(1L); //pt.setName("brand"); User user = new User();
	 * user.setId(1L); // user.setEmail("ananth@gmail.com"); //
	 * user.setPhoneNumber("9542128262"); UserShares userShares = new
	 * UserShares(); userShares.setComment("it's pretty good..");
	 * userShares.setCreateDate(new Date()); userShares.setType(pt);
	 * userShares.setUser(user); userShares.setValue("Pepe zeans"); boolean b=
	 * userService.saveUserShares(userShares); Assert.assertTrue(b); }
	 */

	/*
	 * @Test public void readUserSharesTest() { // to get shares which i posted
	 * List<UserShares> us = userService.readPostedUserShares(1L); for
	 * (UserShares u : us) { System.out.println(u.getComment()); } // to get
	 * shares which i received from different users List<UserShares> uss = null;
	 * uss = userService.readRecievedUserShares(2L); for (UserShares u : uss) {
	 * System.out.println(u.getComment()); } }
	 */

	@Test
	public void IntialRegistration() {
		User user = new User();
		user.setEmail("ananth@gmail.com");
		user.setPhoneNumber("9035208863");
		User user1 = userService.saveUserCredentials(user);
		System.out.println(user1);
	}

	// @Test
	// public void savelocation(Location location)
	// {
	// Location l= new Location();
	// l.setLat(17.3);
	// l.setLat(78.4);
	// Address a = new Address();
	// a.setCity("ramanthapur");
	// a.setCountry("india");
	// a.setLandMark("kuki");
	// a.setState("andhrapradesh");
	// a.setZip("500013");
	// l.setAddress(a);
	//
	// Location l1=userService.saveLocation(l);
	// System.out.println(l1);
	// }

	// @Test
	// public void saveFeedback()
	// {
	// UserFeedback feedback = new UserFeedback();
	// feedback.setComment("nice product...");
	// feedback.setCreatedDate(new Date());
	// feedback.setUpdatedDate(new Date());
	// User user = new User();
	// user.setEmail("ananth@gmail.com");
	// user.setPhoneNumber("9035208863");
	// feedback.setUser(user);
	// feedback.setValue("showroom");
	// Type t = new Type();
	// t.setName("bigbazar");
	// feedback.setType(t);
	// userService.saveUserFeedback(feedback);
	// }

	// @Test
	// public void userShout()
	// {
	// UserShout ushout = new UserShout();
	// ushout.setComment("niceproduct");
	// ushout.setCreatedDate(new Date());
	// User user = new User();
	// user.setEmail("ananth@gmail.com");
	// user.setPhoneNumber("9035208863");
	// ushout.setUser(user);
	// Venue venue = new Venue();
	// venue.setActive(true);
	// Address a = new Address();
	// a.setCity("ramanthapur");
	// a.setCountry("india");
	// a.setLandMark("kuki");
	// a.setState("andhrapradesh");
	// a.setZip("500013");
	// venue.setAddress(a);
	// Category c = new Category();
	// c.setName("food");
	//
	// venue.setCategory(c);
	// venue.setCreatedBy("visi");
	// venue.setCreatedDate(new Date());
	// ushout.setVenue(venue);
	// userService.saveUserShout(ushout);
	// }
	//

}