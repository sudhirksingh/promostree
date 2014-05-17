package com.promostree.service.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.stereotype.Component;

import com.promostree.domain.entities.Address;
import com.promostree.domain.entities.Category;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Shout;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.solr.SolrVenue;
import com.promostree.domain.user.User;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.solr.SolrVenueRepository;
import com.promostree.repositories.user.UserFeedbackRepository;
import com.promostree.repositories.user.UserPreferenceRepository;
import com.promostree.repositories.user.UserShareRepository;
import com.promostree.repositories.user.UserShoutRepository;

@Component
public class SearchHelper {
	private static final Logger logger = LoggerFactory.getLogger(SearchHelper.class);


	@Autowired
	VenueRepository domainRepository;

	@Autowired
	SolrVenueRepository solrRepository;
	@Autowired
	UserShareRepository userSharesRepository;
	@Autowired
	UserShoutRepository userShoutRepository;
	@Autowired
	UserPreferenceRepository userPreferencesRepository;
	@Autowired
	UserFeedbackRepository userFeedbackRepository;

public List<SolrVenue> getOfferInVenue( Venue venue) {
	logger.info("enter into getOfferInVenue( Venue venue)============================== ");
		String searchField;
		Shout shout;
		List<SolrVenue> solrVenues = new ArrayList<SolrVenue>();
		
		List<Offer> offs = venue.getOffers();
		
		for (Offer offer : offs) {
			SolrVenue doc = new SolrVenue();
			// System.out.println(venue.getId() + "\n\n\n\n");
			shout = offer.getShout();
			// Document id
			doc.setId(venue.getId().toString() + "_"+offer.getId()+"_"+shout.getId());

			// venue
			doc.setEntity_id(venue.getId().toString());
			doc.setName(venue.getName().toLowerCase());
			doc.setImg_url(venue.getImage());
			doc.setVerified(venue.getVerified());
			
			doc.setActive(venue.isActive()+"");
			doc.setUpdated_by(venue.getUpdatedBy().toLowerCase());
			doc.setUpdated_dt(venue.getUpdatedDate().toString().toLowerCase());
			doc.setCreated_by(venue.getCreatedBy().toLowerCase());
			doc.setCreated_dt(venue.getCreatedDate().toString().toLowerCase());
			// venues.setFs_id(venue.);

			// Address
			doc.setAddress_id(venue.getAddress().getId().toString().toLowerCase());
			doc.setCity(venue.getAddress().getCity().toLowerCase());
			doc.setCountry(venue.getAddress().getCountry().toLowerCase());
			doc.setRegion(venue.getAddress().getLandMark().toLowerCase());
			doc.setState(venue.getAddress().getState().toLowerCase());
			doc.setZip(venue.getAddress().getZip());

			// Location
			doc.setGeolocation(new GeoLocation(venue.getAddress().getLocation().getLat(),venue.getAddress().getLocation().getLng()));
			doc.setLocation_id(venue.getAddress().getLocation().getId()
					.toString());
			doc.setGeolocation(new GeoLocation(venue.getAddress().getLocation().getLat(),venue.getAddress().getLocation().getLng()));
				

			/*
			 * // group
			 * venues.setBusiness_group(venue.getMerchant().getGroup()
			 * .getName()); venues.setBusiness_group_id(venue.getMerchant
			 * ().getGroup() .getName());
			 */
			// category
			doc.setCat_id(venue.getCategory().getId().toString());
			doc.setCat_name(venue.getCategory().getName().toLowerCase());
			// venues.setSub_cat_name(sub_cat_name);

			// offer
			doc.setOffer_id(offer.getId().toString());
			doc.setOffer(offer.getSubject().toLowerCase());
			doc.setEnd_dt(offer.getEndingDate().toString());
			doc.setOffer_desc(offer.getDescription().toLowerCase());
			doc.setStart_dt(offer.getStartingDate().toString().toLowerCase());

			doc.setOffer_active(offer.isActive()+"");
			doc.setOffer_updated_by(offer.getUpdatedBy());
			doc.setOffer_updated_dt(offer.getUpdatedDate().toString());
			doc.setOffer_created_by(offer.getCreatedBy().toLowerCase());
			doc.setOffer_created_dt(offer.getCreatedDate().toString());
			// shouts

			// venues.setShout(shout.g);
		
			doc.setShout(shout.getSubject().toLowerCase());
			doc.setShout_id(shout.getId().toString());
			
			doc.setShout_active(shout.isActive()+"");
			doc.setShout_updated_by(shout.getUpdatedBy().toLowerCase());
			doc.setShout_updated_dt(shout.getUpdatedDate().toString());
			doc.setShout_created_by(shout.getCreatedBy().toLowerCase());
			doc.setShout_created_dt(shout.getCreatedDate().toString());
			searchField = shout.getSubject().toLowerCase() + " "
					+ offer.getSubject().toLowerCase() + " "
					+ venue.getCategory().getName().toLowerCase() + " "
					+ venue.getName().toLowerCase();
			doc.setSearch_field(searchField);
			
			
			
			/* // merchant venues.setMerchant_id(venue.getMerchant().getId()
			 * .toString());
			 * venues.setMerchant_name(venue.getMerchant().getName());
			 * venueSolr.add(venues);
			 */
			
			solrVenues.add(doc);
		}
		return solrVenues;
	}


	public List<Venue> getVenuesFromSource() {
		logger.info("enter into getVenuesFromSource()============================== ");
		List<Venue> domainVenues = domainRepository.findAll();
		return domainVenues;
	}

	// to convert solr documents to domain venues 

	public List<Venue> toDomainVenues(List<SolrVenue> docsWithDiffId,User user) {

		logger.info("enter into  toDomainVenues(List<SolrVenue> docsWithDiffId,User user)============================== ");
		// documents with same entity id
		List<SolrVenue> docsWithSameId = new ArrayList<SolrVenue>();

		List<Venue> domainVenues = new ArrayList<Venue>();

		Set<String> entityIds = new HashSet<String>();

		for (SolrVenue venue : docsWithDiffId) {
			entityIds.add(venue.getEntity_id());
			
		}

		for (String entityId : entityIds) {
			for (SolrVenue doc2 : docsWithDiffId) {

				if (doc2.getEntity_id().equals(entityId)) {
					docsWithSameId.add(doc2);
				}
			}

			if (!docsWithSameId.isEmpty()) {
				domainVenues.add(fromDocToDomainVenue(docsWithSameId,user));
			}
			docsWithSameId.clear();

		}

		return domainVenues;
	}

	
	//convert Documents to single domain venue
	public Venue fromDocToDomainVenue(List<SolrVenue> docsWithSameId,User user) {
		logger.info("enter into  fromDocToDomainVenue(List<SolrVenue> docsWithSameId,User user)============================== ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Venue domainVenue = new Venue();

		if (!docsWithSameId.isEmpty()) {

			SolrVenue doc = docsWithSameId.get(0);

			Address address = new Address();
			Category catogery = new Category();
			Location location = new Location();
            
			address.setCity(doc.getCity());
			address.setCountry(doc.getCountry());
			address.setId(Long.parseLong(doc.getAddress_id()));
			address.setLandMark(doc.getRegion());
			address.setState(doc.getState());
			address.setZip(doc.getZip());

			location.setId(Long.parseLong(doc.getLocation_id()));
			location.setLat(doc.getGeolocation().getLatitude());
			location.setLng(doc.getGeolocation().getLongitude());
            
			address.setLocation(location);

			catogery.setId(Long.parseLong(doc.getCat_id()));
			catogery.setName(doc.getCat_name());

			domainVenue.setAddress(address);
			domainVenue.setCategory(catogery);
			
			double distance=distance(doc.getGeolocation().getLatitude(), doc.getGeolocation().getLongitude(),user.getLat() , user.getLng(),'m');
            domainVenue.setDistance(distance);
			domainVenue.setId(Long.parseLong(doc.getEntity_id()));
			domainVenue.setName(doc.getName());
			domainVenue.setImage(doc.getImg_url());
			domainVenue.setVerified(doc.getVerified());
			domainVenue.setActive(Boolean.valueOf(doc.getActive()));
			domainVenue.setCreatedBy(doc.getCreated_by());
			domainVenue.setUpdatedBy(doc.getUpdated_by());
			try{
			domainVenue.setCreatedDate(sdf.parse(doc.getCreated_dt()));
			domainVenue.setUpdatedDate(sdf.parse(doc.getUpdated_dt()));
			}catch(Exception e){logger.error(e.toString());}

			for (SolrVenue docs : docsWithSameId) {
				Offer offer = new Offer();
				Shout shout = new Shout();
                
				offer.setSubject(doc.getOffer());
				offer.setActive(Boolean.valueOf(doc.getOffer_active()));
				offer.setCreatedBy(doc.getOffer_created_by());
				offer.setUpdatedBy(doc.getOffer_updated_by());
				try{
				offer.setCreatedDate(sdf.parse(doc.getOffer_created_dt()));
				offer.setUpdatedDate(sdf.parse(doc.getOffer_updated_dt()));
				}catch(Exception e){logger.error(e.toString());}
				
				
				offer.setDescription(docs.getOffer_desc());
				
				try {
					offer.setStartingDate(sdf.parse(docs.getStart_dt()));
					offer.setEndingDate(sdf.parse(doc.getEnd_dt()));
				} catch (Exception e) {
					logger.error(e.toString());
				}
				offer.setId(Long.parseLong(docs.getOffer_id()));

				shout.setSubject(docs.getShout());
				shout.setId(Long.parseLong(docs.getShout_id()));
				shout.setActive(Boolean.valueOf(doc.getShout_active()));
				shout.setCreatedBy(doc.getShout_created_by());
				shout.setUpdatedBy(doc.getShout_updated_by());
				
				try
				{
				shout.setCreatedDate(sdf.parse(docs.getShout_created_dt()));
				shout.setUpdatedDate(sdf.parse(docs.getShout_updated_dt()));
			}catch(Exception e){logger.error(e.toString());}
				
				offer.setShout(shout);
				domainVenue.getOffers().add(offer);
                domainVenue.setShareCount(Integer.parseInt(docs.getShare_count()));
                domainVenue.setShoutCount(Integer.parseInt(docs.getShout_count()));
                domainVenue.setPreferenceCount(Integer.parseInt(docs.getPreference_count()));
                domainVenue.setFeedBackCount(Integer.parseInt(docs.getFeedback_count()));
			}

			// System.out.println(domainVenue.getName() + "");

		}
		return domainVenue;

	}

	
	
	

	//distance  b/w two points
	public double distance(double lat1, double lng1, double lat2, double lng2,
			char unit) {

		
		double R = 6371; // km
		double dLat = deg2rad((lat2 - lat1));
		double dLon = deg2rad((lng2 - lng1));
		double l1 = deg2rad(lat1);
		double l2 = deg2rad(lat2);

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2)
				* Math.sin(dLon / 2) * Math.cos(l1) * Math.cos(l2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	//degrees to radii convertion
	private double deg2rad(double deg) {
		
		return (deg * Math.PI / 180.0);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
