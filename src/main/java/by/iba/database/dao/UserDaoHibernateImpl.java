package by.iba.database.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		
		Query<User> query = session.createQuery("from User where email = :username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();

		session.close();
		return user;
	}

	public User createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}
	
	public void deleteUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where email = :username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.delete(user);
		System.out.println("USER " + username + " DELETED");
	}
}
