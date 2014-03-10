package solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.PartialUpdate;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Query;
import org.springframework.stereotype.Service;

public class DaoImpl {
	@Autowired
	VenueRepository repository;
	@Autowired
	SolrTemplate context;

	

	public boolean save(Venue v1) {

		// System.out.println(" \n save id:  "+v.getId());
		if (repository.save(v1) == null) {
			return false;
		} else {
			return true;
		}
	}

	public double distance(double lat1, double lon1, double lat2, double lon2,
			char unit) {

		double R = 6371; // km
		double dLat = deg2rad((lat2 - lat1));
		double dLon = deg2rad((lon2 - lon1));
		double l1 = deg2rad(lat1);
		double l2 = deg2rad(lat2);

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2)
				* Math.sin(dLon / 2) * Math.cos(l1) * Math.cos(l2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	public List<Venue> nearestVenues(double lat, double lon, int dist)
			throws Exception {
		
       String lat1=new Double(lat).toString().substring(0, 3);
       String lng1=new Double(lon).toString().substring(0, 3);
       
		List<Venue> v2 = new ArrayList<Venue>();
		for (Venue v : repository.findByQueryAnnotation(lat1,lng1)) {
			String lat2 = v.getLat();
			String lon2 = v.getLng();
			// System.out.println(v.getId()+"   "+lat2);
			if (this.distance(lat, lon, Double.parseDouble(lat2),
					Double.parseDouble(lon2), 'k') <= dist) {
				v2.add(v);
			}
		}
		return v2;
	}
	
}
