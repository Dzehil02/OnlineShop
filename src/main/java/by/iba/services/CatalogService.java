package by.iba.services;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import by.iba.database.dao.Catalog;
import by.iba.entities.Product;

@Dependent
public class CatalogService {
	
	@Inject
	private Catalog catalogDao;

	public ArrayList<Product> getCatalog() {
		return catalogDao.getProductList();
	}

}
