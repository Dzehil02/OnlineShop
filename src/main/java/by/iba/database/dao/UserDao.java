package by.iba.database.dao;

import by.iba.entities.User;

public interface UserDao {

	User getUserByUsername(String username);
	
	User getUserByCode(String code);
	
	User createUser(User user);
	
	void deleteUser(User user);
	
}
