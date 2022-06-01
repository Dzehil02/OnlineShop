package by.iba.database.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.entities.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(String username) {
		Session session = sessionFactory.openSession();
		
		Query<User> query = session.createQuery("from User where email = :username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();

		session.close();
		return user;
	}

	public void createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
}
