package com.prokarma.pkmst.dao;

import com.prokarma.pkmst.model.Stock;

public interface IStockDao {
	abstract Stock findByTicker(String ticker);
}
