package by.iba.database.criteria;

import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;

public class Criterias {
	
	public Category category;
	
	public Brand brand;

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
	
	
}
