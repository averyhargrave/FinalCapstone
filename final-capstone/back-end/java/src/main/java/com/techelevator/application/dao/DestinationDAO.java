package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Destination;

public interface DestinationDAO {
	
	// read
	public List<Destination> findDestinationsByZip(String zipcode);

	public Destination findDestinationByName(String name);
	
	public Destination findDestinationById(long destinationId);

	// delete
	public void deleteDestination(long destinationId);
}
