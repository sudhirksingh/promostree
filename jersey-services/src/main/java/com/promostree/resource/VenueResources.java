package com.promostree.resource;

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

import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.User;

@Path("service")
@Component
public class VenueResources {
	@Autowired
	VenueSearchDelegate venueSearchDelegate;

	@GET
	@Path("/preferredVenues")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venue> getPreferenceVenues(@QueryParam("userId") long userId,
			@QueryParam("lat") double lat, @QueryParam("lng") double lng,
			@QueryParam("radius") double radius,
			@QueryParam("pageNumber") int pageNumber,
			@QueryParam("searchTerm") String searchTerm) {
		
	String i=new String("2");
		User user=new User();
		user.setId(userId);
		user.setLat(lat);
		user.setLng(lng);	
		user.setRadius(radius);
		user.setPageNumber(pageNumber);
		user.setSearchTerm(searchTerm);
		//System.out.println(new String(i+""));
		List<Venue> list = venueSearchDelegate.getPreferredVenues(user);
		return list;
	}

	@GET
	@Path("/venues")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venue> getData(@QueryParam("lat") double lat,
			@QueryParam("lng") double lng, @QueryParam("radius") double radius,
			@QueryParam("pageNumber") int pageNumber,
			@QueryParam("searchTerm") String searchTerm) {
		User user = new User();
		user.setLat(lat);
		user.setLng(lng);
		user.setRadius(radius);
		user.setPageNumber(pageNumber);
		user.setSearchTerm(searchTerm);
		List<Venue> list = venueSearchDelegate.VenuesService(user);
		return list;
	}

	@GET
	@Path("/venue")
	@Produces(MediaType.APPLICATION_JSON)
	public Venue getVenue(@QueryParam("venueId") long venueId) {
		Venue venue = new Venue();
		venue.setId(venueId);
		Venue returnVenue = venueSearchDelegate.VenueService(venue);
		// System.out.println(venueId);
		// System.out.println(returnVenue.getCreatedBy()+", "+returnVenue.getOffers().get(1).getSubject()+" ,"+returnVenue.getAddress().getCity()+" ,"
		// +returnVenue.getOffers().get(1).getShout().getSubject()+returnVenue.getCategory().getName());
		return returnVenue;
	}

	@GET
	@Path("/indexing")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getIndexing() {
		boolean result = venueSearchDelegate.getIndexing();
		return result;
	}
	//
	// @GET
	// @Path("/sample")
	// public String something()
	// {
	// return "mallik";
	// }
	//

}
