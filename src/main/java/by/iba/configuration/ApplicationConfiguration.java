package by.iba.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class ApplicationConfiguration {
	
	@Autowired
	private org.springframework.core.env.Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory(@Autowired DataSource dataSource) throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		
		properties.put(Environment.DIALECT, environment.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put(Environment.SHOW_SQL, environment.getProperty("spring.jpa.show-sql"));
		properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, 
				environment.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("by.iba.entities");
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
