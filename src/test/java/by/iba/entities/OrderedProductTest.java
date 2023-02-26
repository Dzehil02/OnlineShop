package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OrderedProductTest {
	
	static OrderedProduct orderedProduct;
	static OrderedProduct orderedProduct2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		orderedProduct = new OrderedProduct("Xiaomi", 12, 455);
		orderedProduct2 = new OrderedProduct();
	}

	@Test
	void testGetModel() {
		assertEquals("Xiaomi", orderedProduct.getModel());
	}

	@Test
	void testGetAmount() {
		assertEquals(12, orderedProduct.getAmount());
	}

	@Test
	void testGetPrice() {
		assertEquals(455, orderedProduct.getPrice());
	}

	@Test
	void testSetModel() {
		orderedProduct2.setModel("HP");
		assertEquals("HP", orderedProduct2.getModel());
	}

	@Test
	void testSetAmount() {
		orderedProduct2.setAmount(47);
		assertEquals(47, orderedProduct2.getAmount());
	}

	@Test
	void testSetPrice() {
		orderedProduct2.setPrice(125);
		assertEquals(125, orderedProduct2.getPrice());
	}

}
