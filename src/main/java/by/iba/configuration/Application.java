package by.iba.configuration;

import by.iba.entities.Catalog;
import by.iba.entities.Customer;
import by.iba.entities.Product;
import by.iba.entities.Seller;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.exceptions.NotEnoughProductsException;
import by.iba.utils.FileUtils;

public class Application {

	public static void main(String[] args) {

		Catalog catalog = new Catalog();
		Seller seller1 = new Seller("Oleg", 1234);
		Customer customer = new Customer("Salah", 9876, "Mo", 25);

		Product item1 = new Product(1, Category.COMPUTERS, Brand.NOTEBOOK, "HP Pavilion", 14);
		Product item2 = new Product(2, Category.TECHNIQUE, Brand.PHONE, "IPhone X", 17);
		Product item3 = new Product(3, Category.ELECTRONICS, Brand.TV, "LG", 7);
		Product item4 = new Product(4, Category.TECHNIQUE, Brand.FRIDGE, "Samsung", 4);
		Product item5 = new Product(5, Category.INSTRUMENTS, Brand.DRILL, "Bosh", 5);
		Product item6 = new Product(6, Category.INSTRUMENTS, Brand.SCREWDRIVER, "Skil", 3);
		Product item7 = new Product(7, Category.INSTRUMENTS, Brand.SCREWDRIVER, "Skil", 13);

		seller1.addProduct(catalog, item1);
		seller1.addProduct(catalog, item2);
		seller1.addProduct(catalog, item3);
		seller1.addProduct(catalog, item4);
		seller1.addProduct(catalog, item5);
		seller1.addProduct(catalog, item6);
		seller1.addProduct(catalog, item7);
		seller1.addProduct(catalog, new Product(8, Category.TECHNIQUE, Brand.OVEN, "Gefest", 3));
		seller1.addProduct(catalog, new Product(8, Category.TECHNIQUE, Brand.OVEN, "Gefest", 6));

		System.out.println("Каталог: " + catalog.getProductList());

//		seller1.removeProduct(catalog, 4);

		customer.addProductToBasket(catalog, 3, 5);
		customer.addProductToBasket(catalog, 8, 2);
		customer.addProductToBasket(catalog, 2, 12);

		System.out.println("Корзина: " + customer.basket.getBasketProducts());
		
		customer.removeProductFromBasket(2);
		customer.removeProductFromBasket(8);
		
		try {
			customer.orderProducts(catalog);
		} catch (NotEnoughProductsException e) {
			e.writeMessage();
		}
		

		System.out.println("Корзина: " + customer.basket.getBasketProducts());
		System.out.println("Каталог: " + catalog.getProductList());

//		FileUtils.writeCatalog(catalog, "src/main/resources/catalog.bin");
//		FileUtils.readCatalog("src/main/resources/catalog.bin");
		
	}

}
