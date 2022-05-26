package by.iba.database.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import by.iba.database.criteria.Criterias;
import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.utils.HibernateSessionFactoryUtil;

@Repository
public class CatalogDaoHibernateImpl implements CatalogDao {

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

	@Override
	public ArrayList<Product> getCategorizedCatalog(Criterias criteria) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("From Product where category = :category and brand = :brand ");
		query.setParameter("category", criteria.getCategory());
		query.setParameter("brand", criteria.getBrand());
		ArrayList<Product> products = (ArrayList<Product>) query.list();
		return products;
	}


	

}
