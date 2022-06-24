package by.iba.database.dao;

import java.util.ArrayList;

import by.iba.entities.Order;
import by.iba.entities.User;

public interface OrderDao {
	
	ArrayList<Order> getOrderListOfUser(User user);
	Order getOrder(String orederNumber);
	Order createOrder(Order order);
	
}
