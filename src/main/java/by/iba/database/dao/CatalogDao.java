package by.iba.database.dao;

import java.util.ArrayList;

import java.util.Optional;

import org.hibernate.Criteria;

import by.iba.database.criteria.Criterias;
import by.iba.entities.Product;

public interface CatalogDao {

	public Product getProductById(int id);

	public ArrayList<Product> getProductList();

	public void createProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
	
	public Optional<Product> getExistingProduct(Product product);
	
	public ArrayList<Product> getCategorizedCatalog(Criterias criteria);

}
