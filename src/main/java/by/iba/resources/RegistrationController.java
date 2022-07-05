package by.iba.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import by.iba.entities.User;
import by.iba.services.UserService;

@RestController
@RequestMapping
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@GetMapping("/activate/{code}")
	public String activate(@PathVariable String code) {
		
		boolean isActivated = userService.activateUser(code);
		
		if (isActivated) {
			return "User successfully activated";
		} else {
			return "Activation code is not found";
		}
		
	}
	
}
