package com.techelevator.application.jdbcdao;

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
	public OpenHours setOpenHours(long destinationId, long dayId, String open, String close) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenHours> readOpenHoursById(long destinationId) {
		// TODO Auto-generated method stub
		return null;
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
