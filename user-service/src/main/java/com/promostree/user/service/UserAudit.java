package com.promostree.user.service;

import java.util.List;

import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;

public interface UserAudit {
	
	//public boolean log(User user);
	
	public boolean logWritter(User user,Object object);
	
	public List<Object> logReader(User user,EventType eventType);

}
