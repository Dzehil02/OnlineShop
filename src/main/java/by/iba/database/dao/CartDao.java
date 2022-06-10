package by.iba.database.dao;

import by.iba.entities.Cart;

public interface CartDao {
	
	Cart getCart(int cartId);
	void createCart(Cart cart);
	void updateCart(Cart cart);
	void deleteCart(Cart cart);
	
}
