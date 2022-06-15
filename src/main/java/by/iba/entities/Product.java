package by.iba.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "cartItems"})
@EqualsAndHashCode(of = {"brand", "category", "model"})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "brand")
	@Enumerated(EnumType.STRING)
	private Brand brand;

	@Column(name = "model")
	private String model;

	@Column(name = "count")
	private int count;
	
	@Column(name = "price")
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<CartItem> cartItems;
	
}
