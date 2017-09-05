package com.bns.tcs.service.service;

import java.util.List;

import com.bns.fft.tcs.common.domain.Officer;
import com.bns.tcs.service.domain.RandomCity;
import com.bns.tcs.service.domain.User;

/**
 * @author pyang
 */
public interface TCSService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
    
	List<Officer> getListOfOfficersByID(String officerId, String transitNum);
	List<Officer> getListOfOfficersByName(String firstName, String lastName);
	Officer getOfficerProfile(String officerId);

}
