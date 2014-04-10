package com.promostree.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.solr.SolrVenue;
import com.promostree.repositories.solr.SolrVenueRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")

public class SolrTest {
@Autowired
SolrVenueRepository solrVenueRepository;
	@Test
	public void nearestVenues() throws Exception {
	
		List<SolrVenue> v1=	solrVenueRepository.findByQueryAnnotation("11");
		int i = 0;
		for (SolrVenue v : v1) {
			System.out.println(v.getName() + " " + ++i + "  id:   "
					+ v.getId());
		}
		
		/*	User user=new User();
		user.setLat(12.444);
		user.setLng(233.333);
		user.setRadius(20.0);
		
		
	List<Venue> v1=	vs.nearestVenues(user);
		int i = 0;
		for (Venue v : v1) {
			System.out.println(user.getRadius() + "km nearest venue :   " + ++i + "    "
					+ v.getId());
		}*/
	}

	

}
