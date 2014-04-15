package com.promostree.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.promostree.delegator.UserServiceDelegate;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShare;

@Path("/userservice")
public class UserResources {
	@Autowired
	UserServiceDelegate userServiceDelegate;

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
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/postedShares/{userId}")
	public List<UserShare> readPostedShares(long userId) {

		return userServiceDelegate.readPostedUserShares(userId);
	}

	// to read share which are received
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/receivedShares/{userId}")
	public List<UserShare> readReceivedShares(long userId) {

		return userServiceDelegate.readReceivedUserShares(userId);

	}

	// to save user preference
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/savePreference")
	public List<UserPreference> saveUserPreference(List<UserPreference> userPreference) {
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

		User save = userServiceDelegate.saveUserCredentials(user);
		if (save.equals(user))
			return "registered successfully...";
		else
			return "conflict ...";
	}

}
