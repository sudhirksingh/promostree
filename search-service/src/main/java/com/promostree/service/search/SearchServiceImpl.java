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

import com.promostree.domain.entities.Venue;
import com.promostree.domain.solr.SolrVenue;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.repositories.entities.BrandRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.solr.SolrVenueRepository;
import com.promostree.repositories.user.UserPreferencesRepository;

@Service
public class SearchServiceImpl implements SearchServices {

	private static final Logger logger = LoggerFactory
			.getLogger(SearchServiceImpl.class);

	@Autowired
	VenueRepository domainRepository;
	@Autowired
	SolrVenueRepository solrRepository;
	@Autowired
	SearchHelper searchServiceHelper;
	@Autowired
	UserPreferencesRepository userPreferenceRepository;
	@Autowired
	BrandRepository brandRepository;

	// indexing

	public boolean indexing() {
		logger.info("enter into indexing ()");
		List<Venue> domainVenues = searchServiceHelper.getVenuesFromSource();
		return indexing(domainVenues);

	}

	public boolean indexing(List<Venue> venues) {
		logger.info("enter into indexing(List<Venue> venues)");
		boolean result = false;
		for (Venue venue : venues) {
			List<SolrVenue> docs = searchServiceHelper.getOfferInVenue(venue);
			solrRepository.save(docs);
			result = true;
		}

		return result;
	}

	// search on nearest venues based on lat,lng

	public List<Venue> nearestVenues(User user) {

		logger.info("enter into nearestVenues(User user) ");
		double lat = user.getLat();
		double lng = user.getLng();
		double radius = user.getRadius();
		int pageNumber = user.getPageNumber();
		String searchTerm = user.getSearchTerm();

		List<SolrVenue> solrVenue = null;
		if (searchTerm != null) {
			solrVenue = solrRepository.findByQueryAnnotation(lat, lng, radius,
					searchTerm, new PageRequest(pageNumber, 30));
		} else {
			solrVenue = solrRepository.findByQueryAnnotation(lat, lng, radius,
					new PageRequest(pageNumber, 30));
		}

		return searchServiceHelper.toDomainVenues(solrVenue, user);
	}
	 

	// search on Multiple search fields
	public List<Venue> findBySearch_fieldIn(UserPreference userPreference) {
		User user = userPreference.getUser();
		int pageNumber = 0;
		List<String> searchTerms = new ArrayList<String>();
		List<UserPreference> userPreferences = new ArrayList<UserPreference>();
		List<SolrVenue> solrVenues = new ArrayList<SolrVenue>();
		userPreferences = userPreferenceRepository.findByUserIdAndTypeId(
				user.getId(), userPreference.getType().getId());

		for (UserPreference userPreference1 : userPreferences) {
			System.out.println(
					userPreference1.getValue());
			if (userPreference1.getType().getId() == 1) {  //FOR Brand type preferences
				searchTerms.add(brandRepository.findOne(
						userPreference1.getValue()).getName());
				solrVenues.addAll(solrRepository.findBySearch_fieldIn(searchTerms, new PageRequest(pageNumber, 30)));
			
			} else if (userPreference1.getType().getId() == 2) { // for preferred venues 
				searchTerms.add(solrRepository
						.findByEntity_id(userPreference1.getValue().toString())
						.get(0).getName());
				solrVenues.addAll(solrRepository.findBySearch_fieldIn(searchTerms, new PageRequest(pageNumber, 30)));

			}
		}

		return searchServiceHelper.toDomainVenues(solrVenues, user);
	}
}
