package com.promostree.tests.junit;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.solr.SolrVenue;
import com.promostree.service.SearchServiceImpl;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")

public class SolrTest {

	@Autowired
	 SearchServiceImpl vs;

	@Test
	public void nearestVenues() throws Exception {
		User user=new User();
		user.setLat(12.444);
		user.setLng(233.333);
		user.setRadius(20.0);
		
		
	List<Venue> v1=	vs.nearestVenues(user);
		int i = 0;
		for (Venue v : v1) {
			System.out.println(user.getRadius() + "km nearest venue :   " + ++i + "    "
					+ v.getId());
		}
	}

	

}
