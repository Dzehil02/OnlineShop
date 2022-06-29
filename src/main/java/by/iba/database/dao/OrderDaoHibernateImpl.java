package by.iba.database.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.Order;
import by.iba.entities.User;

@Repository
public class OrderDaoHibernateImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getUserOrderList (User user) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from Order where user = :user");
		query.setParameter("user", user);
		List<Order> orders = query.list();
		return orders;	
	}
	
	@Override
	public Order getOrder(String orederNumber) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, orederNumber);
	}
	
	@Override
	public Order createOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		return order;
	}

}
