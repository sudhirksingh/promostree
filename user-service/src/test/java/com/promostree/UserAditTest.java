package com.promostree;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.EventType;

import com.promostree.domain.user.Notification;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.NotificationRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.user.service.Log;
import com.promostree.user.service.UserAuditImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:user-service-application-context.xml")
public class UserAditTest
{
   @Autowired
   UserAuditImpl userAuditImpl;
   
   @Autowired
	UserRepository urep;

   @Autowired
	VenueRepository vrep ;
   
   @Autowired
   EventTypeRepository etrep ;
   
   @Autowired
   NotificationRepository nrep ;
   
/*   
  @Test
  public void writterTest(){
	  
	//  UserAudit userAudit=new UserAuditImpl();
	  
	  User user=new User();
	  user.setId(1L);
	  user.setRadius(23.233);
	  user.setSearchTerm("sweats");
	  user.setLat(17.222);
	  user.setLng(72.1223);
	  user.setPageNumber(1);
	  
//Venue v=vrep.findById((long)1);
	  
  // Notification n=nrep.findOne(2L);
	  
	System.out.println(  userAuditImpl.logWritter(user,user));
	  
  }
   */
  
  @Test
  public void readerTest(){
	  
	//  UserAudit userAudit=new UserAuditImpl();
	  
	  User uu=urep.findById((long)1);
		//EventType et=etrep.findOne(7L);
		Log logs=userAuditImpl.logReader(uu);
		
	  	
		 
List<User> l=logs.getUsers();
			
			for(User u:l)
			{
				System.out.println(u);
			}
			
			
			 
  } 
			 
			
		
	  
  
 
}