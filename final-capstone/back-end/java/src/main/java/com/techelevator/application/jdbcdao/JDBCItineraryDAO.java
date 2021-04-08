package com.techelevator.application.jdbcdao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.application.dao.ItineraryDAO;
import com.techelevator.application.model.Itinerary;

public class JDBCItineraryDAO implements ItineraryDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Itinerary createItinerary(long userId, Date date, String startingPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Itinerary> viewItineraryByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Itinerary> viewItineraryByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Itinerary updateItinerary(long itineraryId, Date date, String startingPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItinerary(long itineraryId) {
		String deleteDestination = "DELETE " +
								   "FROM itinierary " +
								   "WHERE itinerary_id = ? ";
		jdbcTemplate.update(deleteDestination, itineraryId);
	}

	
	
	
}
