package by.iba.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -97310568045465729L;

	@Id
	private int id;
	
	@Column(name = "total_products_amount")
	private int totalProductsAmount;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId
	@JoinColumn(name = "id")
	@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalProductsAmount() {
		return totalProductsAmount;
	}

	public void setTotalProductsAmount(int totalProductsAmount) {
		this.totalProductsAmount = totalProductsAmount;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Cart() {
		
	}
	
	public Cart(int id, int totalProductsAmount, List<CartItem> cartItems) {
		this.id = id;
		this.totalProductsAmount = 0;
		this.cartItems = cartItems;
	}
	
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalProductsAmount=" + totalProductsAmount + " ]";
	}
	
    public void addItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
    }
    
    public void removeItem(CartItem cartItem){
        this.cartItems.remove(cartItem);
        cartItem.setCart(null);
    }
    
	public void updateCartItems() {
		int totalAmount = 0;
		for (CartItem cartitem : this.getCartItems()) {
			System.out.println("ItemAmount: " + cartitem.getProductAmount());
			totalAmount = totalAmount + cartitem.getProductAmount();
		}
		this.setTotalProductsAmount(totalAmount);
	}
	
	public CartItem searchCartItem(CartItem cartItem) {
		CartItem searchCartItem = this.getCartItems()
				.stream()
				.filter(item -> item.getProduct().getId() == cartItem.getProduct().getId())
				.findFirst()
				.orElse(null);
		
		return searchCartItem;
	}

}
