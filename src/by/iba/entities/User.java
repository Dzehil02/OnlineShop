package by.iba.entities;

public abstract class User {

	public String login;

	public int password;

	public User(String login, int password) {
		this.login = login;
		this.password = password;
	}

}
