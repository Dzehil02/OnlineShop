package by.iba.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.dao.CartDaoImpl;
import by.iba.entities.Cart;
import by.iba.entities.CartItem;

@Service
public class CartService {
	
	@Autowired
	private CartDaoImpl cartDao;
	
	@Transactional
	public Cart getCartById(int id) {
		Cart cart = cartDao.getCart(id);
		cart.updateCartItems();
		return cart;
	}
	
	@Transactional
	public Cart createCartItem(int cartId, CartItem cartItem) {
		Cart cart = cartDao.getCart(cartId);
		
		cartItem.setCart(cart);
		cart.addItem(cartItem);
		cart.updateCartItems();
		
		return cart;
	}
	
	@Transactional
	public String updateCartItem(int id, CartItem cartItem) {
		Cart cart = cartDao.getCart(id);
		
		cartItem.setCart(cart);
		CartItem searchCartItem = cart.searchCartItem(cartItem);

		if (searchCartItem != null) {
			searchCartItem.setProductAmount(cartItem.getProductAmount());
			cart.updateCartItems();
			return "Количество продукта с ID: " + cartItem.getProduct().getId() + " было обновлено на "
					+ searchCartItem.getProductAmount();
		} else {
			return "Продукт с ID: " + cartItem.getProduct().getId() + " отсутствует в корзине";
		}
	}
	
	@Transactional
	public void deleteCartItem(int id, CartItem cartItem) {
		Cart cart = cartDao.getCart(id);
		cartItem.setCart(cart);
		cart.removeItem(cartItem);
		cart.updateCartItems();
	}

}
