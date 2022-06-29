package by.iba.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.User;
import by.iba.services.CartService;

@RestController
@RequestMapping("/cart")
@Secured("ROLE_CUSTOMER")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Cart getCartById(@AuthenticationPrincipal User user) {
		return cartService.getCartById(user.getId());
	}
	
	@GetMapping("/item/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CartItem getCartItem(@AuthenticationPrincipal User user, @PathVariable String id) {
		return cartService.getCartItem(user.getId(),Integer.parseInt(id));
	}
	
	@PostMapping("/item")
	@ResponseStatus(HttpStatus.CREATED)
	public void addItem(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.createCartItem(user.getId(), cartItem);
	}

	@PutMapping("/item")
	@ResponseStatus(HttpStatus.OK)
	public void updateCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.updateCartItem(user.getId(), cartItem);		
	}

	@DeleteMapping("/item")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCartItemFromCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.deleteCartItem(user.getId(), cartItem);
	}

}
