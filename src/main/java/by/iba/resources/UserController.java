package by.iba.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.User;
import by.iba.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{username}")
	@ResponseStatus(HttpStatus.OK)
	public User getUser(@PathVariable String username) {
		User user = (User) userService.loadUserByUsername(username);
		return user;
	}

	@DeleteMapping("/{username}")
	@Secured("ROLE_SELLER")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}

}
