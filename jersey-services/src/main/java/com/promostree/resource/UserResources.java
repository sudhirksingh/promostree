package com.promostree.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShares;

@Path("/userservice")
public class UserResources {
	@Autowired
	UserServiceDelegate userServiceDelegate;
	//initial Registration of new user 
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response intialRegistration(User user)
	{
	 User use	= userServiceDelegate.saveUserCredentials(user);
	 ResponseBuilder builder=Response.ok();
     return builder.entity(use).build();
	}
	
	// for user Shares 

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String shares(UserShares userShares) {

		boolean save = userServiceDelegate.saveUserShares(userShares);
		if (save)
			return "sucessfully shared..";
		else
			return "failed..";
	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/postedShares/{userId}")
	public List<UserShares> postedShares(long userId) {

		return userServiceDelegate.readPostedUserShares(userId);

	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/receivedShares/{userId}")
	public List<UserShares> receivedShares(long userId) {

		return userServiceDelegate.readReceivedUserShares(userId);

	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/login")
	public String receivedShares(User user) {

		User save = userServiceDelegate.saveUserCredentials(user);
		if (save.equals(user))
			return "registered successfully...";
		else
			return "conflict ...";
	}


}
