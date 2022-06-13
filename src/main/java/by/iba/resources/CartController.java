package by.iba.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.User;
import by.iba.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	@Secured("ROLE_CUSTOMER")
	public Cart getCartById(@AuthenticationPrincipal User user) {
		return cartService.getCartById(user.getId());
	}
	
	@PostMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public void addItem(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.createCartItem(user.getId(), cartItem);
	}

	@PutMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public void updateCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.updateCartItem(user.getId(), cartItem);		
	}

	@DeleteMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public void deleteCartItemFromCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		cartService.deleteCartItem(user.getId(), cartItem);
	}

}
