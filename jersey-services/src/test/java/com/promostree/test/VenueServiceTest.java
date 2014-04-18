package com.promostree.test;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.jws.WebResult;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
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
//
//    @Test
//    public void testClientStringResponse() {
//        String s = target().path("service/sample").request().get(String.class);
//        assertEquals("mallik", s);
//    }
    
    @Test
    public void testVenue() {
      Venue v = target("service/venue").queryParam("venueId",0).request().accept(MediaType.APPLICATION_JSON).get(Venue.class);
       //assertEquals("2", rs.readEntity(Venue.class).getId());
      System.out.println(v);
     // assertEquals("2", v.getId());
    }
    @Test
    public void testVenues() {
    	GenericType<Collection<Venue>> genericType = new GenericType<Collection<Venue>>(){};
      List<Venue> venue = (List<Venue>) target("service/venue").queryParam("lat",17.3660).queryParam("lng", 78.456).queryParam("radius",5.0).queryParam("pageNumber",0).queryParam("searchTerm","ice").request().accept(MediaType.APPLICATION_JSON).get(genericType);
       //assertEquals("2", rs.readEntity(Venue.class).getId());
      System.out.println(venue);
     // assertEquals("2", v.getId());
    }
   
}

