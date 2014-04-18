package com.promostree.repositories.tenant;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.tenant.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
