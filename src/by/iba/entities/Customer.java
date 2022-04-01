package by.iba.entities;

import java.util.ArrayList;

import by.iba.exceptions.NotEnoughProductsException;

public class Customer extends User {
	
	public int age;

	public String name;
	
	public Basket basket;
	
	public Customer (String login, int password, String name, int age) {
		super(login, password);
		this.name = name;
		this.age = age;
		basket = new Basket();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void addProductToBasket(Catalog catalog, int productId, int productCount) {
		ArrayList<Product> productList = catalog.getProductList();
		
		for (Product product : productList) {
			if(product.getId() == productId) {
				basket.addProduct(new Product(productId, product.getCategory(), product.getBrand(), product.getModel(), productCount));
				System.out.println("Товар " + product.getModel() + " : " + productCount + " шт." + " добавлен в корзину");
			}
		}
		
	}
	
	public void orderProducts(Catalog catalog) throws NotEnoughProductsException {
		
		StringBuilder error = new StringBuilder();
		
		ArrayList<Product> productsToChange = new ArrayList<Product>(); 

		for(Product basketProduct : basket.getBasketProducts()) {
			for(Product catalogProduct : catalog.getProductList()) {
				if(basketProduct.getId() == catalogProduct.getId()) {
					if(catalogProduct.getCount() < basketProduct.getCount()) {
						if(error.length() == 0) {
							error.append("Недостаточно товара: " + catalogProduct.getModel());
						} else {
							error.append(", " + catalogProduct.getModel());
						}
					} else {
						productsToChange.add(catalogProduct);
					}
				}
			}
		}
		
		if(error.length() != 0) {
			throw new NotEnoughProductsException(error.toString());
		}
		
		for(Product basketProduct : basket.getBasketProducts()) {
			for(Product catalogProduct : productsToChange) {
				if(basketProduct.getId() == catalogProduct.getId()) {
				catalogProduct.setCount(catalogProduct.getCount() - basketProduct.getCount());
				}
			}
		}
		basket.clearBasket();
	}
	
	public void removeProductFromBasket(int productId) {
		for (Product product : basket.getBasketProducts()) {
			if(product.getId() == productId) {
				basket.removeProduct(product);
			}
		}
	}

}
