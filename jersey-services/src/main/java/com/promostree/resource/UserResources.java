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
import com.promostree.domain.user.UserPreference;
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

	// to save user share
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String share(UserShare userShares) {

		boolean save = userServiceDelegate.saveUserShares(userShares);
		if (save)
			return "sucessfully shared..";
		else
			return "failed..";
	}

	// to read shares which are posted
	@GET
	@Path("/postedShares/{userId}")
<<<<<<< HEAD
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> postedShares(@PathParam("userId") Long userId) {

=======
	public List<UserShare> readPostedShares(long userId) {
>>>>>>> ffa3bd65c1462b4e3339d8c544b00e130ee01c73

		return userServiceDelegate.readPostedUserShares(userId);
	}

	// to read share which are received
	@GET
	@Path("/receivedShares/{userId}")
<<<<<<< HEAD
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> receivedShares(@PathParam("userId") Long userId) {
=======
	public List<UserShare> readReceivedShares(long userId) {
>>>>>>> ffa3bd65c1462b4e3339d8c544b00e130ee01c73

		return userServiceDelegate.readReceivedUserShares(userId);
	}

<<<<<<< HEAD
	
=======
	// to save user preference
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/savePreference")
	public UserPreference saveUserPreference(UserPreference userPreference) {
		return userServiceDelegate.saveUserPreference(userPreference);
	}

	// to read user preference
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/readPreference")
	public List<UserPreference> readUserPreference(User user) {
		return userServiceDelegate.readUserPreference(user);
	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/login")
	public String receivedShares(User user) {
>>>>>>> ffa3bd65c1462b4e3339d8c544b00e130ee01c73


}
