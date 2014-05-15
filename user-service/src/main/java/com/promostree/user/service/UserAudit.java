package com.promostree.user.service;

import java.util.List;

import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;


public interface UserAudit {
	
	//public boolean log(User user);
	
	public boolean logWritter(User user,Object object);
	
	public Log logReader(User user);

}
