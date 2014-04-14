package com.promostree.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.User;
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
      @Test
      public void  userLoginTest()
      {
    	 User user=userRep.findByPhoneNumberOrEmail("9000208863","swaroopkasaraneni@gmail.com");
  		System.out.println(user.getPhoneNumber()+"  "+user.getEmail());
      }
}
