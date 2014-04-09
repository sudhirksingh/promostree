package com.promostree.test;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.promostree.domain.entities.Venue;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.CategoryRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.OfferRepository;
import com.promostree.repositories.entities.ShoutRepository;
import com.promostree.repositories.entities.VenueRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-application-context.xml")

public class DomainTests {

	
	
	@Autowired
	AddressRepository arep ;
	@Autowired
	LocationRepository lrep;
	@Autowired
	VenueRepository vrep ;
	@Autowired
	CategoryRepository crep ;
	@Autowired
	OfferRepository orep ;
	@Autowired
	ShoutRepository srep ;
	
	
	/*	@Test
	public void save() throws ParseException
	{
		
		
	
		Location l1=new Location();
		l1.setLat(17.444);
		l1.setLng(78.333);
		lrep.save(l1);
		
		Address add=new Address();
		add.setCity("vij");
		add.setCountry("india");
		add.setLandMark("ap bavan");
		add.setState("ap");
		add.setZip("520010");
		
		add.setLocation(l1);
		arep.save(add);
		
		Category c=new Category();
		c.setName("food");
		crep.save(c);
		
		Venue v=new Venue();
		v.setName("food");
		v.setFourSquareId("dd");
		v.setAddress(add);
		v.setImage("http://");
		v.setVerified("verified");
		v.setCategory(c);
		
		v.setActive(false);
		v.setCreatedBy("visigenix");
		v.setUpdatedBy("visigenix");
		v.setCreatedDate(new Date());
		v.setUpdatedDate(new Date());
		
		vrep.save(v);
		
		Offer o1=new Offer();
		o1.setSubject("special offer");
		o1.setDescription("special offer content ");
		o1.setVenue(v);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		//String dateInString = "2014-11-2";
		//Date date = sdf.parse(dateInString);
		o1.setStartingDate(new Date());
		o1.setEndingDate(sdf.parse("2014-11-2"));
		
		o1.setActive(false);
	o1.setCreatedBy("visigenix");
		o1.setUpdatedBy("visigenix");
		o1.setCreatedDate(new Date());
		o1.setUpdatedDate(new Date());
		
		orep.save(o1);
		
		Offer o2=new Offer();
		o2.setSubject("specail offer 50% off");
		o2.setDescription("special offer 50% off description   ");
		o2.setVenue(v);
		o2.setStartingDate(new Date());
		o2.setEndingDate(sdf.parse("2014-11-22"));
		
		
		o2.setActive(false);
	o2.setCreatedBy("visigenix");
		o2.setUpdatedBy("visigenix");
		o2.setCreatedDate(new Date());
		o2.setUpdatedDate(new Date());
		
		orep.save(o2);
		
		Shout s1=new Shout();
		s1.setSubject("specail offer");
				s1.setOffer(o1);
		
		
		s1.setActive(false);
	s1.setCreatedBy("visigenix");
		s1.setUpdatedBy("visigenix");
		s1.setCreatedDate(new Date());
		s1.setUpdatedDate(new Date());
		
		srep.save(s1);
		
		
		Shout s2=new Shout();
		s2.setSubject("special offer 50% off");
				s2.setOffer(o2);
		
		s2.setActive(false);
		s2.setCreatedBy("visigenix");
			s2.setUpdatedBy("visigenix");
			s2.setCreatedDate(new Date());
			s2.setUpdatedDate(new Date());
			
			srep.save(s2);
		
			
	}

	

@Test
	public void save1() throws ParseException
	{
		
		
	
		Address add=new Address();
		add.setCity("hyderabad");
		add.setCountry("india");
		add.setLandMark("ap bavan");
		add.setState("ap");
		add.setZip("500070");
		arep.save(add);
		
		Location l1=new Location();
		l1.setLat(17.444);
		l1.setLng(78.333);
		l1.setAddress(add);
		lrep.save(l1);
		
		Category c=new Category();
		c.setName("computers");
		crep.save(c);
		
		Venue v=new Venue();
		v.setName("computer");
		v.setAddress(add);
		v.setImage("http://");
		v.setVerified("verified");
		v.setCategory(c);
		vrep.save(v);
		
		Offer o1=new Offer();
		o1.setDescription("special offer on computer");
		o1.setVenue(v);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		//String dateInString = "2014-11-2";
		//Date date = sdf.parse(dateInString);
		o1.setStartingDate(new Date());
		o1.setEndingDate(sdf.parse("2014-11-2"));
		orep.save(o1);
		
		Offer o2=new Offer();
		o2.setDescription("special offer 50% off on computer");
		o2.setVenue(v);
		o2.setStartingDate(new Date());
		o2.setEndingDate(sdf.parse("2014-11-22"));
		orep.save(o2);
		
		Shout s1=new Shout();
		s1.setDesciption("special offer on computer");
		s1.setOffer(o1);
	
		srep.save(s1);
		
		
		Shout s2=new Shout();
		s2.setDesciption("special offer 50% off on computer");
		s2.setOffer(o2);
	
		srep.save(s2);
		
			
	}
	
	*/

	@Test
	public void read()
	{
		Venue venue=vrep.findById((long)1);
		
		
		System.out.println(venue.getAddress().getId().toString());
		//System.out.println(venue.getOffers().get(1).getShout());
		
		System.out.println(venue.getOffers().get(1).getShout());
		Shout s=srep.findOne((long)1);
		System.out.println(venue.getOffers().get(1).getShout());
		
	}
	
	/*@Test
	public void readAll()
	{
		List<Venue> venues=vrep.findAll();
		for(Venue venue:venues)
		{
		System.out.println(venue.getAddress().getId().toString());
		}
	}
	
	
	public void deleteVenue()
	
	
	
	public void deleteVenue()
	{
		vrep.delete((long)1);
		
	}
	
	public void updateVenue()
	{
		Venue venue=vrep.findById((long)1);
		venue.setActive(true);
		
		vrep.saveAndFlush(venue);
		
	}
	
	*/
}