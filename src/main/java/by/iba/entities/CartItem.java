package by.iba.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import by.iba.entities.ids.CartItemId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@IdClass(CartItemId.class)
@Data
@NoArgsConstructor
public class CartItem implements Serializable {
	
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

}
