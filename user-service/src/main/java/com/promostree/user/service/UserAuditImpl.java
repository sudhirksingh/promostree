package com.promostree.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.EventType;

import com.promostree.domain.user.NotificationUserFeedback;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserAuditLog;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserAuditLogRepository;
import com.promostree.repositories.user.UserEventRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,timeout=100)
public class UserAuditImpl implements UserAudit {
	@Autowired
	UserAuditLogRepository userAuditLogRepository;
	
	
	@Autowired
	EventTypeRepository eventTypeRepository;

	public boolean logWritter(User user, Object object) {
		UserAuditLog userAuditLog =new UserAuditLog();
		boolean result = false;
		
		// convert object to json string
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(object);
			userAuditLog.setData(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();
		}

		// to catch the which event type

		//String qualifierName = object.getClass().getName();
		//String className = qualifierName.substring(qualifierName.lastIndexOf('.') + 1);
		String className = object.getClass().getName();
		EventType eventType = null;
		eventType=eventTypeRepository.findByName(className);
			if(eventType==null)
		{
				eventType=new EventType();
				eventType.setName(className);
				eventType=eventTypeRepository.save(eventType);
			
		}
		
		System.out.println(className);
		userAuditLog.setType(eventType);

		userAuditLog.setUser(user);
		UserAuditLog returnUserAuditLog = userAuditLogRepository.save(userAuditLog);
		if (returnUserAuditLog != null) {
			result = true;
		}
		return result;
	}


	
	
	public Log logReader(User user)  {
		
		
		List<UserAuditLog> userAuditLogs = userAuditLogRepository.findByUser(user);
		
			
		ObjectMapper mapper = new ObjectMapper();
		List<User> result = new ArrayList<User>();
	
		User getUser=null;

		
			for (UserAuditLog userAuditLog : userAuditLogs) {
				try {
					
				getUser = mapper.readValue(userAuditLog.getData(), User.class);
					//System.out.println(venue.getName());

				} catch (JsonGenerationException ex) {

					ex.printStackTrace();

				} catch (JsonMappingException ex) {

					ex.printStackTrace();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

				result.add(getUser);

			}
		
Log log=new Log();
log.setUsers(result);
		return log;
	
	}

}