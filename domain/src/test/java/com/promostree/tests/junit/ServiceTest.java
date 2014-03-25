package com.promostree.tests.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Address;
import com.promostree.domain.entities.Category;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Shout;
import com.promostree.domain.entities.User;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.solr.SolrVenue;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.CategoryRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.OfferRepository;
import com.promostree.repositories.entities.ShoutRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.service.SearchServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public class ServiceTest {
	@Autowired
	VenueRepository vrep;
	@Autowired
	SearchServiceImpl vs;

	@Test
	public void testIndexing() {

	}

	@Test
	public void ServicesTest() {
		// vs.indexing();

		// v.save();
		// v.read();
		// v.readAll();
		User user = new User();
		user.setSearchTeam("Ice");
		user.setLat(17.43705);
		user.setLng(78.44387);
		user.setRadius(10.0);

		List<Venue> venues = vs.nearestVenues(user);

		int i = 0;

		for (Venue v : venues) {
			// vrep.save(v);

			System.out.println(v.getName() + "  " + ++i);

			for (Offer o : v.getOffers()) {

				System.out.println(o.getShout().getSubject());
			}
		}

	}

	/*
	 * @Test public void toSolrDomain(){
	 * 
	 * List<Venues> vss= vs.entitiyToDoc(); for(Venues v:vss){
	 * 
	 * System.out.println(":vid:"+v.getId()+" :catid: "+v.getCat_id()+" :catname: "
	 * +
	 * v.getCat_name()+" :city: "+v.getCity()+" :fsid: "+v.getFs_id()+" :lat: "+
	 * v.getLat()+" :offid: "+v.getOffer_id()+" :shout id: "+v.getShout_id()+
	 * " :shout: "+v.getShout());
	 * 
	 * } }
	 * 
	 * @Test public void nearestVenues() throws Exception { int dist = 5; double
	 * lat = 17.3660; double lng = 78.4760; List<Venues> v1 =
	 * vs.nearestVenues(lat, lng, dist); int i = 0; for (Venues v : v1) {
	 * System.out.println(dist + "km nearest venue :   " + ++i + "    " +
	 * v.getId()); }
	 * 
	 * }
	 */
}
