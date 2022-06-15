package by.iba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.criteria.Criterias;
import by.iba.database.dao.CatalogDao;
import by.iba.entities.Product;

@Service
public class CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	public ArrayList<Product> getCatalog() {
		return catalogDao.getProductList();
	}

	public ArrayList<Product> getCatalogByCriterias(Criterias criteria) {
		return catalogDao.getCategorizedCatalog(criteria);
	}

}
