package by.iba.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Seller extends User {
	
	Integer productId = 1;

	public Seller(String login, int password) {
		super(login, password, 22,"name");
		this.productId = new Integer(0);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void addProduct(Catalog catalog, Product newProduct) {
		catalog.addProduct(newProduct);
	}

	public void removeItem(Catalog catalog, Product product) {
		catalog.removeProduct(product);
	}
}
