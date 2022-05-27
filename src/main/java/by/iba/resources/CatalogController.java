package by.iba.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import by.iba.database.criteria.Criterias;
import by.iba.entities.Product;
import by.iba.services.CatalogService;

@RestController
@RequestMapping("/catalog")
@Component
public class CatalogController {

	
	@Autowired
	private CatalogService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Product> getCatalog() {
		return service.getCatalog();
	}
	
	@GetMapping("/categorized")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Product> getCategorized(@RequestHeader("criteria") String criteriaHeader) {
		Criterias criteria = new Gson().fromJson(criteriaHeader, Criterias.class);
		return service.getCatalogByCriterias(criteria);
	}
	
}