package com.promostree.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreferences;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.TargetUsersRepository;
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
	TargetUsersRepository targetUserRep;
	@Autowired
	UserShoutRepository userShoutRep;
	@Autowired
	VenueRepository venueRep;
	@Autowired
	LocationTypeRepository locationRep;

//	@Test
//	public void read(){
//		List<TargetUser> trs=targetUserRep.findByUserId(2L);
//		for(TargetUser tr:trs){
//			System.out.println(tr.getUserShares().getComment());
//		}
//		}
//      @Test
//      public void  userLoginTest()
//      {
//    	 User user=userRep.findByPhoneNumberOrEmail("9000208863","swaroopkasaraneni@gmail.com");
//  		System.out.println(user.getPhoneNumber()+"  "+user.getEmail());
//      }
      @Test
      public void usershoutTest()
      {
    	  UserShout ushout= new UserShout();
    	  ushout.setComment("nice product");
    	  ushout.setCreatedDate(new Date());
    	  
    	  User user = new User();
    	  user.setEmail("mallikarjunmitta123@gmail.com");
    	  user.setPhoneNumber("9700492792");
    	  
    	  //ushout.setUser(user);
    	  
    	  Venue venue = new Venue();
    	   venue.setActive(true);
    	   venue.setAddress(null);
    	   venue.setCategory(null);
    	   venue.setCreatedBy("visigenix...");
    	   venue.setCreatedDate(new Date());
    	   venue.setDistance(5.0);
    	   venue.setFourSquareId("234");
    	   venue.setImage(null);
    	   venue.setMerchant(null);
    	   venue.setName("big bazar");
    	   venue.setOffers(null);
    	   venue.setUpdatedBy("visi");
    	   venue.setUpdatedDate(new  Date());
    	   venue.setVerified("verified");
    	   
    	 // ushout.setVenue(venue);
    	  
    	  UserShout ushout1=userShoutRep.save(ushout);
   
      }
	
//	@Test
//	public void savePreference(){
//		UserPreferences userPreference=new UserPreferences();
//		Type type=typeRep.findOne(1L);
//		User u1=userRep.findById(2L);
//		userPreference.setType(type);
//		userPreference.setUser(u1);
//		userPreference.setValue("pepe");
//		userPreferencesRep.save(userPreference);
//	}

}
