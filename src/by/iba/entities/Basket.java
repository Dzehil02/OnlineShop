package by.iba.entities;

import java.util.ArrayList;

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
	
	public void removeProduct(Product product) {
		basketProducts.remove(product);
	}
	
	public void clearBasket() {
		basketProducts.clear();
	}

}

