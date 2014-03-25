package com.promostree.repositories.solr;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.promostree.domain.solr.SolrVenue;

public interface SolrVenueRepository extends SolrCrudRepository<SolrVenue, String> {

	
	// delete document by id
	@Query("id:*?0*")
	public void deleteByQueryAnnotation(String id);
	
	@Query("id:*?0*")
	public List<SolrVenue> findByQueryAnnotation(String id);
	
	@Query("lat:?0* AND lng:?1*")
	public List<SolrVenue> findByQueryAnnotation(String lat,String lng);
	
	@Query("(cat_name:?0* OR name:?0* OR offer_desc:?0*) AND (lat:?1* AND lng:?2*)")
	public List<SolrVenue> findByQueryAnnotation(String searchterm,String lat,String lng);
	
	

	// find by search term in vname or city
	/*@Query("vname:*?0* OR city:*?0*")
	public List<Venue> findByQueryAnnotation(String searchTerm);

	public List<Venue> findByVnameContainsOrCityContains(String vname,
			String city);

	// for query and sorted results
	@Query("vname:*?0* OR city:*?0*")
	public List<Venue> findByQueryAnnotation(String searchTerm, Sort sort);

	// pagination
	@Query("city:*?0*")
	Page<Venue> findByVnameOrCity(String city, Pageable pageable);

	// facet
	@Query("city:*?0*")
	@Facet(fields = { "vname" }, limit = 70)
	FacetPage<Venue> findByFacetOnVname(String city, Pageable page);

	// filterQuery
	@Query(value = "*:*", filters = { "inStock:true", "popularity:[* TO 3]" })
	List<Venue> findAllFilterAvailableTrue();*/

	/*
	 * @Query("qt:/dataimport") public void executeQuery();
	 */

	// dih
	/*
	 * @Query(requestHandler = "/dataimport") Page<Venue> findByCity(String
	 * name);
	 */

}
