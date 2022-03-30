package by.iba.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalog implements Serializable {

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
		//add to list
		if (productList.size() < 1) {
			productList.add(newProduct);

		} else {
			//переделать через stream()
			//Product existedProduct = productList.stream().filter(product -> product.getName().equals(newProduct.getName())).findFirst().orElse(newProduct);
			for (Product product : productList) {
				if (product.getModel().equals(newProduct.getModel())) {
					product.setCount(newProduct.getCount() + product.getCount());
					return;
				}
			}
			productList.add(newProduct);
		}

		//add to map
		productId = productId + 1;
		productMap.put(productId, newProduct);
	}

	public void removeProduct(Product product) {
		productList.remove(product);
		int num = productList.indexOf(product);
		productMap.remove(num - 1);
	}
	
	public void writeCatalog(Catalog catalog) {
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\Users\\Dzehil_A\\git\\OnlineShop\\bin\\by\\iba\\files\\catalog.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(catalog);
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readCatalog() {
		
		try {
			FileInputStream fis = new FileInputStream("c:\\Users\\Dzehil_A\\git\\OnlineShop\\bin\\by\\iba\\files\\catalog.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Catalog catalog1 = (Catalog) ois.readObject();
			ois.close();
			System.out.println("ArrayList: " + catalog1.getProductList());
			System.out.println("HashMap: " + catalog1.getProductMap());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
