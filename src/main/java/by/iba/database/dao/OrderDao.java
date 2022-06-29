package by.iba.database.dao;

import java.util.List;

import by.iba.entities.Order;
import by.iba.entities.User;

public interface OrderDao {

	List<Order> getUserOrderList(User user);

	Order getOrder(String orederNumber);

	Order createOrder(Order order);

}
