package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.application.dao.OpenHoursDAO;
import com.techelevator.application.model.OpenHours;

public class JDBCOpenHoursDAO implements OpenHoursDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCOpenHoursDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<OpenHours> readOpenHoursById(long destinationId) {
		List<OpenHours> list = new ArrayList<>();
		String sqlReadOpenHoursById = "SELECT * " +
				 					  "FROM open_hours " +  
									  "WHERE destination_id = ? ";
									
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReadOpenHoursById, destinationId);
		while(results.next()) {
			OpenHours openHours = mapRowToOpenHours(results);
			list.add(openHours);
		}
		return list;
	}


	private OpenHours mapRowToOpenHours(SqlRowSet results) {
		OpenHours openHours = new OpenHours();
		openHours.setHoursId(results.getLong("hours_id"));
		openHours.setDayId(results.getLong("day_id"));
		openHours.setDestinationId(results.getLong("destination_id"));
		openHours.setOpen(results.getString("open"));
		openHours.setClose(results.getString("close"));
		return openHours;
	}
}
