package by.iba.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import by.iba.entities.enums.Role;

class UserTest {
	
	static User user;
	static User user2;
	static Date date = new Date(1980-10-11);
	static Cart cart = new Cart();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		user = new User();
		user.setActivationCode("1234567890");
		user.setBirthdate(date);
		user.setCart(cart);
		user.setEnabled(true);
		user.setId(1);
		user.setName("Aleh");
		user.setPassword("12345");
		user.setPhoneNumber("9668778");
		user.setRole(Role.ROLE_SELLER);
		user.setSurname("Velikiy");
		user.setUsername("aleh@mail.ru");
		
		user2 = new User();
	}


	@Test
	void testGetId() {
		assertEquals(1, user.getId());
	}

	@Test
	void testGetUsername() {
		assertEquals("aleh@mail.ru", user.getUsername());
	}

	@Test
	void testGetPassword() {
		assertEquals("12345", user.getPassword());
	}

	@Test
	void testGetName() {
		assertEquals("Aleh", user.getName());
	}

	@Test
	void testGetSurname() {
		assertEquals("Velikiy", user.getSurname());
	}

	@Test
	void testGetBirthdate() {
		assertEquals(date, user.getBirthdate());
	}

	@Test
	void testGetPhoneNumber() {
		assertEquals("9668778", user.getPhoneNumber());
	}

	@Test
	void testGetActivationCode() {
		assertEquals("1234567890", user.getActivationCode());
	}

	@Test
	void testIsEnabled() {
		assertEquals(true, user.isEnabled());
	}

	@Test
	void testGetRole() {
		assertEquals(Role.ROLE_SELLER, user.getRole());
	}

	@Test
	void testGetCart() {
		assertEquals(cart, user.getCart());
	}

	@Test
	void testSetId() {
		user2.setId(2);
		assertEquals(2, user2.getId());
	}

	@Test
	void testSetUsername() {
		user2.setUsername("oleg@tut.by");
		assertEquals("oleg@tut.by", user2.getUsername());
	}

	@Test
	void testSetPassword() {
		user2.setPassword("123");
		assertEquals("123", user2.getPassword());
	}

	@Test
	void testSetName() {
		user2.setName("Vasya");
		assertEquals("Vasya", user2.getName());
	}

	@Test
	void testSetSurname() {
		user2.setSurname("Vtoroy");
		assertEquals("Vtoroy", user2.getSurname());
	}

	@Test
	void testSetBirthdate() {
		Date birthDate = new Date(1999-01-03);
		user2.setBirthdate(birthDate);
		assertEquals(birthDate, user2.getBirthdate());
	}

	@Test
	void testSetPhoneNumber() {
		user2.setPhoneNumber("0987654321");
		assertEquals("0987654321", user2.getPhoneNumber());
	}

	@Test
	void testSetActivationCode() {
		user2.setActivationCode("lo-lo-lo-1234");
		assertEquals("lo-lo-lo-1234", user2.getActivationCode());
	}

	@Test
	void testSetEnabled() {
		user2.setEnabled(false);
		assertEquals(false, user2.isEnabled());
	}

	@Test
	void testSetRole() {
		user2.setRole(Role.ROLE_CUSTOMER);
		assertEquals(Role.ROLE_CUSTOMER, user2.getRole());
	}

	@Test
	void testSetCart() {
		user2.setCart(cart);
		assertEquals(cart, user2.getCart());
	}

}
