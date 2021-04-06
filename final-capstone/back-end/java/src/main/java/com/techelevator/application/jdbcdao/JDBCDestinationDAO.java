package com.techelevator.application.jdbcdao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.model.Destination;

public class JDBCDestinationDAO implements DestinationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDestinationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Destination createDestination(String name, String description, String streetAddress, String city,
			String zipcode, double latitude, double longitude, String website) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> findDestinationsByZip(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination findDestinationByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination findDestinationById(long destinationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination updateDestination(Destination destinationToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDestination(long destinationId) {
		// TODO Auto-generated method stub
		
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
		destination.setWebiste(results.getString("website"));
		return destination;
	}
	
}
