package by.iba.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class Catalog implements Serializable {

	private static final long serialVersionUID = -543251562776995850L;

	private ArrayList<Product> productList;

	private Integer productId;

	public Catalog() {
		this.productList = new ArrayList<Product>();
		this.productId = 0;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Optional<Product> getProductById(int id) {
		return productList.stream().filter(product -> product.getId() == id).findFirst();
	}

	public void addProduct(Product newProduct) {
		Optional<Product> productToAdd = getProductById(newProduct.getId());
		if (productToAdd.isPresent()) {
			productToAdd.get().setCount(newProduct.getCount() + productToAdd.get().getCount());
		} else {
			productList.add(newProduct);
		}
	}

	public void removeProduct(int id) {
		productList.remove(getProductById(id).get());
	}

}
