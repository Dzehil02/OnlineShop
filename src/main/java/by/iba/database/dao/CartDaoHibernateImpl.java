package by.iba.database.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.ids.CartItemId;

@Repository
public class CartDaoHibernateImpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cart getCart(int cartId) {
		Session session;
		try {			
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		
		Cart cart = session.get(Cart.class, cartId);

        if(!session.getTransaction().isActive()) {
            session.close();
        }

		return cart;
	}

	@Override
	public CartItem getCartItem(CartItemId cartItemId) {
		Session session;
		try {			
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		
		CartItem cartItem = session.get(CartItem.class, cartItemId);
		
        if(!session.getTransaction().isActive()) {
            session.close();
        }
				
		return cartItem;
	}
	
	

}
