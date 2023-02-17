package by.iba.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import by.iba.database.criteria.Criterias;
import by.iba.database.criteria.ProductSearchCriteria;
import by.iba.entities.Product;
import by.iba.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private CatalogService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getCatalog() {
		List<Product> products =(List<Product>) service.getCatalog(); 
		return products;
	}
	
	@GetMapping("/categorized")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getCategorized(@RequestHeader("criteria") String criteriaHeader) {
		Criterias criteria = new Gson().fromJson(criteriaHeader, Criterias.class);
		return service.getCatalogByCriterias(criteria); 
	}
	
	@GetMapping("/models")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getFilteresProducts(@RequestHeader("filter") String model) {
		ProductSearchCriteria productSearchCriteria = new Gson().fromJson(model, ProductSearchCriteria.class);		
		return service.getCatalogByModels(productSearchCriteria);
	}
	
}
