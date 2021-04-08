package com.techelevator.application.dao;

import java.util.Date;
import java.util.List;

import com.techelevator.application.model.Itinerary;

public interface ItineraryDAO {
	
	// create 
	public Itinerary createItinerary (long userId, Date date, String startingPoint);
	
	// read
	
	public List<Itinerary> viewItineraryByUser (long userId);
	public List<Itinerary> viewItineraryByDate (Date date);

	// update 
	
	public Itinerary updateItinerary (long itineraryId, Date date, String startingPoint);
	
	
	// delete 
	public void deleteItinerary (long itineraryId);
	
	

}
