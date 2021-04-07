package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.application.dao.DestinationDAO;

import com.techelevator.application.model.Destination;

public class DestinationController {

	public DestinationController (DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}
	private DestinationDAO destinationDAO;

	
	@RequestMapping(path = "/destination/{name}", method = RequestMethod.GET)
	public List<Destination> findDestinationByName (@PathVariable String name) {
		List<Destination> destination = destinationDAO.findDestinationByName(name);
		logAPICall("Called with the path: /destination/" + name);
		return destination;
	}
	
	
	@RequestMapping(path = "/destination/{zipcode}", method = RequestMethod.GET)
	public List<Destination> findDestinationsByZip (@PathVariable String zipcode) {
		List<Destination> result = destinationDAO.findDestinationByName(zipcode);
		logAPICall("Called with the path: /destination/" + zipcode);
		return result;
	}
	
	@RequestMapping(path = "/destination/{destinationId}", method = RequestMethod.GET)
	public Destination findDestinationById (@PathVariable long destinationId) {
		Destination findByID = destinationDAO.findDestinationById(destinationId);
		logAPICall("Called with the path: /destination/" + destinationId);
		return findByID;
	}
	
	
	@RequestMapping(value = "/destination/{destinationId}", method = RequestMethod.DELETE)
    public void deleteDestination(@PathVariable long destinationId) {
		destinationDAO.deleteDestination(destinationId);
 
    }

	public void logAPICall(String message) {    // write a message with a time stamp to the server log 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
		String timeNow = now.format(formatter);
		System.out.println(timeNow + "-" + message);
	}

}
