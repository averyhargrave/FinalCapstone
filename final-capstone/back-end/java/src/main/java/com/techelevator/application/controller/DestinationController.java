package com.techelevator.application.controller;

import java.sql.Timestamp;

public class DestinationController {




static void logRequest(String message) {
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 
	System.out.println(timestamp + " - " + message);
}

}
