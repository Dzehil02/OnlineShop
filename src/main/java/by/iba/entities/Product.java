package by.iba.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

@Entity
@Table (name = "products")
public class Product implements Comparable<Product>, Cloneable, Serializable {

	private static final long serialVersionUID = 6909116790018884827L;

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

	public Product(int id, Category category, Brand brand, String model, int count) {
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.count = count;
		this.price = price;
	}
	
	public Product() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return category + " " + brand + " " + model + " : " + count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return brand == other.brand && category == other.category && Objects.equals(model, other.model);
	}

	@Override
	protected Product clone() {
		return new Product(this.id, this.category, this.brand, this.model, this.count);
	}

	@Override
	public int compareTo(Product o) {
		return ((Integer) this.count).compareTo((Integer) o.getCount());
	}

}
