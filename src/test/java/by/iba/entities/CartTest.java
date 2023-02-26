package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

class CartTest {
	
	static CartItem cartItem = new CartItem();
	static List<CartItem> cartItems = new ArrayList<CartItem>();
	static Cart cart;
	static User user = new User();

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Product product = new Product(1, Category.COMPUTERS, Brand.MONITORS, "Samsung", 123, 750, cartItems);
		cartItem.setProduct(product);
		cartItem.setProductAmount(23);
		cart = new Cart(1, 0, cartItems);
	}

	@Test
	void testAddItem() {
		cart.addItem(cartItem);
		assertEquals(cart, cartItem.getCart());
		assertEquals(cartItem, cart.getCartItems().toArray()[0]);		
	}
	
	@Test
	void testSearchCartItem() {
		cart.addItem(cartItem);
		CartItem cartItem2 = cart.searchCartItem(cartItem);
		assertEquals(cartItem, cartItem2);
	}

	@Test
	void testRemoveItem() {
		cart.removeItem(cartItem);
		assertEquals(0, cart.getCartItems().toArray().length);
		assertEquals(null, cartItem.getCart());
	}

	@Test
	void testGetId() {
		assertEquals(1, cart.getId());
	}

	@Test
	void testGetTotalProductsAmount() {
		assertEquals(0, cart.getTotalProductsAmount());
	}

	@Test
	void testGetCartItems() {
		assertEquals(cartItems, cart.getCartItems());
	}

	@Test
	void testGetUser() {
		cart.setUser(user);
		assertEquals(user, cart.getUser());
	}

	@Test
	void testSetId() {
		cart.setId(45);
		assertEquals(45, cart.getId());
	}

	@Test
	void testSetTotalProductsAmount() {
		cart.setTotalProductsAmount(340);
		assertEquals(340, cart.getTotalProductsAmount());
	}

	@Test
	void testSetCartItems() {
		List<CartItem> cartItems2 = new ArrayList<CartItem>();
		cart.setCartItems(cartItems2);
		assertEquals(cartItems2, cart.getCartItems());
	}

	@Test
	void testSetUser() {
		User user2 = new User();
		cart.setUser(user2);
		assertEquals(user2, cart.getUser());
	}

}
