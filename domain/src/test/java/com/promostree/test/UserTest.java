package com.promostree.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.tenant.Tenant;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.tenant.TenantRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.LocationTypeRepository;

import com.promostree.repositories.user.NotificationRepository;
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
	NotificationRepository nrep;
	
	@Autowired
	UserShoutRepository ussrep;
	
	@Autowired
	VenueRepository vrep ;
	
	@Autowired
	LocationTypeRepository ltrep ;
	@Autowired
	UserSharesRepository userSharesRep;
	
	@Autowired
	EventTypeRepository 	etrep;
	
	@Autowired
	TenantRepository 	trep;
	
	@Autowired
	NotificationRepository 	nnrep;
	
	
	
	
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
		
		
		LocationType lt=new LocationType();
		lt.setName("home");
		ltrep.save(lt);
		
		LocationType lt1=new LocationType();
		lt1.setName("office");
		ltrep.save(lt1);
		
		LocationType lt2=new LocationType();
		lt2.setName("current");
		ltrep.save(lt2);
		
		
		//location
		
		Location l1=new Location();
		l1.setLat(17.535345);
		l1.setLng(78.44666);
		lrep.save(l1);
		
		Location l2=new Location();
		l2.setLat(17.5355435435345345);
		l2.setLng(78.446635345435346);
		lrep.save(l2);

		Tenant t=trep.findOne((long)1);
		
		//send user
		User u=new User();
		u.setEmail("swaroopkasaraneni@gmail.com");
		u.setPhoneNumber("9000208863");
		u.setTenant(t);
		urep.save(u);
		
		//destination user
		
		User u1=new User();
		u1.setEmail("ananth@gmail.com");
		u1.setPhoneNumber("9542128262");
		u1.setTenant(t);
		urep.save(u1);
		
		User u2=new User();
		u2.setEmail("naresh@gmail.com");
		u2.setPhoneNumber("9035288863");
		u2.setTenant(t);
		urep.save(u2);
		
		
		
		//user shout
		
		UserShout uss=new UserShout();
		uss.setComment("nice............");
		uss.setCreatedDate(new Date());
		uss.setUser(u);
		Venue v=vrep.findById((long)1);
		uss.setVenue(v);
		ussrep.save(uss);
		
		
		//shares 
				
		UserShare us=new UserShare();
		us.setUser(u);
		Venue venue=vrep.findById((long)2);
		

		us.setValue(venue.getId());
		us.setComment("nice..........");
		us.setType(pt1);
		us.setCreateDate(new Date());
		usrep.save(us);
		
	//event Type
		
		EventType et=new EventType();
		et.setName("user");
		etrep.save(et);
		
		EventType et1=new EventType();
		et1.setName("share");
		etrep.save(et1);
		
		EventType et2=new EventType();
		et2.setName("feedback");
		etrep.save(et2);
		
		EventType et3=new EventType();
		et3.setName("venue");
		etrep.save(et3);
		
		EventType et4=etrep.findByName("share");

		Notification n=new Notification();
		n.setUserShare(us);
		n.setUser(u1);
		n.setEventType(et4);
		n.setCreatedDate(new Date());
		nrep.save(n);
		
		
		Notification n1=new Notification();
		n1.setUserShare(us);
		n1.setUser(u2);
		n1.setEventType(et4);
		n1.setCreatedDate(new Date());
		nrep.save(n1);
		
				
		//feedback
		
		UserFeedback ufb1=new UserFeedback();
		ufb1.setUser(u);	
		ufb1.setComment("nice");
		ufb1.setCreatedDate(new Date());
		ufb1.setType(pt3);
		ufb1.setValue(venue.getOffers().get(0).getId());
		ufbrep.save(ufb1);
		
       EventType et5=etrep.findByName("feedback");
		
       Notification n3=new Notification();
		n3.setUserShare(us);
		n3.setUser(u1);
		n3.setEventType(et5);
		n3.setUserFeedback(ufb1);
		n3.setUserShare(null);
		n3.setCreatedDate(new Date());
		nrep.save(n3);
		
		UserFeedback ufb2=new UserFeedback();
		ufb2.setUser(u);	
		ufb2.setComment("worst");
		ufb2.setCreatedDate(new Date());
		ufb2.setType(pt3);
		ufb1.setValue(venue.getOffers().get(1).getId());
		ufbrep.save(ufb2);
		
		Notification n4=new Notification();
		n4.setUserShare(us);
		n4.setUser(u2);
		n4.setEventType(et5);
		n4.setUserFeedback(ufb1);
		n4.setUserShare(null);
		n4.setCreatedDate(new Date());
		nrep.save(n4);
		
		//preferences
		
		UserPreference ups=new UserPreference();
		ups.setType(pt4);
		ups.setValue(venue.getOffers().get(0).getShout().getId());
		ups.setCreatedDate(new Date());
		ups.setUser(u);
		upsrep.save(ups);
				
		UserPreference ups1=new UserPreference();
		ups1.setType(pt1);
		ups1.setValue(venue.getId());
		ups1.setUser(u);
		upsrep.save(ups1);
		
		//userLocation
		
		UserLocation ul=new UserLocation();
		ul.setCreatedDate(new Date());
		ul.setLocation(l1);
		ul.setLocationType(lt);
		ul.setUser(u);
		ulrep.save(ul);
		
		UserLocation ul1=new UserLocation();
		ul1.setCreatedDate(new Date());
		ul1.setLocation(l2);
		ul1.setLocationType(lt1);
		ul1.setUser(u);
		ulrep.save(ul1);
		
		//userProfile
		
		UserProfile up=new UserProfile();
		up.setFristName("kkk");
		up.setLastName("swaroop");
		up.setReg(true);
		up.setCreatedDate(new Date());
		up.setUser(u);
		uprep.save(up);
		
		
	
		
      //user event
		
		UserEvent ue=new UserEvent();
		Venue vv=vrep.findById((long)1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
		String json = ow.writeValueAsString(vv);
		
		ue.setData(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
		
		ue.setType(et);
		ue.setUser(u);
		uErep.save(ue);
		
		
		
		
		
		}
	
	/*
	
	@Test
	public void reading(){
		List<UserShare> userShares=userSharesRep.findByUserId((long)1);
		for(UserShare us:userShares){
			System.out.println(us.getId());	
			/*
			Object v=new Venue();
			String ss=v.getClass().getName();
			String last = ss.substring(ss.lastIndexOf('.') + 1);
			EventType e=etrep.findByName(last.toLowerCase());
			System.out.println(e);*/
			
			//User u=urep.findByPhoneNumberAndEmail("9000208863","swaroopkasaraneni@gmail.com");
			//System.out.println(u);
			
	//}*/
	
	@Test
	public void readNotification()
	{

		//System.out.println(Notifications.get(0));
		User u=urep.findById((long)2);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
			
		String json = ow.writeValueAsString(u);
		
		System.out.println(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
		}
	
	
	
}
