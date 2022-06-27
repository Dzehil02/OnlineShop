package by.iba.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@ToString(exclude = {"orderedProducts", "user"})
public class Order implements Serializable {

	private static final long serialVersionUID = 36471869155288599L;
	
	@Id
	@Column(name = "order_number")
	private String orderNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@Column
	private Date date;
	
	@Column
	private String address;
	
	@Column(name = "total_cost")
	private double totalCost;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order",
			cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();
	
    public void addProduct(OrderedProduct orderedProduct){
    	this.orderedProducts.add(orderedProduct);
    	orderedProduct.setOrder(this);
    }

}


