package solr;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface VenueRepository extends SolrCrudRepository<Venue, String> {

	// find by id
	@Query("id:*?0*")
	public Venue findById(String id);
	//find by nearest venues
	@Query("lat:?0* AND lng:?1*")
	public List<Venue> findByQueryAnnotation(String lat,String lng);
	// find by search term in vname or city
	@Query("name:*?0* OR city:*?0*")
	public List<Venue> findByQueryAnnotation(String searchTerm);

	// delete
	/*public void delete(String id);

	// delete document by id
	@Query("id:*?0*")
	public void deleteByQueryAnnotation(String id);



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
	List<Venue> findAllFilterAvailableTrue();

	
	 * @Query("qt:/dataimport") public void executeQuery();
	 

	// dih
	
	 * @Query(requestHandler = "/dataimport") Page<Venue> findByCity(String
	 * name);
	 
*/
}
