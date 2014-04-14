package com.promostree.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreferences;
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
	@Test
	public void read(){
		User user=userRep.findByPhoneNumber("9000208863");
		System.out.println(user.getPhoneNumber());
		List<TargetUser> trs=targetUserRep.findByUserId(2L);
		for(TargetUser tr:trs){
			System.out.println(tr.getUserShares().getComment());
		}
	}
	/*@Test
	public void savePreferenceTest(){
		UserPreferences userPreference=new UserPreferences();
		Type type=typeRep.findOne(1L);
		User u1=userRep.findById(2L);
		userPreference.setType(type);
		userPreference.setUser(u1);
		userPreference.setValue("pepe");
		userPreferencesRep.save(userPreference);
	}*/
	@Test
	public void readPreferenceTest(){
		List<UserPreferences> userPreferences = userPreferencesRep.findByUserId(1L);
		for(UserPreferences userPre:userPreferences){
			System.out.println(userPre.getId());
		}
	}
}
