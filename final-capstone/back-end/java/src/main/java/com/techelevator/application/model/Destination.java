package com.techelevator.application.model;

public class Destination {
	
	private long     destinationId;
	private String   name;
	private String   description;
	private String   streetAddress;
	private String   city;
	private String   zipcode;
	private double   latitude;
	private double   longtitude;
	private String   webiste;
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
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public String getWebiste() {
		return webiste;
	}
	public void setWebiste(String webiste) {
		this.webiste = webiste;
	}
	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", name=" + name + ", description=" + description
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", zipcode=" + zipcode + ", latitude="
				+ latitude + ", longtitude=" + longtitude + ", webiste=" + webiste + "]";
	}
	
	

}
