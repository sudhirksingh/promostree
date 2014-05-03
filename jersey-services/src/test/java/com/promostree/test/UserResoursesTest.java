package com.promostree.test;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShout;
import com.promostree.resource.UserResources;

public class UserResoursesTest extends JerseyTest {
	   @Override
	    protected Application configure() {
	        return  new ResourceConfig(UserResources.class);
	    }

	    @Override
	    protected URI getBaseUri() {
	        return UriBuilder.fromUri(super.getBaseUri()).path("userservice").build();
	    }
	    
	    @Test
	    public void testUserRegistration() {
	    	User user =new User();
	    	user.setEmail("naresh@gmail.com");
			user.setPhoneNumber("9035288863");
	    	Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);
	      Response response = target("userservice/login").request().post(userEntity);
	      System.out.println(response);
	      Assert.assertEquals("9035288863", response.readEntity(User.class).getPhoneNumber());
	    }
	 /*   @Test
	    public void testUserShout() {
	    	UserShout userShout =new UserShout();
	        userShout.setComment("motogi.....");
	        userShout.setCreatedDate(new Date());
	        User user= new  User();
	        user.setId(6L);
	        userShout.setUser(user);
	        Venue venue = new Venue();
	        venue.setId(3L);
	        userShout.setVenue(venue);
	    	Entity<UserShout> userEntity = Entity.entity(userShout, MediaType.APPLICATION_JSON);
	      Response response = target("userservice/shout").request().post(userEntity);
	      System.out.println(response);
	      Assert.assertEquals("768759473", response.readEntity(User.class).getPhoneNumber());
	    }*/
}
