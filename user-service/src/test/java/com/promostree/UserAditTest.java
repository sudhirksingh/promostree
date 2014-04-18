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
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserRepository;
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
   
 /* @Test
  public void writterTest(){
	  
	//  UserAudit userAudit=new UserAuditImpl();
	  
	  User user=urep.findById((long)1);
	  
Venue v=vrep.findById((long)1);
	  
	System.out.println(  userAuditImpl.logWritter(user,user));
	  
  }
   */
  
  @Test
  public void readerTest(){
	  
	//  UserAudit userAudit=new UserAuditImpl();
	  
	  User uu=urep.findById((long)1);
		EventType et=etrep.findByName("venue");
	  
	List<Object> UserEvents= userAuditImpl.logReader(uu, et);
		 

			
			for(Object ue:UserEvents)
			{
				System.out.println(ue);
			
			}
			
			 
			 
			 
			
		
	  
  }
 
}