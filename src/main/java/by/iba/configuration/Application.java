package by.iba.configuration;

import java.util.ArrayList;

import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.utils.FileUtils;

public class Application {

	public static void main(String[] args) {

		ArrayList<Product> catalog = new ArrayList<Product>();

		Product item1 = new Product(1, Category.COMPUTERS, Brand.NOTEBOOK, "HP Pavilion", 14);
		Product item2 = new Product(2, Category.TECHNIQUE, Brand.PHONE, "IPhone X", 17);
		Product item3 = new Product(3, Category.ELECTRONICS, Brand.TV, "LG", 7);
		Product item4 = new Product(4, Category.TECHNIQUE, Brand.FRIDGE, "Samsung", 4);
		Product item5 = new Product(5, Category.INSTRUMENTS, Brand.DRILL, "Bosh", 5);
		Product item6 = new Product(6, Category.INSTRUMENTS, Brand.SCREWDRIVER, "Skil", 3);
		Product item7 = new Product(7, Category.TECHNIQUE, Brand.OVEN, "Gefest", 3);

		catalog.add(item1);
		catalog.add(item2);
		catalog.add(item3);
		catalog.add(item4);
		catalog.add(item5);
		catalog.add(item6);
		catalog.add(item7);

		System.out.println("Каталог: " + catalog);

		FileUtils.writeCatalog(catalog, "src/main/resources/catalog.bin");
//		FileUtils.readCatalog("src/main/resources/catalog.bin");

	}

}
