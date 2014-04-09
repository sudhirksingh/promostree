package com.promostree.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.TargetUsers;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocations;
import com.promostree.domain.user.UserPreferences;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShares;
import com.promostree.domain.user.UserShout;

import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
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
public class UserTest {

	@Autowired
	UserRepository urep;
	@Autowired
	UserEventRepository uErep;
	@Autowired
	UserProfileRepository uprep;
	
	@Autowired
	LocationRepository lrep;
	
	@Autowired
	UserLocationsRepository ulrep;
	
	@Autowired
	UserPreferencesRepository upsrep;
	
	@Autowired
	TypeRepository ptrep;
	
	@Autowired
	UserFeedbackRepository ufbrep;
	
	
	@Autowired
	UserSharesRepository usrep;
	
	@Autowired
	TargetUsersRepository turep;
	
	@Autowired
	UserShoutRepository ussrep;
	
	@Autowired
	VenueRepository vrep ;

	@Test
	public void create()
	{
		// for types
		
		Type pt=new Type();
		pt.setName("brand");
		ptrep.save(pt);
		
		Type pt1=new Type();
		pt1.setName("venue");
		ptrep.save(pt1);
		
		Type pt2=new Type();
		pt2.setName("location");
		ptrep.save(pt2);
		
		Type pt3=new Type();
		pt3.setName("offer");
		ptrep.save(pt3);
		
		Type pt4=new Type();
		pt4.setName("shout");
		ptrep.save(pt4);
		
		
		//location
		
		Location l1=new Location();
		l1.setLat(17.535345);
		l1.setLng(78.44666);
		lrep.save(l1);
		
		Location l2=new Location();
		l2.setLat(17.5355435435345345);
		l2.setLng(78.446635345435346);
		lrep.save(l2);

		
		//send user
		User u=new User();
		u.setEmail("swaroopkasaraneni@gmail.com");
		u.setPhoneNumber("9000208863");
		urep.save(u);
		
		//destination user
		
		User u1=new User();
		u1.setEmail("ananth@gmail.com");
		u1.setPhoneNumber("9542128262");
		urep.save(u1);
		
		User u2=new User();
		u2.setEmail("naresh@gmail.com");
		u2.setPhoneNumber("9035288863");
		urep.save(u2);
		
		
		
		//user shout
		
		UserShout uss=new UserShout();
		uss.setComment("dfdfd");
		uss.setCreatedDate(new Date());
		uss.setUser(u);
		Venue v=vrep.findById((long)1);
		uss.setVenue(v);
		ussrep.save(uss);
		
		
		//shares 
				
		UserShares us=new UserShares();
		
		us.setUser(u);
		us.setValue("sonic");
		us.setComment("nicwe");
		us.setType(pt);
		us.setCreateDate(new Date());
		usrep.save(us);

		TargetUsers uu=new TargetUsers();
		uu.setUserShares(us);
		uu.setUsers(u1);
		turep.save(uu);
		
		
		TargetUsers uu1=new TargetUsers();
		uu1.setUserShares(us);
		uu1.setUsers(u2);
		turep.save(uu1);
		
		
		
		
		
		//feedback
		
		UserFeedback ufb1=new UserFeedback();
		ufb1.setUser(u);	
		ufb1.setComment("nice");
		ufb1.setCreatedDate(new Date());
		ufb1.setType(pt);
		ufb1.setValue("lg");
		ufbrep.save(ufb1);
		
		UserFeedback ufb2=new UserFeedback();
		ufb2.setUser(u);	
		ufb2.setComment("worst");
		ufb2.setCreatedDate(new Date());
		ufb2.setType(pt2);
		ufb1.setValue("hp");
		ufbrep.save(ufb2);
		
		
		//preferences
		
		UserPreferences ups=new UserPreferences();
		ups.setType(pt);
		ups.setValue("lg");
		ups.setUser(u);
		upsrep.save(ups);
				
		UserPreferences ups1=new UserPreferences();
		ups1.setType(pt1);
		ups1.setValue("hcl");
		ups1.setUser(u);
		upsrep.save(ups1);
		
		//userLocation
		
		UserLocations ul=new UserLocations();
		ul.setCreatedDate(new Date());
		ul.setLocation(l1);
		ul.setUser(u);
		ulrep.save(ul);
		
		//userProfile
		
		UserProfile up=new UserProfile();
		up.setFristName("kkk");
		up.setLastName("swaroop");
		up.setReg(true);
		up.setUser(u);
		up.setHomeLocation(l1);
		up.setOfficeLocation(l2);
		
		uprep.save(up);
		
      //user event
		
		UserEvent ue=new UserEvent();
		ue.setData("gdgdg");
		ue.setUser(u);
		uErep.save(ue);
		
		
		
		
		
	}
	
	@Test
	public void read()
	{
		User u=urep.findById((long)1);
		
		System.out.println(u.getPhoneNumber()+ "  "+u.getEmail());
		
	}
	
}
