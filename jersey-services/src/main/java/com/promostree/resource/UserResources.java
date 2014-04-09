package com.promostree.resource;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.UserShares;

@Path("/userservice")
public class UserResources {
	@Autowired
	UserServiceDelegate userServiceDelegate;
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String shares(UserShares userShares){
		
		boolean save=userServiceDelegate.saveUserShares(userShares);
		if (save)
		return "sucessfully shared..";
		else
		return "failed..";
	}

}
