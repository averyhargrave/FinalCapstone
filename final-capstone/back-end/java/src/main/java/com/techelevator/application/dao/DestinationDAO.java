package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Destination;

public interface DestinationDAO {

	// create
	public Destination createDestination(String name, String description, String streetAddress, String city, String zipcode, double latitude, double longitude, String website);
	
	// read
	public List<Destination> findDestinationsByZip(String zipcode);

	public Destination findDestinationByName(String name);
	
	public Destination findDestinationById(long destinationId);
	
	// update
	public Destination updateDestination(Destination destinationToUpdate);
	
	// delete
	public void deleteDestination(long destinationId);
}
