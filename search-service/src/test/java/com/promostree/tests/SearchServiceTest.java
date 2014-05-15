package com.promostree.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.geo.Distance;
import org.springframework.data.solr.core.geo.GeoConverters;
import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.entities.Address;
import com.promostree.domain.entities.Category;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Shout;
import com.promostree.domain.entities.Venue;

import com.promostree.domain.solr.SolrVenue;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.CategoryRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.OfferRepository;
import com.promostree.repositories.entities.ShoutRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.solr.SolrVenueRepository;
import com.promostree.repositories.user.LocationTypeRepository;
import com.promostree.repositories.user.UserLocationRepository;
import com.promostree.repositories.user.UserRepository;
import com.promostree.service.search.SearchServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:search-service-application-context.xml")
public class SearchServiceTest {
	@Autowired
	SolrVenueRepository vrep;
	@Autowired
	SearchServiceImpl vs;

	@Autowired
	LocationTypeRepository ltrep;

	@Autowired
	LocationRepository lrep;

	@Autowired
	UserRepository urep;

	@Autowired
	UserLocationRepository ulrep;

	@Test
	public void preferenceSearch() {
		List<String> fav = new ArrayList<String>();
		UserPreference userPreference = new UserPreference();
		User user = new User();
		user.setId(1L);
		user.setLat(17.24154);
		user.setLng(78.23541254);
		user.setRadius(1000.0);
		user.setPageNumber(0);
		
		userPreference.setUser(user);
		Type type = new Type();
		type.setId(2L);
		userPreference.setType(type);

		List<Venue> venues = vs.findBySearch_fieldIn(userPreference);
		for (Venue venue : venues) {
			System.out
					.println("preference search test  ::  " + venue.getName());
		}
	}

	/*
	 * @Test public void nearest() { //vs.indexing();
	 * 
	 * 
	 * User user=urep.findById((long)2);
	 * 
	 * user.setLat(17.24154); user.setLng(78.23541254);
	 * 
	 * 
	 * //storing the user Location //LocationType
	 * lt=ltrep.findByName("current"); Location l1=new Location();
	 * l1.setLat(user.getLat()); l1.setLng(user.getLng()); //lrep.save(l1);
	 * 
	 * UserLocation ul=new UserLocation(); ul.setCreatedDate(new Date());
	 * ul.setLocation(l1); //ul.setLocationType(lt); ul.setUser(user);
	 * //ulrep.save(ul);
	 * 
	 * 
	 * 
	 * user.setRadius(1000.0); user.setPageNumber(0);
	 * user.setSearchTerm("wine");
	 * 
	 * GeoLocation g=new GeoLocation(17.364320517794,78.476185121817);
	 * //List<SolrVenue>
	 * venues=vrep.findByQueryAnnotation(GeoConverters.GeoLocationToStringConverter
	 * .INSTANCE.convert(new
	 * GeoLocation(17.364320517794,78.476185121817)),GeoConverters
	 * .DistanceToStringConverter.INSTANCE.convert(new Distance(100)));
	 * //List<SolrVenue> venues=vrep.findByQueryAnnotation(new
	 * GeoLocation(17.364320517794,78.476185121817),d); //List<SolrVenue>
	 * venues=
	 * vrep.findByQueryAnnotation(17.364320517794,78.476185121817,d,"ice",new
	 * PageRequest(0, 30)); List<Venue> venues=vs.nearestVenues(user);
	 * //System.out.println(d.getValue()); int i=0; for (Venue v : venues) { //
	 * vrep.save(v);
	 * 
	 * System.out.println(v.getName() + "  imange: "+v.getVerified()+
	 * "  distance:  "+v.getDistance()+" kms      ::"+ ++i);
	 * 
	 * } }
	 */
	@Test
	public void testIndexing() {
		// vs.indexing();
	}

	/*
	 * @Test public void ServicesTest() {
	 * 
	 * // v.save(); // v.read(); // v.readAll(); User user = new User();
	 * user.setSearchTerm("Ice"); user.setLat(17.364320517794);
	 * user.setLng(78.476185121817); user.setRadius(10.0);
	 * 
	 * List<Venue> venues = vs.nearestVenues(user);
	 * System.out.println("===================================="); int i=0;
	 * 
	 * for (Venue v : venues) { // vrep.save(v);
	 * 
	 * System.out.println(v.getName() +
	 * "  imange: "+v.getImage()+" verified "+v.
	 * getVerified()+" fid "+v.getFourSquareId() +"     ::"+ ++i);
	 * 
	 * for (Offer o : v.getOffers()) {
	 * 
	 * System.out.println(o.getShout().getSubject()+" subject "+o.getUpdatedDate(
	 * )+"create "+o.getEndingDate()); } }
	 * 
	 * }
	 * 
	 * 
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
