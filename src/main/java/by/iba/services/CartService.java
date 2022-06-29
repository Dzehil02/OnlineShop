package by.iba.services;


import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.dao.CartDaoHibernateImpl;
import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.ids.CartItemId;

@Service
public class CartService {
	
	@Autowired
	private CartDaoHibernateImpl cartDao;
	
	@Transactional
	public Cart getCartById(int id) {
		Cart cart = cartDao.getCart(id);
		Hibernate.initialize(cart.getCartItems());
		return cart;
	}
	
	@Transactional
	public CartItem getCartItem(int userId, int productId) {
		CartItemId cartItemId = new CartItemId(userId, productId);
		CartItem cartItem = cartDao.getCartItem(cartItemId);
		return cartItem;
	}
	
	@Transactional
	public Cart createCartItem(int cartId, CartItem cartItem) {
		Cart cart = cartDao.getCart(cartId);
		
		cartItem.setCart(cart);
		cart.addItem(cartItem);
		cart.setTotalProductsAmount(cart.getTotalProductsAmount() + cartItem.getProductAmount());
		return cart;
	}
	
	@Transactional
	public String updateCartItem(int id, CartItem cartItem) {
		Cart cart = cartDao.getCart(id);
		
		cartItem.setCart(cart);
		CartItem searchCartItem = cart.searchCartItem(cartItem);

		if (searchCartItem != null) {
			cart.setTotalProductsAmount(cart.getTotalProductsAmount() + cartItem.getProductAmount() - searchCartItem.getProductAmount());
			searchCartItem.setProductAmount(cartItem.getProductAmount());
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
		cart.setTotalProductsAmount(cart.getTotalProductsAmount() - cartItem.getProductAmount());
	}

}
