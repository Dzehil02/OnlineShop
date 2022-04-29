package by.iba.services;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;

import by.iba.database.dao.Catalog;
import by.iba.database.dao.CatalogDao;
import by.iba.entities.Product;

@Dependent
public class CatalogService {
	
	private Catalog catalogDao = new CatalogDao();

	public ArrayList<Product> getCatalog() {
		return catalogDao.getProductList();
	}

}
