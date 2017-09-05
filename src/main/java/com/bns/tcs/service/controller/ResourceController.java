package com.bns.tcs.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.fft.tcs.common.domain.Officer;
import com.bns.tcs.service.domain.RandomCity;
import com.bns.tcs.service.domain.User;
import com.bns.tcs.service.service.TCSService;

import java.util.List;

/**
 * 
 * @author pyang
 *
 */
@RestController
@RequestMapping("/tcs")
public class ResourceController {
    @Autowired
    private TCSService tcsService;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<RandomCity> getUser(){
        return tcsService.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return tcsService.findAllUsers();
    }
    
	@RequestMapping(method=RequestMethod.GET, value= "/locate/officerId", params = {"officerId", "transitNum"})
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	List<Officer> getListOfOfficersByID(@RequestParam("officerId") String officerId, @RequestParam("transitNum") String transitNum ) {
		return tcsService.getListOfOfficersByID(officerId, transitNum);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/locate/name", params = {"firstName", "lastName"})
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	List<Officer> getListOfOfficersByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		return tcsService.getListOfOfficersByName(firstName, lastName);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/profile/{officerId}")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	Officer getOfficerProfile(@PathVariable String officerId) {
		return tcsService.getOfficerProfile(officerId);
	}
}
