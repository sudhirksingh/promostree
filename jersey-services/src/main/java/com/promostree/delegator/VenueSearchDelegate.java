package com.promostree.delegator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;
import com.promostree.service.core.CoreService;
import com.promostree.service.search.SearchServices;

@Component
public class VenueSearchDelegate {
	@Autowired
	SearchServices searchServices;

	@Autowired
	CoreService coreServices;

	public List<Venue> VenuesService(User user) {
		List<Venue> venues = searchServices.nearestVenues(user);
		return venues;
	}

	public Venue VenueService(Venue venue) {

		Venue returnVenue = coreServices.getVenue(venue);

		return returnVenue;
	}

	public boolean getIndexing() {

		boolean result = searchServices.indexing();

		return result;
	}

	public boolean getIndexing(List<Venue> venues) {

		boolean result = searchServices.indexing(venues);

		return result;
	}
	
	public VenueSearchDelegate() {
		System.out.println("VenueSearchDelegate");
	}

}
