package com.promostree.user.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;
import com.promostree.repositories.user.UserEventRepository;

@Service
public class UserAuditImpl implements UserAudit {
	@Autowired
	UserEventRepository userEventRepository;

	@Override
	public boolean log(User user){
		
		
		UserEvent userEvent=new UserEvent();
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
		String json = ow.writeValueAsString(user);
		
		userEvent.setData(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
		
		
		userEvent.setUser(user);
		userEventRepository.save(userEvent);
		
		
		return  true;
	}
	
	
	
}
