package by.iba.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import by.iba.database.dao.UserDaoHibernateImpl;
import by.iba.entities.User;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserDaoHibernateImpl userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.getUserByUsername(username);
	}
	
	@Transactional
	public User createUser(User user) {
		user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
		userDao.createUser(user);
		return user;
	}
	
	@Transactional
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}
}
