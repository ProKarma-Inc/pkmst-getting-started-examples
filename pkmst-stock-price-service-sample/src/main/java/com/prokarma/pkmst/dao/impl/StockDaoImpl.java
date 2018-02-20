package com.prokarma.pkmst.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.prokarma.pkmst.dao.IStockDao;
import com.prokarma.pkmst.model.Stock;

@Component
public class StockDaoImpl implements IStockDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Stock findByTicker(String ticker) {
		List<Stock> list = this.jdbcTemplate.query("select * from stock where ticker = ?", new Object[] {StringUtils.upperCase(ticker)}, new RowMapper<Stock>() {
			@Override
			public Stock mapRow(ResultSet rs, int index) throws SQLException {
				Stock stock = new Stock();
				stock.setClosingPrice(rs.getBigDecimal("closing_price"));
				stock.setOpeningPrice(rs.getBigDecimal("opening_price"));
				stock.setLowPrice(rs.getBigDecimal("low_price"));
				stock.setHighPrice(rs.getBigDecimal("high_price"));
				stock.setTicker(rs.getString("ticker"));
				stock.setName(rs.getString("name"));
				stock.setDescription(rs.getString("description"));
				stock.setExchange(rs.getString("exchange"));
				return stock;
			}});
		return list == null || list.size() == 0 ? null : list.get(0);
	}

}
