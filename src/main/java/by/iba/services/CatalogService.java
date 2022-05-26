package by.iba.services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import by.iba.database.criteria.Criterias;
import by.iba.database.dao.CatalogDao;
import by.iba.database.dao.CatalogDaoHibernateImpl;
import by.iba.entities.Product;

@Service
public class CatalogService {
	
//	private CatalogDao catalogDao = new CatalogDaoHibernateImpl();
	
	@Autowired
	@Qualifier("catalogDaoHibernateImpl")
	private CatalogDao catalogDao;

	public ArrayList<Product> getCatalog() {
		return catalogDao.getProductList();
	}
	
	public ArrayList<Product> getCatalogByCriterias(Criterias criteria) {
		return catalogDao.getCategorizedCatalog(criteria);
	}

}
