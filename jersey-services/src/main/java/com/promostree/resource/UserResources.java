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
import com.promostree.domain.user.UserShare;

@Path("/userservice")
public class UserResources {
	@Autowired
	UserServiceDelegate userServiceDelegate;

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
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/postedShares/{userId}")
	public List<UserShare> postedShares(long userId) {

		return userServiceDelegate.readPostedUserShares(userId);

	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/receivedShares/{userId}")
	public List<UserShare> receivedShares(long userId) {

		return userServiceDelegate.readReceivedUserShares(userId);

	}

	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/login")
	public String receivedShares(User user) {

		boolean save = userServiceDelegate.saveUserCredentials(user);
		if (save)
			return "registered successfully...";
		else
			return "conflict ...";
	}

}
