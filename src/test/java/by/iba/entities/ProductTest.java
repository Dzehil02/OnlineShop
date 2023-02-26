package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

class ProductTest {
	
	static Product product;
	static Product product2;
	static List<CartItem> cartItems = new ArrayList<CartItem>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		product = new Product(1, Category.COMPUTERS, Brand.MONITORS, "Samsung", 123, 750, cartItems);
		product2 = new Product();
	}

	@Test
	void testGetId() {
		assertEquals(1, product.getId());
	}

	@Test
	void testGetCategory() {
		assertEquals(Category.COMPUTERS, product.getCategory());
	}

	@Test
	void testGetBrand() {
		assertEquals(Brand.MONITORS, product.getBrand());
	}

	@Test
	void testGetModel() {
		assertEquals("Samsung", product.getModel());
	}

	@Test
	void testGetCount() {
		assertEquals(123, product.getCount());
	}

	@Test
	void testGetPrice() {
		assertEquals(750, product.getPrice());
	}

	@Test
	void testSetId() {
		product2.setId(2);
		assertEquals(2, product2.getId());
	}

	@Test
	void testSetCategory() {
		product2.setCategory(Category.TECHNIQUE);
		assertEquals(Category.TECHNIQUE, product2.getCategory());
	}

	@Test
	void testSetBrand() {
		product2.setBrand(Brand.AUDIO);
		assertEquals(Brand.AUDIO, product2.getBrand());
	}

	@Test
	void testSetModel() {
		product2.setModel("LG");
		assertEquals("LG", product2.getModel());
	}

	@Test
	void testSetCount() {
		product2.setCount(15);
		assertEquals(15, product2.getCount());
	}

	@Test
	void testSetPrice() {
		product2.setPrice(980);
		assertEquals(980, product2.getPrice());
	}

}
