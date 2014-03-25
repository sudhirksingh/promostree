package com.promostree.repositories.entities;


import org.springframework.data.jpa.repository.JpaRepository;


import com.promostree.domain.entities.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

	public Venue findById(Long id);
	//public Venues findByS_no(Integer Vid);
	
	/*
	@Query("select v from Venues v where v.vname = ?1")
	public List<Venues> findByVname(String vname);
	
	@Query("select v from Venues v where v.vname = ?1")
	public Page<Venues> findByVname(String vname,Pageable page);
	
	@Query("select v from Venues v where v.vname = ?1")
	public List<Venues> findByVname(String vname,Sort s);
	
	

	
	@Query("delete from Venues v where v.vname = ?1")
	public boolean deleteByVname(String vname);
	*/


	
}
