package com.nsp.j2ee.stock.service;

import java.util.List;

import com.nsp.j2ee.stock.models.Stock;



public interface StockService {

	void addNewStock(Stock stock);
	void removeStock(Stock stock);
	List<Stock> getAllStocks() ;
	boolean isStockExist(Stock stock);
	Stock findStock(long id);
}
