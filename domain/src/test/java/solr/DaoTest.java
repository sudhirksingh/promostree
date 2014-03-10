package solr;



import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.PartialUpdate;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DaoTest {

	
	@Autowired
	DaoImpl di;

	@Test
	public void nearestVenues() throws Exception {
		int dist = 5;
		double lat = 17.3660;
		double lng = 78.4760;
		List<Venue> v1 = di.nearestVenues(lat, lng, dist);
		int i = 0;
		for (Venue v : v1) {
			System.out.println(dist + "km nearest venue :   " + ++i + "    "
					+ v.getId());
		}
	}

	@Test
	public void save() {
		//String[] city={"hyd","chennai"};
		Venue v = new Venue();
		v.setId("ttt");
		v.setCity("city");
		v.setLat("17.8796");
		v.setLng("48.2541");
		v.setBusiness_group("reliance");
		v.setCat_name("cars");
		v.setCity("hyd");
        di.save(v);
		Assert.assertEquals(true, di.save(v));
	}

	
}
