package by.iba.services;

import by.iba.database.dao.Catalog;
import by.iba.database.dao.LocalCatalog;
import by.iba.entities.Product;

public class ProductService {
	
private Catalog catalog;
	
	public ProductService() {
		catalog = new LocalCatalog();
	}
	
	public Product getProduct(int id) {
		return catalog.getProductById(id);
	}
	
	public void createProduct(Product product) {
		catalog.createProduct(product);
	}
	
	public void updateProduct(Product product) {
		catalog.updateProduct(product);
	}
	
	public void deleteProduct(Product product) {
		catalog.deleteProduct(product);
	}

}
