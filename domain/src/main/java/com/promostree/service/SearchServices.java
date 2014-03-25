package com.promostree.service;

import java.util.List;

import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;

public interface SearchServices {
	
	public boolean indexing() ;
	
	public boolean indexing(List<Venue> venue) ;
	
	public List<Venue> nearestVenues(User user);
	
	
}
