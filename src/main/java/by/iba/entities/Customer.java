package by.iba.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import by.iba.exceptions.NotEnoughProductsException;

public class Customer extends User {

	public int age;

	public String name;

	public Basket basket;

	public Customer(String login, int password, String name, int age) {
		super(login, password);
		this.name = name;
		this.age = age;
		basket = new Basket();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addProductToBasket(Catalog catalog, int productId, int productCount) {
		ArrayList<Product> productList = catalog.getProductList();

		Optional<Product> productAdded = productList.stream().filter(product -> product.getId() == productId)
				.findFirst();

		if (productAdded.isPresent()) {
			basket.addProduct(new Product(productId, productAdded.get().getCategory(), productAdded.get().getBrand(),
					productAdded.get().getModel(), productCount));
			System.out.println(
					"Товар " + productAdded.get().getModel() + " : " + productCount + " шт." + " добавлен в корзину");
		} else {
			System.out.println("Такого товара нет");
		}

	}

	public void orderProducts(Catalog catalog) throws NotEnoughProductsException {

		StringBuilder error = new StringBuilder("Недостаточно товара: ");

		List<Product> productsToChange = catalog.getProductList().stream()
				.filter(catalogProduct -> basket.getBasketProducts().stream().anyMatch(basketProduct -> {
					if (basketProduct.getId() == catalogProduct.getId()) {
						if (catalogProduct.getCount() < basketProduct.getCount()) {
							error.append(" " + catalogProduct);
						}
						return true;
					}
					return false;
				})).collect(Collectors.toList());

		if (error.length() > 21) {
			throw new NotEnoughProductsException(error.toString());
		}

		productsToChange.forEach(catalogProduct -> {
			catalogProduct.setCount(
					catalogProduct.getCount() - basket.getProductById(catalogProduct.getId()).get().getCount());
		});

		basket.clearBasket();
	}

	public void removeProductFromBasket(int productId) {
		System.out.println("Товар " + basket.getProductById(productId).get() + " удалён из корзины");
		basket.removeProduct(productId);
	}

}
