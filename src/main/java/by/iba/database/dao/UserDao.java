package by.iba.database.dao;

import by.iba.entities.User;

public interface UserDao {

	User getUserByUsername(String username);
	
	User createUser(User user);
	
	void deleteUser(User user);
	
}
