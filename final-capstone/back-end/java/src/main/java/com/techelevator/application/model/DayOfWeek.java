package com.techelevator.application.model;

public class DayOfWeek {
	
	private long dayId;
	private String name;
	public long getDayId() {
		return dayId;
	}
	public void setDayId(long dayId) {
		this.dayId = dayId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DayOfWeek [dayId=" + dayId + ", name=" + name + "]";
	}
	
	

}
