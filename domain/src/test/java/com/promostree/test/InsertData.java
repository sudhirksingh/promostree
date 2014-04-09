package com.promostree.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class InsertData {

	@Autowired
	AddressRepository arep;
	@Autowired
	LocationRepository lrep;
	@Autowired
	VenueRepository vrep;
	@Autowired
	CategoryRepository crep;
	@Autowired
	OfferRepository orep;
	@Autowired
	ShoutRepository srep;

	/*@Test
	public void save() throws ParseException {
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/promostree", "root", "emp@123");
 int i=0;
		Statement st = con.createStatement();
		String sql = ("SELECT * FROM venues");
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) { 
			
		 String id = rs.getString("vname"); 
		 
		 Location l1 = new Location();
			l1.setLat(Double.parseDouble(rs.getString("lat")));
			l1.setLng(Double.parseDouble(rs.getString("lng")));
			lrep.save(l1);

		 
		 Address add = new Address();
		 
		 String addr=rs.getString("address");
			String ad[]=addr.split("#");
			
					
			add.setCity(ad[2]);
			
			
			add.setCountry(ad[5]);
			add.setLandMark(ad[0]+","+ad[1]);
			add.setState(ad[3]);
			add.setZip(ad[4]);
			add.setLocation(l1);
			arep.save(add);

			
		List<Category> css=crep.findAll();
		for(Category cs:css)
		{
			if(cs.getName().equals(rs.getString("catogery")))
			{
			
			
			Venue v = new Venue();
			v.setFourSquareId(rs.getString("vid"));
			v.setName(rs.getString("vname"));
			v.setAddress(add);
			v.setImage(rs.getString("image"));
			v.setVerified(rs.getString("verified"));
			v.setCategory(cs);
			
			v.setActive(false);
			v.setCreatedBy("foursquare");
			v.setUpdatedBy("visigenix");
			v.setCreatedDate(new Date());
			v.setUpdatedDate(new Date());
			
			vrep.save(v);
			
			

			Offer o1 = new Offer();
			o1.setSubject("special offer"+i);
			o1.setDescription("special offer description"+i);
			o1.setVenue(v);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
			// String dateInString = "2014-11-2";
			// Date date = sdf.parse(dateInString);
			o1.setStartingDate(new Date());
			o1.setEndingDate(sdf.parse("2014-11-2"));
			
			o1.setActive(false);
			o1.setCreatedBy("foursquare");
			o1.setUpdatedBy("visigenix");
			o1.setCreatedDate(new Date());
			o1.setUpdatedDate(new Date());
			
			orep.save(o1);

			Offer o2 = new Offer();
			o2.setSubject("special offer 50% off"+i);
			o2.setDescription("special offer 50% off description"+i);
			o2.setVenue(v);
			o2.setStartingDate(new Date());
			o2.setEndingDate(sdf.parse("2014-11-22"));
			
			o2.setActive(false);
			o2.setCreatedBy("foursquare");
			o2.setUpdatedBy("visigenix");
			o2.setCreatedDate(new Date());
			o2.setUpdatedDate(new Date());
			
			orep.save(o2);

			Shout s1 = new Shout();
			s1.setSubject("special offer"+i);
		
			s1.setOffer(o1);
			s1.setActive(false);
			s1.setCreatedBy("foursquare");
			s1.setUpdatedBy("visigenix");
			s1.setCreatedDate(new Date());
			s1.setUpdatedDate(new Date());
					srep.save(s1);

			Shout s2 = new Shout();
			s2.setSubject("special offer 50% off"+i);
		
			s2.setOffer(o2);
			s2.setActive(false);
			s2.setCreatedBy("foursquare");
			s2.setUpdatedBy("visigenix");
			s2.setCreatedDate(new Date());
			s2.setUpdatedDate(new Date());
			srep.save(s2);
		System.out.println(id);
		i++;
			}
		}
		}
		}catch(Exception e){  
		System.out.println(e);
		}
	}
			*/
	
	@Test
	public void vvjj()
	{
		
	}
}
