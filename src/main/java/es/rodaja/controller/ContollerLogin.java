package es.rodaja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.rodaja.model.entity.Login;
import es.rodaja.model.entity.User;
import es.rodaja.model.service.ServiceUser;

@RestController
public class ContollerLogin {
	
	@Autowired
	private ServiceUser su;

	@PostMapping(path = "api/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody Login login){
		
		Optional<User> user = su.findByEmail(login.getEmail());
		
		if (user.isPresent()) {
			Optional<User> userChecked = su.checkCredentials(user.get(), login);
			
			//TODO Fix the null pointer exception
			if (userChecked.isPresent()) {
				return new ResponseEntity<User>(userChecked.get(),HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
}
