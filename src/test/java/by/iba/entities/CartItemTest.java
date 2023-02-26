package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CartItemTest {
	
	static CartItem cartItem;
	static CartItem cartItem2;
	static Cart cart = new Cart();
	static Product product = new Product();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setProductAmount(325);
		
		cartItem2 = new CartItem();
	}

	@Test
	void testGetCart() {
		assertEquals(cart, cartItem.getCart());
	}

	@Test
	void testGetProduct() {
		assertEquals(product, cartItem.getProduct());
	}

	@Test
	void testGetProductAmount() {
		assertEquals(325, cartItem.getProductAmount());
	}

	@Test
	void testSetCart() {
		cartItem2.setCart(cart);
		assertEquals(cart, cartItem2.getCart());
	}

	@Test
	void testSetProduct() {
		cartItem2.setProduct(product);
		assertEquals(product, cartItem2.getProduct());
	}

	@Test
	void testSetProductAmount() {
		cartItem2.setProductAmount(23);
		assertEquals(23, cartItem2.getProductAmount());
	}

}
