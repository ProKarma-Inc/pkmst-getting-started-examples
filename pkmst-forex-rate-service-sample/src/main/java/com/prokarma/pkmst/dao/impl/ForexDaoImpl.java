package com.prokarma.pkmst.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.prokarma.pkmst.dao.IForexDao;
import com.prokarma.pkmst.model.Forex;

@Component
public class ForexDaoImpl implements IForexDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Forex getByTicker(String ticker) {
		List<Forex> list = this.jdbcTemplate.query("select * from forex where ticker = ?", new Object[] {StringUtils.upperCase(ticker)}, new RowMapper<Forex>() {
			@Override
			public Forex mapRow(ResultSet rs, int index) throws SQLException {
				Forex forex = new Forex();
				forex.setClosingPrice(rs.getBigDecimal("closing_price"));
				forex.setOpeningPrice(rs.getBigDecimal("opening_price"));
				forex.setLowPrice(rs.getBigDecimal("low_price"));
				forex.setHighPrice(rs.getBigDecimal("high_price"));
				forex.setTicker(rs.getString("ticker"));
				return forex;
			}});
		return list == null || list.size() == 0 ? null : list.get(0);
	}

}
