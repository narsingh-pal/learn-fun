package com.nsp.j2ee.stock.application;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nsp.j2ee.stock.models.Stock;
import com.nsp.j2ee.stock.models.StockDetail;
import com.nsp.j2ee.stock.service.StockService;


@Component
public class StockApplication {

	final static Logger logger = Logger.getLogger(StockApplication.class);

	@Autowired
	private StockService stockService;
	public void performDbTasks()
	{
		// Get all stocks
		List<Stock> stocks = stockService.getAllStocks();
		logger.info(stocks.size());
		printStocks(stocks);
		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		//stockDetail.setStock(stock);

		
		// Save new stock
		stockService.addNewStock(stock);

		// Get all stocks - to check added stock
		stocks = stockService.getAllStocks();
		printStocks(stocks);

		
	}

	private void printStocks(List<Stock> stocks) {
		if (stocks != null) {
			logger.debug("Found total " + stocks.size() + " records.");
			for (Stock stock : stocks) {
				logger.debug(stock.toString());
			}
		}
	}

}
