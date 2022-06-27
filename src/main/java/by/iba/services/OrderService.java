package by.iba.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.database.dao.CartDao;
import by.iba.database.dao.OrderDao;
import by.iba.entities.CartItem;
import by.iba.entities.Order;
import by.iba.entities.OrderedProduct;
import by.iba.entities.User;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartDao cartDao;
	
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
		
		List<CartItem> cartItems = cartDao.getCart(order.getUser().getId()).getCartItems();
		
		if (cartItems.size() != 0) {
		  double totalCost = 0;
	      order.setDate(new Date());
	      order.setOrderNumber(Integer.toString(order.getUser().getId()) + "-" + order.getDate());
	      
	      for (CartItem cartItem : cartItems) {
			String modelProduct =  cartItem.getProduct().getModel();
			int amountProduct = cartItem.getProductAmount();
			double priceProduct = cartItem.getProduct().getPrice();
			totalCost = totalCost + amountProduct * priceProduct;
			OrderedProduct addedOrderProduct = new OrderedProduct(modelProduct, amountProduct, priceProduct);
			order.addProduct(addedOrderProduct);
		}
	      
	    order.setTotalCost(totalCost);

		return orderDao.createOrder(order);
		
		} else {
			return null;
		}
	
	}
	
}
