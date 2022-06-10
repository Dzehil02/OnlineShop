package by.iba.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import by.iba.database.dao.UserDaoHibernateImpl;
import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.User;
import by.iba.entities.enums.Role;

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
		
		if (user.getRole().equals(Role.ROLE_CUSTOMER)) {
			Cart cart = new Cart(user.getId(), 0, new ArrayList<CartItem>());
			cart.setUser(user);
			user.setCart(cart);
			System.out.println("Корзина создана, id: " + user.getId());
		}
		return userDao.createUser(user);
	}
	
	@Transactional
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}
}