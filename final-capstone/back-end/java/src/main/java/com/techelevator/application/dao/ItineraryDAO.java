package com.techelevator.application.dao;

import java.util.Date;
import java.util.List;

import com.techelevator.application.model.Itinerary;

public interface ItineraryDAO {
	
	// create 
	
	public void addToItinerary (long destinationId, long itineraryId);
	
	public void createItinerary (long userId, Itinerary itinerary);
	
	// read
	
	public List<Itinerary> viewAllItineraries ();
	
	public Itinerary viewItineraryById(long itineraryId);
	
	public List<Itinerary> viewItineraryByUser (long userId);
	
	public List<Itinerary> viewItineraryByDate (String date);

	// update 
	
	public void updateItinerary (String startingPoint, String date, long itineraryId);
	
	
	// delete 
	
	public void deleteItinerary (long itineraryId);
	
	

}
