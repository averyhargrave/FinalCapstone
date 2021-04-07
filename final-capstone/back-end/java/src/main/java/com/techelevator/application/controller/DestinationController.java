package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.DestinationDAO;

import com.techelevator.application.model.Destination;

@RestController
@CrossOrigin
public class DestinationController {

	public DestinationController (DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}
	private DestinationDAO destinationDAO;

	
	@RequestMapping(path = "/destinations", method = RequestMethod.GET)
	public List<Destination> findDestinations (@RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String zipcode, @RequestParam(defaultValue="") String type, @RequestParam(defaultValue="0") String id) {
		List<Destination> result = new ArrayList<>();
		if(zipcode.equals("") && name.equals("") && type.equals("") && (Long.parseLong(id) != 0)) {
			result = destinationDAO.getAllDestinations();
		}
		if(!zipcode.equals("")) {
			result = destinationDAO.findDestinationsByZip(zipcode);
		}
		if(!name.equals("")) {
			result = destinationDAO.findDestinationByName(name);
		}
		if(!type.equals("")) {
			result = destinationDAO.findDestinationsByType(type);
		}
		if(Long.parseLong(id) != 0) {
			result = destinationDAO.findDestinationById(Long.parseLong(id));
		}
		
		logAPICall("Called with the path: /destinations");
		return result;
	}
	
	@RequestMapping(value = "/delete/{destinationId}", method = RequestMethod.DELETE)
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
