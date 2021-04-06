package com.techelevator.application.jdbcdao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.application.dao.DayOfWeekDAO;
import com.techelevator.application.model.DayOfWeek;

public class JDBCDayOfWeekDAO implements DayOfWeekDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDayOfWeekDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public DayOfWeek getDayById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DayOfWeek getDayByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	private DayOfWeek mapRowToDayOfWeek(SqlRowSet results) {
		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.setDayId(results.getLong("day_id"));
		dayOfWeek.setName(results.getString("name"));
		return dayOfWeek;
	}
}
