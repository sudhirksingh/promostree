package com.promostree.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
			String searchTerm=user.getSearchTeam();
		
			String lat1 = new Double(lat).toString().substring(0, 3);
			String lng1 = new Double(lng).toString().substring(0, 3);

			List<SolrVenue> v2 = new ArrayList<SolrVenue>();
			for (SolrVenue doc : solrRepository.findByQueryAnnotation(searchTerm,lat1, lng1)) {
				String lat2 = doc.getLat();
				String lng2 = doc.getLng();
				if (searchServiceHelper.distance(lat, lng, Double.parseDouble(lat2),
						Double.parseDouble(lng2), 'k') <= radius) {
					v2.add(doc);
				}
			}
			return searchServiceHelper.toDomainVenues(v2);
		}

	
	
}
