
package com.techelevator.application.model;

import java.util.Date;

public class Itinerary {
	
	private long itineraryId;
	private long userId;
	private String startingPoint;
	private String date;
	
	public long getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(long itineraryId) {
		this.itineraryId = itineraryId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getStartingPoint() {
		return startingPoint;
	}
	
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "itinerary [itineraryId=" + itineraryId + ", userId=" + userId + ", startingPoint=" + startingPoint
				+ ", date=" + date + "]";
	}
	
}