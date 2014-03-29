package com.promostree.service.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.solr.SolrVenue;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.solr.SolrVenueRepository;

@Service
public class SearchServiceImpl implements SearchServices {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);


	@Autowired
	VenueRepository domainRepository;

	@Autowired
	SolrVenueRepository solrRepository;
	
	@Autowired
	SearchHelper searchServiceHelper;

	
	
	// indexing
	@Override
	public boolean indexing() {
		logger.info("enter into indexing ()");
		List<Venue> domainVenues = searchServiceHelper.getVenuesFromSource();	
		return indexing(domainVenues);
		
	}
	
	@Override
	public boolean indexing(List<Venue> venues) {
		logger.info("enter into indexing(List<Venue> venues)");
		boolean result = false;
		for (Venue venue : venues) {
			List<SolrVenue> docs = searchServiceHelper.getOfferInVenue( venue);			
			solrRepository.save(docs);
			result = true;
		}

		return result;
	}

	
	// search on nearest venues based on lat,lng
		@Override
		public List<Venue> nearestVenues(User user) {
			
			logger.info("enter into nearestVenues(User user) ");
			double lat=user.getLat(); 
			double lng=user.getLng();
			double radius=user.getRadius();
			int pageNumber=user.getPageNumber();
			String searchTerm=user.getSearchTerm();
		
			
			List<SolrVenue> solrVenue=null;
			if(searchTerm!=null)
			{
				solrVenue=solrRepository.findByQueryAnnotation(lat, lng,radius,searchTerm,new PageRequest(pageNumber,30));
			}
			else{solrVenue=solrRepository.findByQueryAnnotation(lat, lng,radius,new PageRequest(pageNumber,30));}
			

			
			return searchServiceHelper.toDomainVenues(solrVenue,user);
		}

	
	
}
