package com.promostree.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShare;

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
	
	//
//	@POST
//	@Path("/shout")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response AudituingUserShot(User user)
//	{
//	 User use	= userServiceDelegate.saveUserShout();
//	 ResponseBuilder builder=Response.ok();
//     return builder.entity(use).build();
//	}
	// for user Shares 

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String shares(UserShare userShares) {

		boolean save = userServiceDelegate.saveUserShares(userShares);
		if (save)
			return "sucessfully shared..";
		else
			return "failed..";
	}

	@GET
	@Path("/postedShares/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> postedShares(@PathParam("userId") Long userId) {


		return userServiceDelegate.readPostedUserShares(userId);

	}

	@GET
	@Path("/receivedShares/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> receivedShares(@PathParam("userId") Long userId) {

		return userServiceDelegate.readReceivedUserShares(userId);
	}

	


}
