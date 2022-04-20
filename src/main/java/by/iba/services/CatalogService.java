package by.iba.services;

import java.util.ArrayList;

import by.iba.database.dao.Catalog;
import by.iba.database.dao.LocalCatalog;
import by.iba.entities.Product;

public class CatalogService {
	
	private Catalog catalog;
	
	public CatalogService() {
		catalog = new LocalCatalog();
	}

	public ArrayList<Product> getCatalog() {
		return catalog.getProductList();
	}

}
