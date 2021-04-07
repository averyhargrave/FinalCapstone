package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.model.Destination;

@Component
public class JDBCDestinationDAO implements DestinationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDestinationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Destination> findDestinationsByZip(String zipcode) {
		List<Destination> list = new ArrayList<>();
		String sqlGetDestinationByZipcode = "SELECT * " +
				 					        "FROM destinations " +  
									        "WHERE zipcode = ? ";
									
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationByZipcode, zipcode);
		while(results.next()) {
			Destination destination = mapRowToDestination(results);
			list.add(destination);
		}
		return list;
	}

	@Override
	public Destination findDestinationByName(String name) {
		Destination destination = new Destination();
		String sqlGetDestinationByName = "SELECT * " +
									     "FROM destinations " + 
								         "WHERE name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationByName, name);
		if (results.next()) {
			destination = mapRowToDestination(results);
		}
		return destination;
	}

	@Override
	public Destination findDestinationById(long destinationId) {
		Destination destination = new Destination();
		String sqlGetDestinationById = "SELECT * " +
									   "FROM destinations " + 
								       "WHERE destination_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationById, destinationId);
		if (results.next()) {
			destination = mapRowToDestination(results);
		}
		return destination;
	}

	@Override
	public void deleteDestination(long destinationId) {
		String deleteDestination = "DELETE " +
								   "FROM destinations " +
								   "WHERE destination_id = ? ";
		jdbcTemplate.update(deleteDestination, destinationId);
	}

	private Destination mapRowToDestination(SqlRowSet results) {
		Destination destination = new Destination();
		destination.setDestinationId(results.getLong("destination_id"));
		destination.setName(results.getString("name"));
		destination.setDescription(results.getString("description"));
		destination.setStreetAddress(results.getString("street_address"));
		destination.setCity(results.getString("city"));
		destination.setState(results.getString("state"));
		destination.setZipcode(results.getString("zipcode"));
		destination.setLatitude(results.getDouble("latitude"));
		destination.setLongitude(results.getDouble("longitude"));
		destination.setWebsite(results.getString("website"));
		return destination;
	}
}
