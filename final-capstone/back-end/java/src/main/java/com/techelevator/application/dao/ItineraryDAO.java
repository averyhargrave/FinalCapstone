package com.techelevator.application.dao;

import java.util.Date;
import java.util.List;

import com.techelevator.application.model.Itinerary;

public interface ItineraryDAO {
	
	// create 
	
	public void createItinerary (long userId, String startingPoint, Date date);
	
	// read
	
	public List<Itinerary> viewItineraryByUser (long userId);
	public List<Itinerary> viewItineraryByDate (Date date);

	// update 
	
	public void updateItinerary (String startingPoint, Date date, long itineraryId);
	
	
	// delete 
	
	public void deleteItinerary (long itineraryId);
	
	

}
