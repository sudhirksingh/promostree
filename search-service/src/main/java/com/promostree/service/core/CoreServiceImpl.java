package com.promostree.service.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.promostree.domain.entities.Venue;
import com.promostree.repositories.entities.VenueRepository;


@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,timeout=100)
public class CoreServiceImpl implements CoreService{
	private static final Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);
	
	@Autowired
	VenueRepository domainRepository;


	public Venue getVenue(Venue venue) {
		logger.info("enter into getVenue================================================================");
		Venue returnVenue=domainRepository.findById(venue.getId());
		return returnVenue;
	}

	
	

}
