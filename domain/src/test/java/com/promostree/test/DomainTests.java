package com.promostree.test;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.promostree.domain.entities.Address;
import com.promostree.domain.entities.Brand;
import com.promostree.domain.entities.Category;
import com.promostree.domain.entities.Groups;
import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Merchant;
import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Shout;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.tenant.Tenant;
import com.promostree.repositories.entities.AddressRepository;
import com.promostree.repositories.entities.BrandRepository;
import com.promostree.repositories.entities.CategoryRepository;
import com.promostree.repositories.entities.GroupsRepository;
import com.promostree.repositories.entities.LocationRepository;
import com.promostree.repositories.entities.MerchantRepository;
import com.promostree.repositories.entities.OfferRepository;
import com.promostree.repositories.entities.ShoutRepository;
import com.promostree.repositories.entities.VenueRepository;
import com.promostree.repositories.tenant.TenantRepository;



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
	
	@Autowired
TenantRepository trep ;
	
	@Autowired
MerchantRepository mrep ;
	
	@Autowired
GroupsRepository grep ;
	
	@Autowired
	BrandRepository brep ;
	
	
/*		@Test
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
		
		Tenant t=new Tenant();
		t.setActive(true);
		t.setCreatedDate(new Date());
		t.setName("promostree");
		t.setLoginId("promostree");
		t.setPwd("promostree");
	    trep.save(t);
	    
	    Groups g=new Groups();
		g.setName("promoGroup");
		g.setTenant(t);
		grep.save(g);
			
		
	   
	    
	   
	    
	    
	    
		
		Venue v=new Venue();
		v.setName("food");
		v.setFourSquareId("dd");
		v.setAddress(add);
		v.setImage("http://");
		v.setVerified("verified");
		v.setCategory(c);
		v.setTenant(t);
		


		
		v.setActive(false);
		v.setCreatedBy("visigenix");
		v.setUpdatedBy("visigenix");
		v.setCreatedDate(new Date());
		v.setUpdatedDate(new Date());
		vrep.save(v);
		
		
		List<Venue> vs=new ArrayList<Venue>();
		vs.add(v);
		

		
		 Brand b1=new Brand();
		    b1.setCreatedDate(new Date());
		    b1.setActive(true);
		    b1.setName("puma");
		    b1.setVenues(vs);
		    brep.save(b1);
		    
		    Brand b2=new Brand();
		    b2.setCreatedDate(new Date());
		    b2.setActive(true);
		    b2.setName("levis");
		    b2.setVenues(vs);
		    brep.save(b2);
		
		
		 Merchant m=new Merchant();
		    m.setName("visigenix");
		    m.setLoginId("visi");
		    m.setPwd("visi@123");
		    m.setTenant(t);
		    m.setGroup(g);
		    m.setVenue(v);
		    mrep.save(m);
		
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
			
		
		
		
		
			
	}*/

		
	@Test
	public void readVenue()
	{
		//Venue venue=vrep.findById((long)1);
		
		//Brand b=brep.findOne(1L);
		Merchant m=mrep.findOne(1L);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try{
		String json = ow.writeValueAsString(m);
		
		System.out.println(json);
		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
		
	
	/*
		@Test
		public void readMerchant()
		{
			Merchant m=mrep.findOne((long)1);
			
			
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try{
			String json = ow.writeValueAsString(m);
			
			System.out.println(json);
			} catch (JsonGenerationException ex) {

				ex.printStackTrace();

			} catch (JsonMappingException ex) {

				ex.printStackTrace();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		

		
		@Test
		public void readGroups()
		{
			Groups g=grep.findOne((long)1);
			
			
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try{
			String json = ow.writeValueAsString(g);
			
			System.out.println(json);
			} catch (JsonGenerationException ex) {

				ex.printStackTrace();

			} catch (JsonMappingException ex) {

				ex.printStackTrace();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}	
		
		

		
		@Test
		public void readTenant()
		{
			Tenant t=trep.findOne((long)1);
			
			
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try{
			String json = ow.writeValueAsString(t);
			
			System.out.println(json);
			} catch (JsonGenerationException ex) {

				ex.printStackTrace();

			} catch (JsonMappingException ex) {

				ex.printStackTrace();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

		
		*/
	//  Gson gson = new Gson(); 
		//  System.out.println(gson.toJson(venue));
	
	//	System.out.println(venue.getAddress().getId().toString());
		//System.out.println(venue.getOffers().get(1).getShout());
		
	//	System.out.println(venue.getOffers().get(1).getShout());
	//	Shout s=srep.findOne((long)1);
	//	System.out.println(venue.getOffers().get(1).getShout());
		
	
	
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
