package by.iba.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Catalog implements Serializable {

	private static final long serialVersionUID = -543251562776995850L;

	private ArrayList<Product> productList;

	private HashMap<Integer, Product> productMap;

	private Integer productId;

	public Catalog() {
		this.productList = new ArrayList<Product>();
		this.productMap = new HashMap<>();
		this.productId = 0;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public HashMap<Integer, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(HashMap<Integer, Product> productMap) {
		this.productMap = productMap;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void addProduct(Product newProduct) {
		// add to list
		list: {
			if (productList.size() < 1) {
				productList.add(newProduct);

			} else {
				// переделать через stream()
				// Product existedProduct = productList.stream().filter(product ->
				// product.getName().equals(newProduct.getName())).findFirst().orElse(newProduct);
				for (Product product : productList) {
					if (product.equals(newProduct)) {
						product.setCount(newProduct.getCount() + product.getCount());
						break list;
					}
				}
				productList.add(newProduct);
			}
		}

		// add to map
		map: {
			if (productMap.size() < 1) {
				productId = productId + 1;
				productMap.put(productId, newProduct.clone());
			} else {
				productId = productId + 1;
				for (Product product : productMap.values()) {
					if (product.equals(newProduct)) {
						product.setCount(newProduct.getCount() + product.getCount());
						break map;
					}
				}
				productMap.put(productId, newProduct.clone());
			}
		}
	}

	public void removeProduct(Product product) {
		productList.remove(product);
		int num = 0;
		for (Entry<Integer, Product> entry : productMap.entrySet()) {
	        if (entry.getValue().equals(product)) {
	            num = entry.getKey();
	        }
	    }
		productMap.remove(num);
	}

}
