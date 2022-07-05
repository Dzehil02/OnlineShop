package by.iba.services;

import java.util.ArrayList;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import by.iba.database.dao.UserDao;
import by.iba.entities.Cart;
import by.iba.entities.CartItem;
import by.iba.entities.User;
import by.iba.entities.enums.Role;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailService mailService;

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
		}
		
		user.setActivationCode(UUID.randomUUID().toString());
		
		String message = String.format(
				"Hello, %s! \n" +
						"Welcome to online shop. Please, visit activation link: http://localhost:8080/activate/%s",
						user.getUsername(),
						user.getActivationCode());
		
		mailService.sendMessage(user.getUsername(), "Activation code", message);
		
		return userDao.createUser(user);
	}
	
	@Transactional
	public void deleteUser(String username) {
		User user = userDao.getUserByUsername(username);
		userDao.deleteUser(user);
	}
	
	@Transactional
	public boolean activateUser(String code) {
		User user = userDao.getUserByCode(code);
		
		if (user == null) {
			return false;
		}
		
		user.setActivationCode(null);
		user.setEnabled(true);
		
		return true;
	}
}