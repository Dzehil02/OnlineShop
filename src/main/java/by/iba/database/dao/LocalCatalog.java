package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import by.iba.entities.Product;
import by.iba.utils.FileUtils;

public class LocalCatalog implements Catalog {

	public ArrayList<Product> getProductList() {
		return FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
	}

	public Product getProductById(int id) {
		ArrayList<Product> productList = getProductList();
		return productList.stream().filter(product -> product.getId() == id).findFirst().get();
	}

	public void createProduct(Product newProduct) {
		ArrayList<Product> productList = getProductList();
		Optional<Product> productToAdd = productList.stream().filter(product -> product.equals(newProduct)).findFirst();
		if (productToAdd.isPresent()) {
			productToAdd.get().setCount(newProduct.getCount() + productToAdd.get().getCount());
		} else {
			int newProductId = getProductList().get(getProductList().size() - 1).getId() + 1;
			newProduct.setId(newProductId);
			productList.add(newProduct);
		}

		FileUtils.writeCatalog(productList, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
	}

	public void updateProduct(Product product) {
		ArrayList<Product> productList = getProductList();
		Product originalProduct = getProductById(product.getId());
		int originalProductIndex = productList.indexOf(originalProduct);
		productList.set(originalProductIndex, product);

		FileUtils.writeCatalog(productList, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
	}

	public void deleteProduct(Product product) {
		ArrayList<Product> productList = getProductList();
		productList.remove(product);

		FileUtils.writeCatalog(productList, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
	}

}
