package by.iba.entities;

import java.util.ArrayList;
import java.util.Optional;

public class Basket {
	
	private ArrayList<Product> basketProducts;
	
	public Basket() {
		this.basketProducts = new ArrayList<Product>();
	}

	public ArrayList<Product> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(ArrayList<Product> basketProducts) {
		this.basketProducts = basketProducts;
	}
	
	public void addProduct(Product product) {
		basketProducts.add(product);
	}
	
	public void removeProduct(int id) {
		basketProducts.remove(getProductById(id).get());
	}
	
	public void clearBasket() {
		basketProducts.clear();
	}
	
	public Optional<Product> getProductById(int id) {
		return basketProducts.stream().filter(product -> product.getId() == id).findFirst();
	}

}

