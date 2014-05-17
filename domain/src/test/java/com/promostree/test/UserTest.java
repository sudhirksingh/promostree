package com.promostree.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional.TxType;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Brand;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Merchant;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.tenant.Tenant;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserAuditLog;
import com.promostree.domain.user.UserEvent;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.repositories.entities.BrandRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.MerchantRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.tenant.TenantRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.LocationTypeRepository;

import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserAuditLogRepository;
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

public class UserTest {
	@Autowired
	BrandRepository brep;
	
	@Autowired
	MerchantRepository mrep;
	
	@Autowired
	UserRepository urep;
	@Autowired
	UserEventRepository uErep;
	@Autowired
	UserProfileRepository uprep;
	
	@Autowired
	LocationRepository lrep;
	
	@Autowired
	UserLocationRepository ulrep;
	
	@Autowired
	UserPreferenceRepository upsrep;
	
	@Autowired
	TypeRepository ptrep;
	
	@Autowired
	UserFeedbackRepository ufbrep;
	
	
	@Autowired
	UserShareRepository usrep;
	
	@Autowired
	NotificationRepository nrep;
	
	@Autowired
	UserShoutRepository ussrep;
	
	@Autowired
	VenueRepository vrep ;
	
	@Autowired
	LocationTypeRepository ltrep ;
	@Autowired
	UserShareRepository userSharesRep;
	
	@Autowired
	EventTypeRepository 	etrep;
	
	@Autowired
	TenantRepository 	trep;
	
	@Autowired
	NotificationRepository 	nnrep;
	
	@Autowired
	UserAuditLogRepository 	ualrep;
	
	
	/*@Test
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

		
		//preferences
		
		UserPreference ups=new UserPreference();
		ups.setType(pt4);
		Venue venue=vrep.findById(1L);
		ups.setValue(venue.getOffers().get(0).getShout().getId());
		ups.setCreatedDate(new Date());
		ups.setUser(u);
		upsrep.save(ups);
				
		UserPreference ups1=new UserPreference();
		ups1.setType(pt1);
		ups1.setValue(venue.getId());
		ups1.setCreatedDate(new Date());
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
		
	
		
		//shares 
		
				UserShare us=new UserShare();
				us.setUser(u);
				us.setType(pt1);
				us.setValue(venue.getId());
				us.setComment("nice..........");
				us.setCreatedDate(new Date());
				usrep.save(us);
				
				NotificationUserShare n=new NotificationUserShare();
				n.setRecipientUser(u1);
				n.setCreatedDate(new Date());
				n.setStatus(false);
				n.setPhoneNo("900208863");
				n.setUserShare(us);
				nnrep.save(n);
						
				UserFeedback ufb2=new UserFeedback();
				ufb2.setUser(u);
				ufb2.setComment("worst");
				ufb2.setCreatedDate(new Date());
				ufb2.setType(pt3);
				ufb2.setValue(venue.getOffers().get(0).getId());
				ufbrep.save(ufb2);
				
				NotificationUserFeedback n1=new NotificationUserFeedback();
				n1.setRecipientUser(u2);
				n1.setCreatedDate(new Date());
				n1.setStatus(false);
				n1.setPhoneNo("900208863");
				n1.setUserFeedback(ufb2);
				nnrep.save(n1);
	
		
      //user event
		
		UserAuditLog ual=new UserAuditLog();
		Venue vv=vrep.findById((long)1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
		String json = ow.writeValueAsString(vv);
		
		ual.setData(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
		
		ual.setType(et);
		ual.setCreatedDate(new Date());
		ual.setUser(u);
		ualrep.save(ual);
		
		
		
		
		
		}
	*/
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
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,timeout=100)
	public void readNotification()
	{

		
	User u=urep.findById((long)1);
		User u1=urep.findById((long)1);
		System.out.println(u);
		System.out.println(u1);
		
		
		//UserLocation ul=ulrep.findOne(1L);
		
		
		//UserShout us=ussrep.findOne(1L);
		
		/*List<Notification> ns=nnrep.findByRecipientUserId(3L);
		Notification n=ns.get(0);*/
		
		//Brand b=brep.findOne(1L);
		//Venue v=vrep.findById(1L);
//Merchant m=mrep.findOne(1L);
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
