package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;




import com.promostree.domain.entities.Location;
import com.promostree.domain.entities.Shout;

public interface ShoutRepository  extends JpaRepository<Shout, Long>{
	public Shout findById(Long id);
}
