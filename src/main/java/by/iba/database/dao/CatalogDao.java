package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import javax.enterprise.context.Dependent;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import by.iba.entities.Product;
import by.iba.utils.HibernateSessionFactoryUtil;

@Dependent
public class CatalogDao implements Catalog {

	@Override
	public Product getProductById(int id) {
		return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
	}

	@Override
	public ArrayList<Product> getProductList() {
		ArrayList<Product> products = (ArrayList<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return products;
	}

	@Override
	public void createProduct(Product product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
	}

	@Override
	public void updateProduct(Product product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx1 = session.beginTransaction();
		session.update(product);
		tx1.commit();
		session.close();
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx1 = session.beginTransaction();
		session.delete(product);
		tx1.commit();
		session.close();
	}

	@Override
	public Optional<Product> getExistingProduct(Product product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("select p from Product p where p.category = :category and p.brand = ?2 and p.model = ?3");
		query.setParameter("category", product.getCategory());
		query.setParameter(2, product.getBrand());
		query.setParameter(3, product.getModel());
		return Optional.ofNullable(query.uniqueResult());
	}

}
