package com.promostree.service.search;

import java.util.List;



import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;

public interface SearchServices {
	
	public boolean indexing() ;
	
	public boolean indexing(List<Venue> venue) ;
	
	public List<Venue> nearestVenues(User user);
	
	public List<Venue> findBySearch_fieldIn(User user);
}
