package by.iba.database.dao;

import java.util.ArrayList;

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
	public ArrayList<Order> getOrderListOfUser (User user) {
		Session session = sessionFactory.getCurrentSession();
		int userId = user.getId();
		Query<Order> query = session.createQuery("from Order where user_id = :userid");
		query.setParameter("userid", userId);
		ArrayList<Order> orders = (ArrayList<Order>) query.list();
		return orders;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Order getOrder(String orederNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from Order where order_number = :ordernumber");
		query.setParameter("ordernumber", orederNumber);
		Order order = query.uniqueResult();
		return order;	
	}
	
	@Override
	public Order createOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		return order;
	}

}
