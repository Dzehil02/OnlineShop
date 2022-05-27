package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.database.criteria.Criterias;
import by.iba.entities.Product;

@Repository
public class CatalogDaoHibernateImpl implements CatalogDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		return session.get(Product.class, id);
	}

	@Override
	public ArrayList<Product> getProductList() {
		Session session = sessionFactory.openSession();
		ArrayList<Product> products = (ArrayList<Product>) session.createQuery("from Product").list();
		session.close();
		return products;
	}

	@Override
	public void createProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}

	@Override
	public Optional<Product> getExistingProduct(Product product) {
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createQuery("select p from Product p where p.category = :category and p.brand = ?2 and p.model = ?3");
		query.setParameter("category", product.getCategory());
		query.setParameter(2, product.getBrand());
		query.setParameter(3, product.getModel());
		return Optional.ofNullable(query.uniqueResult());
	}

	@Override
	public ArrayList<Product> getCategorizedCatalog(Criterias criteria) {
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createQuery("From Product where category = :category and brand = :brand ");
		query.setParameter("category", criteria.getCategory());
		query.setParameter("brand", criteria.getBrand());
		ArrayList<Product> products = (ArrayList<Product>) query.list();
		return products;
	}


	

}
