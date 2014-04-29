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
import com.promostree.domain.user.Notification1;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;

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
	 UserProfile use	= userServiceDelegate.saveUserCredentials(user);
	 ResponseBuilder builder=Response.ok();
     return builder.entity(use).build();
	}
	
    // to save the usershout
	@POST
	@Path("/shout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AudituingUserShot(UserShout userShout)
	{
	 String  use=userServiceDelegate.saveUserShout(userShout);
	 ResponseBuilder builder=Response.ok();
     return builder.entity(use).build();
	}
	// to read shares which are posted
		@GET
		@Path("/postedShouts/{userId}")
		@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
		public List<UserShout> readShouts(@PathParam("userId") Long userId) {
			User user=new User();
			user.setId(userId);
			return userServiceDelegate.readUserShout(user);
		}
	//to save the user shares
/*	@POST
	@Path("/share")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String share(UserShare userShares,List<User> users) {
		boolean save = userServiceDelegate.saveUserShares(userShares,users);
		if (save)
			return "sucessfully shared..";
		else
			return "failed..";
	}*/
	// to read shares which are posted
	@GET
	@Path("/postedShares/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> postedShares(@PathParam("userId") Long userId) {
		return userServiceDelegate.readPostedUserShares(userId);
	}

	// to read share which are received
	@GET
	@Path("/receivedShares/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserShare> receivedShares(@PathParam("userId") Long userId) {
		return userServiceDelegate.readReceivedUserShares(userId);
	}
	// to save user preference
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/savePreference")
	public boolean saveUserPreference(List<UserPreference> userPreference) {
		return userServiceDelegate.saveUserPreference(userPreference);
	}
	// to read user preference
	@GET
	@Path("/readPreference/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserPreference> readUserPreference(@PathParam("userId") Long userId) {
		User user=new User();
		user.setId(userId);
		return userServiceDelegate.readUserPreference(user);
	}
	// to read notifications
	@GET
	@Path("/readNotifications/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Notification1> readNotifications(@PathParam("userId") Long userId) {
		return userServiceDelegate.readNotifications(userId);
	}
}





