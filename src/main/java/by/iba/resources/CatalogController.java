package by.iba.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.iba.criteria.Criterias;
import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private CatalogService service = new CatalogService();

	@GetMapping
	public ArrayList<Product> getCatalog() {
		System.out.println(service.getCatalog());
		return service.getCatalog();
	}
	
	@GetMapping("/criterias")
	public ArrayList<Product> getCatalogByCriterias(@RequestBody Criterias criteria) {
		return service.getCatalogByCriterias(criteria);
	}
	
}
