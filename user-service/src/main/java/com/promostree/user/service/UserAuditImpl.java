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
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.EventTypeRepository;
import com.promostree.repositories.user.UserEventRepository;

@Service
public class UserAuditImpl implements UserAudit {
	@Autowired
	UserEventRepository userEventRepository;

	@Autowired
	EventTypeRepository eventTypeRepository;

	@Override
	public boolean logWritter(User user, Object object) {
		UserEvent userEvent = new UserEvent();
		boolean result = false;

		// convert object to json string
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(object);

			userEvent.setData(json);
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
		userEvent.setType(eventType);

		userEvent.setUser(user);
		UserEvent returnUserEvent = userEventRepository.save(userEvent);
		if (returnUserEvent != null) {
			result = true;
		}
		return result;
	}

	@Override
	public List<Object> logReader(User user, EventType eventType) {
		List<UserEvent> UserEvents = userEventRepository.findByUserAndType(
				user, eventType);

		ObjectMapper mapper = new ObjectMapper();
		List<Object> result = new ArrayList<Object>();
		Venue venue = null;

		if (eventType.getName() == "venue") {
			for (UserEvent userEvent : UserEvents) {
				try {
					venue = mapper.readValue(userEvent.getData(), Venue.class);
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
