package com.bns.tcs.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.tcs.service.domain.Role;

/**
 * @author pyang
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
