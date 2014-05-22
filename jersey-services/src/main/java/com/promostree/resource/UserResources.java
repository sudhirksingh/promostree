package com.promostree.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.server.Uri;
import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.Notification;
import com.promostree.domain.user.NotificationUserShare;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
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
	 * @throws URISyntaxException 
	 */
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response intialRegistration(User user) throws URISyntaxException {
		User dbUser = userServiceDelegate.saveUserCredentials(user);
		return Response.ok().entity(dbUser).build();
	}
	@POST
	@Path("/profile")
	@Consumes(MediaType.APPLICATION_JSON)
	public String ToSaveUserProfile(UserProfile userProfile)
	{
		String data=userServiceDelegate.saveUserProfile(userProfile);
		return data;
	}

	@POST
	@Path("/shout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response SavingUserShot(UserShout userShout) {
		String usershout = userServiceDelegate.saveUserShout(userShout);
		ResponseBuilder builder = Response.ok();
		return builder.entity(usershout).build();
	}

	// to read notifications
		@POST
		@Path("/readNotifications")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
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
	
	@GET
	@Path("/readPreference/{userId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<UserPreference> readUserPreference(@PathParam("userId") Long userId) {
		User user=new User();
		user.setId(userId);
		return userServiceDelegate.readUserPreference(user);
	}
	


	
}
