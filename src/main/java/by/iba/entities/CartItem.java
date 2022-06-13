package by.iba.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart_items")
@IdClass(CartItemId.class)
public class CartItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4287545633604288827L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "product_amount")
	private int productAmount;

	public CartItem() {
		
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cart, product, productAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(product, other.product)
				&& productAmount == other.productAmount;
	}

	@Override
	public String toString() {
		return "CartItem [cart=" + cart + ", product=" + product + ", productAmount=" + productAmount + "]";
	}

}
