package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.OpenHours;

public interface OpenHoursDAO {
	
	// create 
	
	public OpenHours setOpenHours (long destinationId, long dayId, String open, String close);
	
	
	// read
	
	public List <OpenHours> readOpenHoursById (long destinationId);
	
	
	

}
