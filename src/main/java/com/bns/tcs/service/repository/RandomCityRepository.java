package com.bns.tcs.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.tcs.service.domain.RandomCity;

/**
 * @author pyang
 */
public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {
}
