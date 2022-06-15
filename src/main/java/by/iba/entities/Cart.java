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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@ToString(exclude = {"cartItems", "user"})
public class Cart implements Serializable {

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

	public Cart(int id, int totalProductsAmount, List<CartItem> cartItems) {
		this.id = id;
		this.totalProductsAmount = 0;
		this.cartItems = cartItems;
	}
	
    public void addItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
    }
    
    public void removeItem(CartItem cartItem){
        this.cartItems.remove(cartItem);
        cartItem.setCart(null);
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
