package com.techelevator.application.model;

public class Destination {
	
	private long     destinationId;
	private String   name;
	private String   description;
	private String   streetAddress;
	private String   city;
	private String   state;
	private String   zipcode;
	private double   latitude;
	private double   longitude;
	private String   website;
	
	public long getDestinationId() {
		return destinationId;
	}
	
	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebiste(String website) {
		this.website = website;
	}
	
	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", name=" + name + ", description=" + description
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", zipcode=" + zipcode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", website=" + website + "]";
	}
	
	

}
