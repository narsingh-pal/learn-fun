package com.nsp.j2ee.stock.dao;

import org.springframework.stereotype.Repository;

import com.nsp.j2ee.generic.dao.AbstractHibernateDao;
import com.nsp.j2ee.stock.models.Stock;

@Repository
public class StockDAOImpl extends AbstractHibernateDao<Stock>  implements StockDAO{
	public void create(Stock s) {
		create(s);
	}

}
