package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.model.Destination;

@RestController
public class DestinationController {

	public DestinationController (DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}
	private DestinationDAO destinationDAO;
	
	@RequestMapping(path = "/destinations", method = RequestMethod.GET)
	public List<Destination> findDestinations(@RequestParam(defaultValue = "") String zipcode, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "0") String id) {
		List<Destination> results = new ArrayList<>();
		
		if(zipcode != "") {
			results = destinationDAO.findDestinationsByZip(zipcode);
		}
		if(name != "") {
			results.add(destinationDAO.findDestinationByName(name));
		}
		if(Long.parseLong(id) != 0) {
			results.add(destinationDAO.findDestinationById(Long.parseLong(id)));
		}
		logAPICall("Called with the path: /destinations");
		return results;
	}
	
	
	
	public void logAPICall(String message) {    // write a message with a time stamp to the server log 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
		String timeNow = now.format(formatter);
		System.out.println(timeNow + "-" + message);
	}

}
