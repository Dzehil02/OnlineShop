package by.iba.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import by.iba.resources.CatalogController;
import by.iba.resources.ProductController;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CatalogController.class, ProductController.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
