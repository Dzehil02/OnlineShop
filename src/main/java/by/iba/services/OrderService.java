package by.iba.services;

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
	
	@Autowired
	private MailService mailService;

	@Transactional
	public List<Order> getUserOrders(User user) {
		List<Order> orders = orderDao.getUserOrderList(user);
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
				String modelProduct = cartItem.getProduct().getModel();
				int amountProduct = cartItem.getProductAmount();
				double priceProduct = cartItem.getProduct().getPrice();
				totalCost = totalCost + amountProduct * priceProduct;
				OrderedProduct addedOrderProduct = new OrderedProduct(modelProduct, amountProduct, priceProduct);
				order.addProduct(addedOrderProduct);
			}

			order.setTotalCost(totalCost);
			
			String message = String.format(
					"Hello, %s! \n" +
							"Your order to: %s \n" +
							"Order price: %s",
					order.getUser().getName(),
					order.getAddress(),
					order.getTotalCost());
			
			mailService.sendMessage(order.getUser().getUsername(), "Your order from online shop", message);

			return orderDao.createOrder(order);

		} else {
			return null;
		}

	}

}
