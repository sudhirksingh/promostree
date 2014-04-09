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

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.UserEventRepository;
import com.promostree.repositories.user.UserRepository;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")
public class UserEventTest {

	@Autowired
	UserRepository urep;
	
	@Autowired
	UserEventRepository uerep;

	
	
	@Test
	public void read()
	{
		List<UserEvent> ue=uerep.findByUserId((long)1);
		

		

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
		String json = ow.writeValueAsString(ue.get(0));
		
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
