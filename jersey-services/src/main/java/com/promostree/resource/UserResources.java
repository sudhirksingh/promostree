package com.promostree.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShout;

/**
 * 
 * @author visi
 * 
 */
@Path("/userservice")
public class UserResources {

	@Autowired
	UserServiceDelegate userServiceDelegate;
   
	/**
	 * initial Registration of new user
	 */
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response intialRegistration(User user) {
		User dbUser = userServiceDelegate.saveUserCredentials(user);
		return Response.ok().entity(dbUser).build();
	}

	@POST
	@Path("/shout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AudituingUserShot(UserShout userShout) {
		String usershout = userServiceDelegate.saveUserShout(userShout);
		ResponseBuilder builder = Response.ok();
		return builder.entity(usershout).build();
	}

	// to read notifications
		@POST
		@Path("/readNotifications")
		@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
		public List<Notification> readNotifications(User user) {
		
			return userServiceDelegate.readNotifications(user);
		}
	
	

	// to save user preference
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/savePreference")
	public String saveUserPreference(UserPreference userPreference) {
		return userServiceDelegate.saveUserPreference(userPreference);
	}
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/saveUserShare")
	public  boolean saveUserShare(NotificationUserShare notificationUserShare) {
		return userServiceDelegate.saveUserShares(notificationUserShare);
	}
	
	//to read user preference


	
}
