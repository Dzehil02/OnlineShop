package by.iba.entities;

public class Seller extends User {

	public Seller(String login, int password) {
		super(login, password);
	}

	public void addProduct(Catalog catalog, Product newProduct) {
		catalog.addProduct(newProduct);
	}

	public void removeProduct(Catalog catalog, int id) {
		catalog.removeProduct(id);
	}

}
