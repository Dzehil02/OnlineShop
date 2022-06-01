package by.iba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import by.iba.configuration.ApplicationConfiguration;
import by.iba.database.dao.CatalogDaoHibernateImpl;
import by.iba.resources.CatalogController;
import by.iba.resources.ProductController;
import by.iba.services.CatalogService;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@SpringBootApplication
@ComponentScan(basePackages = "by.iba")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
