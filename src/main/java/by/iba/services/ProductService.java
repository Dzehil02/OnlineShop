package by.iba.services;

import java.util.Optional;

import by.iba.database.dao.Catalog;
import by.iba.database.dao.CatalogDao;
import by.iba.entities.Product;

public class ProductService {

	private Catalog catalogDao = new CatalogDao();

	public Product getProductById(int id) {
		return catalogDao.getProductById(id);
	}

	public void createProduct(Product product) {
		Optional<Product> existingProduct = catalogDao.getExistingProduct(product);
		if(existingProduct.isPresent()) {
			existingProduct.get().setCount(product.getCount() + existingProduct.get().getCount());
			catalogDao.updateProduct(existingProduct.get());
		} else {
			catalogDao.createProduct(product);
		}
		
	}

	public void updateProduct(Product product) {
		catalogDao.updateProduct(product);
	}

	public void deleteProduct(Product product) {
		catalogDao.deleteProduct(product);
	}

}
