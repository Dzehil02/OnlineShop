package by.iba.configuration;

import java.util.ArrayList;
import java.util.HashMap;

import by.iba.entities.Catalog;
import by.iba.entities.Customer;
import by.iba.entities.Product;
import by.iba.entities.Seller;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

public class Application {
	
public static void main(String[] args) {
		
		Catalog catalog = new Catalog();
		Seller seller1 = new Seller("Oleg", 1234);
		Customer customer = new Customer("Salah", 9876);
		
		Product item1 = new Product(Category.COMPUTERS, Brand.NOTEBOOK, "HP Pavilion", 14);
		Product item2 = new Product(Category.TECHNIQUE, Brand.PHONE, "IPhone X", 17);
		Product item3 = new Product(Category.ELECTRONICS, Brand.TV, "LG", 7);
		Product item4 = new Product(Category.TECHNIQUE, Brand.FRIDGE, "Samsung", 4);
		Product item5 = new Product(Category.INSTRUMENTS, Brand.DRILL, "Bosh", 5);
		Product item6 = new Product(Category.INSTRUMENTS, Brand.SCREWDRIVER, "Skil", 3);
		Product item7 = new Product(Category.INSTRUMENTS, Brand.SCREWDRIVER, "Skil", 13);
		
		ArrayList<Product> productList = catalog.getProductList();
		HashMap<Integer, Product> productsAll = catalog.getProductMap();
		
		seller1.addProduct(catalog, item1);
		seller1.addProduct(catalog, item2);
		seller1.addProduct(catalog, item3);
		seller1.addProduct(catalog, item4);
		seller1.addProduct(catalog, item5);
		seller1.addProduct(catalog, item6);
		seller1.addProduct(catalog, item7);
		seller1.addProduct(catalog, new Product(Category.TECHNIQUE, Brand.OVEN, "Gefest", 3));
		seller1.addProduct(catalog, new Product(Category.TECHNIQUE, Brand.OVEN, "Gefest", 6));
		
		System.out.println(item6.equals(item7));
		
		System.out.println("Каталог HashMap: " + catalog.getProductMap());
		System.out.println("Каталог: " + catalog.getProductList());

		seller1.removeItem(catalog, item4);
		customer.orderProduct(catalog.getProductList(), Category.ELECTRONICS, Brand.TV, "LG", 4);
		customer.orderProduct(catalog.getProductList(), Category.TECHNIQUE, Brand.OVEN, "Gefest", 2);

		System.out.println("Корзина: " + customer.basket.getBasketProducts());
		customer.removeProducts(catalog.getProductList());
		customer.removeProduct("TV");
		System.out.println("Корзина: " + customer.basket.getBasketProducts());
		System.out.println("Каталог: " + catalog.getProductList());
		
//		catalog.writeCatalog(catalog);
		catalog.readCatalog();

	}

}
