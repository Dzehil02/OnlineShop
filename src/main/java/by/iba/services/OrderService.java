package by.iba.services;

import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.dao.OrderDao;
import by.iba.entities.Order;
import by.iba.entities.OrderedProduct;
import by.iba.entities.User;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public ArrayList<Order> getOrdersOfUser(User user) {
		ArrayList<Order> orders = orderDao.getOrderListOfUser(user);
		for (Order order : orders) {
			Hibernate.initialize(order.getOrderedProducts());
		}
		return orders;
	}
	
	@Transactional
	public Order getOrder(String orderNumber) {
		Order order = orderDao.getOrder(orderNumber);
		Hibernate.initialize(order.getOrderedProducts());
		return order;
	}
	
	@Transactional
	public Order createOrder(Order order) {
		
		if (order.getOrderedProducts().size() != 0) {
		  double totalCost = 0;
	      order.setDate(new Date());
	      order.setOrderNumber(Integer.toString(order.getUser().getId()) + "-" + order.getDate());
	      
	      for (OrderedProduct orderedProduct: order.getOrderedProducts()) {
	    	  totalCost = totalCost + orderedProduct.getAmount() * orderedProduct.getPrice();
	    	  orderedProduct.setOrder(order);
		}
	      
	      order.setTotalCost(totalCost);

		return orderDao.createOrder(order);
		
		} else {
			return null;
		}
	
	}
	
}
