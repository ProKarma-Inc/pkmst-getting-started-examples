package com.prokarma.pkmst.dao;

import com.prokarma.pkmst.model.Forex;

public interface IForexDao {

	abstract Forex getByTicker(String ticker);
}
