package by.iba.entities;

import java.io.Serializable;
import java.util.Objects;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

public class Product implements Comparable<Product>, Cloneable, Serializable {

	private static final long serialVersionUID = 6909116790018884827L;

	private int id;

	private Category category;

	private Brand brand;

	private String model;

	private int count;

	public Product(int id, Category category, Brand brand, String model, int count) {
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.count = count;
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
