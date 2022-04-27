package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import by.iba.entities.Product;

public interface Catalog {

	public Product getProductById(int id);

	public ArrayList<Product> getProductList();

	public void createProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
	
	public Optional<Product> getExistingProduct(Product product);

}
