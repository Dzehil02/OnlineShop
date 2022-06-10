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
		int id = user.getId();
		return cartService.getCartById(id);
	}
	
	@DeleteMapping
	@Secured("ROLE_CUSTOMER")
	public void deleteCart(@AuthenticationPrincipal User user) {
		int cartId = user.getId();
		Cart cart = cartService.getCartById(cartId);
		cartService.deleteCart(cart);
	}

	@PostMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public void addItem(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		int cartId = user.getId();
		Cart cart = cartService.getCartById(cartId);
		cartItem.setCart(cart);
		cart.addItem(cartItem);
		cart.updateCartItems();
		cartService.updateCart(cart);
	}

	@PutMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public String updateCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		int cartId = user.getId();
		Cart cart = cartService.getCartById(cartId);
		cartItem.setCart(cart);
		CartItem searchCartItem = cart.searchCartItem(cartItem);

		if (searchCartItem != null) {
			searchCartItem.setProductAmount(cartItem.getProductAmount());
			cart.updateCartItems();
			cartService.updateCart(cart);
			return "Количество продукта с ID: " + cartItem.getProduct().getId() + " было обновлено на "
					+ searchCartItem.getProductAmount();
		} else {
			return "Продукт с ID: " + cartItem.getProduct().getId() + " отсутствует в корзине";
		}

	}

	@DeleteMapping("/item")
	@Secured("ROLE_CUSTOMER")
	public void deleteCartItemFromCart(@RequestBody CartItem cartItem, @AuthenticationPrincipal User user) {
		int cartId = user.getId();
		Cart cart = cartService.getCartById(cartId);
		cartItem.setCart(cart);
		cart.removeItem(cartItem);
		cart.updateCartItems();
		cartService.updateCart(cart);
	}

}
