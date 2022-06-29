package by.iba.database.dao;

import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.ids.CartItemId;

public interface CartDao {
	
	Cart getCart(int cartId);
	
	CartItem getCartItem(CartItemId cartItemId);
	
}
