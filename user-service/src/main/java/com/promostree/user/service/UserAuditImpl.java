package com.promostree.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserAuditLog;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserAuditLogRepository;
import com.promostree.repositories.user.UserEventRepository;

@Service
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

		String qualifierName = object.getClass().getName();
		String className = qualifierName.substring(qualifierName
				.lastIndexOf('.') + 1);
		EventType eventType = eventTypeRepository.findByName(className
				.toLowerCase());
		userAuditLog.setType(eventType);

		userAuditLog.setUser(user);
		UserAuditLog returnUserAuditLog = userAuditLogRepository.save(userAuditLog);
		if (returnUserAuditLog != null) {
			result = true;
		}
		return result;
	}

	public List<Object> logReader(User user, EventType eventType) {
		List<UserAuditLog> userAuditLogs = userAuditLogRepository.findByUserAndType(
				user, eventType);

		ObjectMapper mapper = new ObjectMapper();
		List<Object> result = new ArrayList<Object>();
		Venue venue = null;

		if (eventType.getName() == "venue") {
			for (UserAuditLog userAuditLog : userAuditLogs) {
				try {
					venue = mapper.readValue(userAuditLog.getData(), Venue.class);
					System.out.println(venue.getName());

				} catch (JsonGenerationException ex) {

					ex.printStackTrace();

				} catch (JsonMappingException ex) {

					ex.printStackTrace();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

				result.add(venue);

			}
		}

		return result;
	}

}