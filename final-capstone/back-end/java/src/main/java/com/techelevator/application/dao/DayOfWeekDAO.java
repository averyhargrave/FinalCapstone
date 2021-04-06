package com.techelevator.application.dao;

import com.techelevator.application.model.DayOfWeek;

public interface DayOfWeekDAO {
	
	public DayOfWeek getDayById (long id);
	
	public DayOfWeek getDayByName (String name);

}
