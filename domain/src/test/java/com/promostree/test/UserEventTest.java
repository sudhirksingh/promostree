package com.promostree.test;

import java.io.IOException;
import java.util.List;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserEventRepository;
import com.promostree.repositories.user.UserRepository;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")
public class UserEventTest {

	@Autowired
	UserRepository urep;
	
	@Autowired
	UserEventRepository uerep;
	
	@Autowired
	EventTypeRepository etrep;

	
	
	/*@Test
	public void read()
	{
		User uu=urep.findById((long)1);
		EventType et=etrep.findByName("user");
		
List<UserEvent> ues=uerep.findByUserAndType(uu,et);
		

		
for(UserEvent ue:ues)
	System.out.println(ue);
		
	
	
	
	}*/
	
	
	@Test
	public void toJson()
	{
		UserEvent ue=uerep.findOne((long)1);
		ObjectMapper mapper = new ObjectMapper();
		
		try
		{
		User user = mapper.readValue(ue.getData(), User.class);
		System.out.println(user);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	
	}
	
	
	@Test
	public void toJson1()
	{
		UserEvent ue=uerep.findOne((long)3);
		ObjectMapper mapper = new ObjectMapper();
		
		try
		{
		Venue user = mapper.readValue(ue.getData(), Venue.class);
		System.out.println(user);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
		
		
	}
	
	
	
	
	
}
