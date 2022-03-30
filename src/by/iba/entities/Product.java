package by.iba.entities;

import java.io.Serializable;
import java.util.Objects;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

public class Product implements Serializable {
	
	private Category category;
	private Brand brand;	
	private String model;
	private int count;
	
	public Product(Category category, Brand brand, String model, int count) {
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.count = count;
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
		return model + " : " + count;
	}

//	@Override
	public int hashCode() {
		return Objects.hash(brand, category, model);
	}

//	@Override
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
	
}
