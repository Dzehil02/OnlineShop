package by.iba.database.dao;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		Query<User> query = session.createQuery("from User where email = :username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();

		if (!session.getTransaction().isActive()) {
			session.close();
		}

		return user;
	}

	public User createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@SuppressWarnings("unchecked")
	public User getUserByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where activation_code = :code");
		query.setParameter("code", code);
		User user = (User) query.uniqueResult();
		return user;
	}
}
