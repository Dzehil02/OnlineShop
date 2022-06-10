package by.iba.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.dao.CartDaoImpl;
import by.iba.entities.Cart;

@Service
public class CartService {
	
	@Autowired
	private CartDaoImpl cartDao;
	
	public Cart getCartById(int id) {
		return cartDao.getCart(id);
	}
	
	@Transactional
	public void createCart(Cart cart) {
		cartDao.createCart(cart);
	}
	
	@Transactional
	public void deleteCart(Cart cart) {
		cartDao.deleteCart(cart);
	}
	
	@Transactional
	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

}
