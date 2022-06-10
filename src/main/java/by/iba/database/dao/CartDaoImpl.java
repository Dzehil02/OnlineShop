package by.iba.database.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cart getCart(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	@Override
	public void createCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cart);
	}
	
	@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cart);
	}

	@Override
	public void deleteCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cart);
	}


}
