package by.iba.entities;

public abstract class User {
	public String login;
	public int password;
	public int age;
	public String name;

	public User(String login, int password, int age, String name) {
		this.login = login;
		this.password = password;
		this.age = age;
		this.name = name;
	}
	
}
