package by.iba.entities;

import java.util.ArrayList;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

public class Customer extends User {
	
	public Basket basket;
	
	public Customer (String login, int password) {
		super(login, password, 22,"");
		basket = new Basket();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	

	
	public void orderProduct(ArrayList<Product> productList, Category category, Brand brand, String productName, int productCount) {
		
		for (Product product : productList) {
			if (productName.equals(product.getModel())) {
				if(product.getCount() >=  productCount) {
					product.setCount(product.getCount() - productCount);
					//basket.getBasket().add(new Item(nameItem, countItems));
					basket.addProduct(new Product(category, brand, productName, productCount));
					System.out.println("Товар " + productName + " : " + productCount + " шт." + " добавлен в корзину");
				} else {
					System.out.println("Недостаточно товара");
				}
			}
		}
	}
	
	public void payProducts() {
		basket.clearBasket();
	}
	
	public void removeProducts(ArrayList<Product> productList) {
		
		for (Product elB : basket.getBasketProducts()) {
				for (Product elC : productList) {
					if(elB.getModel().equals(elC.getModel())) {
						elC.setCount(elC.getCount()+elB.getCount());
					}
				}
		}
		basket.clearBasket();
	}
	
	public void removeProduct(String productName) {
		
		for (Product elB : basket.getBasketProducts()) {
			if(productName.equals(elB.getModel())) {
				basket.removeProduct(elB);
			}
		}
	}
}
