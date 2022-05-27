package by.iba.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.Product;
import by.iba.services.ProductService;

@RestController
@RequestMapping("catalog/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProduct(@PathVariable("id") String id) {
		return service.getProductById(Integer.parseInt(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		service.createProduct(product);

	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeProduct(@RequestBody Product product) {
		service.deleteProduct(product);
	}
}
