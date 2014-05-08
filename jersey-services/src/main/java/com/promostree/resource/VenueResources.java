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
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;

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
			@QueryParam("typeId") long typeId) {
		UserPreference userPreference=new UserPreference();
		Type type=new Type();
		type.setId(typeId);
	
		User user=new User();
		user.setId(userId);
		user.setLat(lat);
		user.setLng(lng);	
		user.setRadius(radius);
		user.setPageNumber(pageNumber);
		userPreference.setUser(user);
		userPreference.setType(type);
		/*UserPreference userPreference=new UserPreference();
		User user=new User();
		user.setId(2L);
		user.setLat(17.24154);
		user.setLng(78.23541254);	
		user.setRadius(1000.0);
	
		
		userPreference.setUser(user);
		Type type=new Type();
		type.setId(1L);
		userPreference.setType(type);*/
	
		//System.out.println(new String(i+""));
		List<Venue> list = venueSearchDelegate.getPreferredVenues(userPreference);
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
