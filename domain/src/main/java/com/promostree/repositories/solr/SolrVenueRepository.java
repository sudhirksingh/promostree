package com.promostree.repositories.solr;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.geo.Distance;
import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.promostree.domain.solr.SolrVenue;

public interface SolrVenueRepository extends
		SolrCrudRepository<SolrVenue, String> {
    @Query("entity_id:?0")
    public List<SolrVenue> findByEntity_id(String entityId);
    
	@Query("search_field:*?0*")
	public List<SolrVenue> findByQueryAnnotation(String searchTerm);

	@Query("lat:?0* AND lng:?1*")
	public List<SolrVenue> findByQueryAnnotation(String lat, String lng,
			Pageable page);

	// for find out nearest venues
	@Query("lat:?0* AND lng:?1*")
	public List<SolrVenue> findByQueryAnnotation(String lat, String lng);

    @Query("search_field:*?0*")
    public List<SolrVenue> findBySearch_fieldIn(List<String> searchField,Pageable page);
	
	@Query("fq={!geofilt pt=?0,?1 sfield=geolocation d=?2} AND (search_field:*?3* )")
	public List<SolrVenue> findByQueryAnnotation(double lat, double lng, double d,String searchterm,Pageable page);
	@Query("fq={!geofilt pt=?0,?1 sfield=geolocation d=?2} ")
	public List<SolrVenue> findByQueryAnnotation(double lat, double lng, double d,Pageable page);

	// find by search term in vname or city
	/*
	 * @Query("vname:*?0* OR city:*?0*") public List<Venue>
	 * findByQueryAnnotation(String searchTerm);
	 * 
	 * public List<Venue> findByVnameContainsOrCityContains(String vname, String
	 * city);
	 * 
	 * // for query and sorted results
	 * 
	 * @Query("vname:*?0* OR city:*?0*") public List<Venue>
	 * findByQueryAnnotation(String searchTerm, Sort sort);
	 * 
	 * // pagination
	 * 
	 * @Query("city:*?0*") Page<Venue> findByVnameOrCity(String city, Pageable
	 * pageable);
	 * 
	 * // facet
	 * 
	 * @Query("city:*?0*")
	 * 
	 * @Facet(fields = { "vname" }, limit = 70) FacetPage<Venue>
	 * findByFacetOnVname(String city, Pageable page);
	 * 
	 * // filterQuery
	 * 
	 * @Query(value = "*:*", filters = { "inStock:true", "popularity:[* TO 3]"
	 * }) List<Venue> findAllFilterAvailableTrue();
	 */

	/*
	 * @Query("qt:/dataimport") public void executeQuery();
	 */

	// dih
	/*
	 * @Query(requestHandler = "/dataimport") Page<Venue> findByCity(String
	 * name);
	 */

}
