package by.iba.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.Cart;
import by.iba.entities.User;
import by.iba.entities.enums.Role;
import by.iba.services.CartService;
import by.iba.services.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@GetMapping("/{username}")
	public User registration(@PathVariable String username) {
		User user = (User) userService.loadUserByUsername(username);
		return user;
	}
	
	@DeleteMapping("/{username}")
	@Secured("ROLE_SELLER")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeUser(@PathVariable String username) {
		User user = (User) userService.loadUserByUsername(username);
		if (user.getRole() == Role.ROLE_CUSTOMER) {
			Cart cart = cartService.getCartById(user.getId());
			cartService.deleteCart(cart);
		}
		userService.deleteUser(username);
	}
	
}
