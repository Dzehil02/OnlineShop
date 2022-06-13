package by.iba.entities;

import java.io.Serializable;
import java.util.Objects;

public class CartItemId implements Serializable {

	private static final long serialVersionUID = 3081490489686775615L;
	private int cart;
	private int product;
	
	public CartItemId() {

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cart, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemId other = (CartItemId) obj;
		return cart == other.cart && product == other.product;
	}
	public int getCart() {
		return cart;
	}
	public void setCart(int cart) {
		this.cart = cart;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	
}
