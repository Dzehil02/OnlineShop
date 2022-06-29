package by.iba.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.Order;
import by.iba.entities.User;
import by.iba.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getUserOrders(@AuthenticationPrincipal User user) {
		return orderService.getUserOrders(user);
	}
	
	@GetMapping("/{orderNumber}")
	@ResponseStatus(HttpStatus.OK)
	public Order getOrder(@PathVariable String orderNumber) {
		return orderService.getOrder(orderNumber);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody Order order, @AuthenticationPrincipal User user) {
		order.setUser(user);
		orderService.createOrder(order);
	}

}
