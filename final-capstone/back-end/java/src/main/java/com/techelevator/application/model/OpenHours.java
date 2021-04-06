package com.techelevator.application.model;

public class OpenHours {
	
	private long hoursId;
	private long destinationId;
	private long dayId;
	private String open;
	private String close;
	public long getHoursId() {
		return hoursId;
	}
	public void setHoursId(long hoursId) {
		this.hoursId = hoursId;
	}
	public long getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}
	public long getDayId() {
		return dayId;
	}
	public void setDayId(long dayId) {
		this.dayId = dayId;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	@Override
	public String toString() {
		return "OpenHours [hoursId=" + hoursId + ", destinationId=" + destinationId + ", dayId=" + dayId + ", open="
				+ open + ", close=" + close + "]";
	}
	
	
	

}
