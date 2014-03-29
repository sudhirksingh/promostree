package com.promostree.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promostree.domain.entities.Venue;
import com.promostree.repositories.entities.VenueRepository;

@Service
public class CoreServiceImpl implements CoreService{
	@Autowired
	VenueRepository domainRepository;

	@Override
	public Venue getVenue(Venue venue) {
		Venue returnVenue=domainRepository.findById(venue.getId());
		return returnVenue;
	}

}
