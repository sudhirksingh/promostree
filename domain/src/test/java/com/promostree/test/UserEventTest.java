package com.promostree.test;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserAuditLog;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserAuditLogRepository;
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
	
	@Autowired
	UserAuditLogRepository ualrep;
	
	

	/*
	 * @Test public void read() { User uu=urep.findById((long)1); EventType
	 * et=etrep.findByName("user");
	 * 
	 * List<UserEvent> ues=uerep.findByUserAndType(uu,et);
	 * 
	 * 
	 * 
	 * for(UserEvent ue:ues) System.out.println(ue);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@Test
	public void toJson() {
		UserAuditLog ue = ualrep.findOne((long) 1);
		ObjectMapper mapper = new ObjectMapper();
		try {
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

	

	}


