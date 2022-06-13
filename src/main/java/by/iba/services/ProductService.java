package by.iba.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import by.iba.database.dao.CatalogDao;
import by.iba.entities.CartItem;
import by.iba.entities.Product;

@Service
public class ProductService {

	@Autowired
	private CatalogDao catalogDao;

	public Product getProductById(int id) {
		return catalogDao.getProductById(id);
	}

	@Transactional
	public void createProduct(Product product) {
		Optional<Product> existingProduct = catalogDao.getExistingProduct(product);
		if(existingProduct.isPresent()) {
			existingProduct.get().setCount(product.getCount() + existingProduct.get().getCount());
		} else {
			catalogDao.createProduct(product);
		}
		
	}

	@Transactional
	public void updateProduct(Product product) {
		catalogDao.updateProduct(product);
	}

	@Transactional
	public void deleteProduct(Product product) {
		Product exProduct = catalogDao.getProductById(product.getId());
		List<CartItem> cartitems = exProduct.getCartItems();
		for (CartItem cartItem : cartitems) {
			cartItem.getCart().setTotalProductsAmount(cartItem.getCart().getTotalProductsAmount() - cartItem.getProductAmount()); 
		}
		catalogDao.deleteProduct(exProduct);
	}

}
