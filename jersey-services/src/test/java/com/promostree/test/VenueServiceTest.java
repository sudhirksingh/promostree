package com.promostree.test;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.promostree.domain.entities.Venue;
import com.promostree.resource.VenueResources;


public class VenueServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return  new ResourceConfig(VenueResources.class);
    }

    @Override
    protected URI getBaseUri() {
        return UriBuilder.fromUri(super.getBaseUri()).path("service").build();
    }

//    @Test
//    public void testClientStringResponse() {
//        String s = target().path("service/sample").request().get(String.class);
//        assertEquals("mallik", s);
//    }
    
    @Test
    public void testVenue() {
      Venue v = target().path("service/venue").queryParam("venueId", 2).request().accept(MediaType.APPLICATION_JSON).get(Venue.class);
       //assertEquals("2", rs.readEntity(Venue.class).getId());
      System.out.println(v.getId());
      assertEquals("2", v.getId());
    }
////    
//    @Test
//    public void VenueserachTest() {
//   List<Venue>  venue= (List<Venue>) target().path("service/venues").queryParam("venueid", 2).request().get();
//      venue.
//    }
 //   Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_XML_TYPE);
//    target("users/add").request().post(userEntity); //Here we send POST request
//    Response response = target("users/find").queryParam("email", "user2@mail.com").request().get(); //Here we send GET request for retrieving results
//    Assert.assertEquals("user2@mail.com", response.readEntity(User.class).getEmail());
}

