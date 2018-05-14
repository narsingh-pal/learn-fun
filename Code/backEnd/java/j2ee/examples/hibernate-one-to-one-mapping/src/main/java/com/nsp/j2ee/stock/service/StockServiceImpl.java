package com.nsp.j2ee.stock.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsp.j2ee.stock.dao.StockDAO;
import com.nsp.j2ee.stock.models.Stock;

@Service
@Transactional(readOnly = true)
public class StockServiceImpl implements StockService {

	final static Logger logger = Logger.getLogger(StockServiceImpl.class);

	@Autowired
	StockDAO stockDao;

	@Transactional(readOnly = false)
	public void addNewStock(Stock stock) {
		List<Stock> stockList = stockDao.findAllByExample(stock);
		if (stockList == null || stockList.isEmpty()) {
			 Long id = (Long) stockDao.save(stock);
			logger.debug("Id of new Stock " + id);
		} else {
			logger.debug("Stock " + stock + " already exists");
		}
	}

	public void removeStock(Stock stock) {
		stockDao.delete(stock);
	}

	public List<Stock> getAllStocks() {
		return stockDao.findAll();
	}
	
	
	public boolean isStockExist(Stock stock) {
		List<Stock> stockList = stockDao.findAllByExample(stock);
		return  (stockList == null || stockList.isEmpty()) ? false:true; 
	}
	
	public Stock findStock(long id) {
		return stockDao.findOne(id);
	}
}
