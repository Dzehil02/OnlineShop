package by.iba.database.dao;

import java.util.List;
import java.util.Optional;


import by.iba.database.criteria.Criterias;
import by.iba.entities.Product;

public interface CatalogDao {

	 Product getProductById(int id);

	 List<Product> getProductList();

	 void createProduct(Product product);

	 void updateProduct(Product product);

	 void deleteProduct(Product product);
	
	 Optional<Product> getExistingProduct(Product product);
	
	 List<Product> getCategorizedCatalog(Criterias criteria);

}
