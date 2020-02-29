package es.rodaja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.rodaja.model.entity.User;
import es.rodaja.model.service.ServiceUser;

@RestController
public class ControllerUser {
	
	@Autowired
	private ServiceUser su;
	
	@PostMapping(path = "api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> guardar(@RequestBody User u) {
		if (su.save(u)) {
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
