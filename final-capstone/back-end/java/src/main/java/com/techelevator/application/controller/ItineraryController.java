package com.techelevator.application.controller;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.ItineraryDAO;

import com.techelevator.application.model.Itinerary;
import com.techelevator.security.dao.UserDAO;

@RestController
@CrossOrigin
public class ItineraryController {

public ItineraryController (ItineraryDAO itineraryDAO, UserDAO userDAO) {
	this.itineraryDAO = itineraryDAO;
	this.userDAO =userDAO;
	
}

private UserDAO userDAO;
private ItineraryDAO itineraryDAO;

@RequestMapping(path = "/create/itinerary/", method = RequestMethod.POST)
public void createItinerary(Principal userInfo, @RequestBody Itinerary itinerary) {
	long userId = userDAO.findIdByUsername(userInfo.getName());
	itineraryDAO.createItinerary(userId, itinerary);

}

@RequestMapping(path = "/itinerary/", method = RequestMethod.GET)
public List<Itinerary> viewAllItineraries (@PathVariable long itineraryId, long userId, String startingPoint, String date) {
	List<Itinerary> itineraryUser = itineraryDAO.viewAllItineraries(itineraryId, userId, startingPoint, date);
	logAPICall("Called with the path: /itinerary/");
	return itineraryUser;
}


@RequestMapping(path = "/itinerary/{userId}", method = RequestMethod.GET)
public List<Itinerary> viewItineraryByUser (@PathVariable Long userId) {
	List<Itinerary> itineraryUser = itineraryDAO.viewItineraryByUser(userId);
	logAPICall("Called with the path: /itinerary/" + userId);
	return itineraryUser;
}


@RequestMapping(path = "/itinerary/date/{date}", method = RequestMethod.GET)
public List<Itinerary> viewItineraryByDate (@PathVariable String date) {
	
	List<Itinerary> itineraryUser = itineraryDAO.viewItineraryByDate(date);
	logAPICall("Called with the path: /itinerary/" + date);
	return itineraryUser;
}

@RequestMapping(value = "/delete/itinerary/{itineraryId}", method = RequestMethod.DELETE)
public void deleteItinerary(@PathVariable long itineraryId) {
	itineraryDAO.deleteItinerary(itineraryId);

}


public void logAPICall(String message) {    // write a message with a time stamp to the server log 
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
	String timeNow = now.format(formatter);
	System.out.println(timeNow + "-" + message);
}

}