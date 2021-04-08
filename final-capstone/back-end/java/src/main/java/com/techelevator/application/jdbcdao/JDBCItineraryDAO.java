package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.ItineraryDAO;
import com.techelevator.application.model.Itinerary;

@Component
public class JDBCItineraryDAO implements ItineraryDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createItinerary(long userId, Itinerary itinerary) {
		String sqlCreateItinerary = "INSERT INTO itinerary(user_id, date, starting_point) " +
									"VALUES(?, ?, ?) ";
		jdbcTemplate.update(sqlCreateItinerary, userId, itinerary.getDate(),itinerary.getStartingPoint());
	}

	@Override
	public List<Itinerary> viewItineraryByUser(long userId) {
		List<Itinerary> list = new ArrayList<>();
		String sqlFindItineraryByUser = "SELECT * " +
									  "FROM itinerary " + 
								      "WHERE user_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindItineraryByUser, userId);
		while (results.next()) {
			list.add(mapRowToItinerary(results));
		}
		return list;
	}

	@Override
	public List<Itinerary> viewItineraryByDate(String date) {
		List<Itinerary> list = new ArrayList<>();
		String sqlFindItineraryByDate = "SELECT * " +
									    "FROM itinerary " + 
								        "WHERE date = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindItineraryByDate, date);
		while (results.next()) {
			list.add(mapRowToItinerary(results));
		}
		return list;
	}

	@Override
	public void updateItinerary(String startingPoint, String date, long itineraryId) {
		String sqlUpdateItinerary = "UPDATE itinerary " +
									"SET starting_point = ?, " +
									"    date = ? " +
									"WHERE itinerary_id = ? ";
		
		jdbcTemplate.update(sqlUpdateItinerary,startingPoint, date, itineraryId);
	}

	@Override
	public List<Itinerary> viewAllItineraries() {
		List<Itinerary> list = new ArrayList<>();
		String sqlAllItineraries = "SELECT * " +
								   "FROM itinerary ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllItineraries);
		while(results.next()) {
			list.add(mapRowToItinerary(results));
		}
		return list;
	}
	
	@Override
	public void deleteItinerary(long itineraryId) {
		String deleteDestination = "DELETE " +
								   "FROM itinerary " +
								   "WHERE itinerary_id = ? ";
		jdbcTemplate.update(deleteDestination, itineraryId);
	}

	private Itinerary mapRowToItinerary(SqlRowSet results) {
		Itinerary itinerary = new Itinerary();
		itinerary.setItineraryId(results.getLong("itinerary_id"));
		itinerary.setUserId(results.getLong("user_id"));
		itinerary.setStartingPoint(results.getString("starting_point"));
		return itinerary;
	}

	@Override
	public void addToItinerary(long destinationId, long itineraryId) {
		String sqlAddToItinerary = "INSERT INTO itinerary(destination_id, itinerary_id) " +
								   "VALUES(?, ?) ";
		jdbcTemplate.update(sqlAddToItinerary, destinationId, itineraryId);
		
	}




	
	
}
