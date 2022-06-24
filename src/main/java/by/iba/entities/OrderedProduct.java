package by.iba.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ordered_products")
@Data
@ToString(exclude = "order")
@NoArgsConstructor
public class OrderedProduct implements Serializable {

	private static final long serialVersionUID = -9103383106575343143L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "order_number")
	@JsonIgnore
	private Order order;
	
	@Id
	@Column
	private String model;
	
	@Column
	private int amount;
	
	@Column
	private double price;

}
