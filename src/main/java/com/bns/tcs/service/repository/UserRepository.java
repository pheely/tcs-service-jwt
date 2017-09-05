package com.bns.tcs.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bns.tcs.service.domain.User;

/**
 * @author pyang
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
