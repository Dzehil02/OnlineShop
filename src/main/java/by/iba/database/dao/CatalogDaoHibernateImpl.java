package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.HibernateException;
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
		Session session;
		
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		
		Product product = session.get(Product.class, id);
		
		if (!session.getTransaction().isActive()) {
			session.close();
		}
		
		return product;
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Product> getExistingProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product where category = :category and brand = :brand and model = :model");
		query.setParameter("category", product.getCategory());
		query.setParameter("brand", product.getBrand());
		query.setParameter("model", product.getModel());
		
		return Optional.ofNullable(query.uniqueResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> getCategorizedCatalog(Criterias criteria) {
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createQuery("from Product where category = :category and brand = :brand ");
		query.setParameter("category", criteria.getCategory());
		query.setParameter("brand", criteria.getBrand());
		ArrayList<Product> products = (ArrayList<Product>) query.list();
		session.close();
		return products;
	}

}
