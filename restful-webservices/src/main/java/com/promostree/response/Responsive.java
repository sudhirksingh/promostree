package com.promostree.response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.delegator.VenueSearchDelegate;
import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;

@Path("service")
@Component
public class Responsive {
	@Autowired
	VenueSearchDelegate venueSearchDelegate;
	@GET
	@Path("/venues")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venue> getData(@QueryParam("lat") double lat,
			                   @QueryParam("lng") double lng, 
			                   @QueryParam("radius") double radius, 
			                   @QueryParam("pageNumber") int pageNumber,
			                   @QueryParam("searchTerm") String searchTerm) {
		User user = new User();
		user.setLat(lat);
		user.setLng(lng);
		user.setRadius(radius);
		user.setPageNumber(pageNumber);
		user.setSearchTerm(searchTerm);
		System.out.println(lat + "," + lng + "," + radius+"pageNo:"+pageNumber);
		List<Venue> list = venueSearchDelegate.VenuesService(user);
		return list;
	}
	
	
	@GET
	@Path("/venue")
	@Produces(MediaType.APPLICATION_JSON)
	public Venue getVenue(@QueryParam("venueId") long venueId) {
	Venue venue = new Venue();
	venue.setId(venueId);
	System.out.println(venueId);
	Venue returnVenue = venueSearchDelegate.VenueService(venue);
	System.out.println(returnVenue.getCreatedBy()+", "+returnVenue.getOffers().get(1).getSubject()+" ,"+returnVenue.getAddress().getCity()+" ," +returnVenue.getOffers().get(1).getShout().getSubject()+returnVenue.getCategory().getName());
	
	
	return returnVenue;
	}
	
	
	@GET
	@Path("/indexing")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getIndexing() {
	boolean result  = venueSearchDelegate.getIndexing();
	
	return result;
	}
	
	
	
//	public Responsive() {
//		System.out.println("cons");
//	}
}
