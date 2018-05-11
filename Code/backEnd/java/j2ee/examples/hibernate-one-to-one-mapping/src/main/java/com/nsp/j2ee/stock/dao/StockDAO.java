package com.nsp.j2ee.stock.dao;

import com.nsp.j2ee.generic.dao.GenericDao;
import com.nsp.j2ee.stock.models.Stock;

public interface StockDAO extends GenericDao<Stock>{
	public void create(Stock s);
}
