package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OrderTest {
	
	static Order order;
	static Order order2;
	
	static String address = "ul. Klenovaya, 45";
	static Date date = new Date(1990-04-07);
	static String orderNumber = "1234567";
	static double totalCost = 687.90;
	static User user = new User();
	static List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		order = new Order();
		order.setAddress(address);
		order.setDate(date);
		order.setOrderedProducts(orderedProducts);
		order.setOrderNumber(orderNumber);
		order.setTotalCost(totalCost);
		order.setUser(user);
		
		order2 = new Order();
	}

	@Test
	void testAddProduct() {
		Order order3 = new Order();
		OrderedProduct orderedProduct = new OrderedProduct("Audi", 2, 5500);
		order3.addProduct(orderedProduct);
		assertArrayEquals(new OrderedProduct[]{orderedProduct}, order3.getOrderedProducts().toArray());
		assertEquals(order3, orderedProduct.getOrder());
	}

	@Test
	void testGetOrderNumber() {
		assertEquals("1234567", order.getOrderNumber());
	}

	@Test
	void testGetUser() {
		assertEquals(user, order.getUser());
	}

	@Test
	void testGetDate() {
		assertEquals(date, order.getDate());
	}

	@Test
	void testGetAddress() {
		assertEquals("ul. Klenovaya, 45", order.getAddress());
	}

	@Test
	void testGetTotalCost() {
		assertEquals(687.90, order.getTotalCost());
	}

	@Test
	void testGetOrderedProducts() {
		orderedProducts.add(new OrderedProduct("LG", 7, 90));
		assertArrayEquals(new OrderedProduct[]{new OrderedProduct("LG", 7, 90)}, order.getOrderedProducts().toArray());
	}

	@Test
	void testSetOrderNumber() {
		order2.setOrderNumber("4321");
		assertEquals("4321", order2.getOrderNumber());
	}

	@Test
	void testSetUser() {
		order2.setUser(user);
		assertEquals(user, order2.getUser());
	}

	@Test
	void testSetDate() {
		Date date2 = new Date(2020-06-18);
		order2.setDate(date2);
		assertEquals(date2, order2.getDate());
	}

	@Test
	void testSetAddress() {
		order2.setAddress("ul. Minskaya 2, 25");
		assertEquals("ul. Minskaya 2, 25", order2.getAddress());
	}

	@Test
	void testSetTotalCost() {
		order2.setTotalCost(296.78);
		assertEquals(296.78, order2.getTotalCost());
	}

	@Test
	void testSetOrderedProducts() {
		List<OrderedProduct> orderedProducts2 = new ArrayList<OrderedProduct>();
		orderedProducts2.add(new OrderedProduct("HP", 3, 65));
		orderedProducts2.add(new OrderedProduct("S8", 1, 1650));
		order2.setOrderedProducts(orderedProducts2);
		assertArrayEquals(new OrderedProduct[]{new OrderedProduct("HP", 3, 65), new OrderedProduct("S8", 1, 1650)}, order2.getOrderedProducts().toArray());
	}

}
