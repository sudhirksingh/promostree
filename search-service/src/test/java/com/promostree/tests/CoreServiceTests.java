package com.promostree.tests;



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
import com.promostree.service.core.CoreServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")

public class CoreServiceTests {

	
	
	@Autowired
	CoreServiceImpl service ;
	


	@Test
	public void read()
	{
		Venue venue=new Venue();
		venue.setId((long)1);
		Venue rvenue=service.getVenue(venue);
		System.out.println(rvenue.getCreatedBy()+", "+rvenue.getOffers().get(1).getSubject()+" ,"+rvenue.getAddress().getCity()+" ," +rvenue.getOffers().get(1).getShout().getSubject()+rvenue.getCategory().getName());
		
	}

}
