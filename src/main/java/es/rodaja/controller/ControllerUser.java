package es.rodaja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.entity.User;
import es.rodaja.model.service.ServiceUser;

@RestController
public class ControllerUser {

	@Autowired
	private ServiceUser su;

	@PostMapping(path = "api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User u) {
		if (su.save(u)) {
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "api/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll(@RequestParam(name = "email", required = false) String email) {
		if (email != null ) {
			List<User> users = su.findByEmail(email);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} else {
			List<User> users = su.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		
		
	}

	@GetMapping(path = "api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
		Optional<User> user = su.findById(id);

		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "api/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> modify(@PathVariable("id") Integer id, @RequestBody User userModified) {
		Optional<User> user = su.findById(id);

		if (user.isPresent()) {
			userModified.setId(id);
			su.modify(userModified);
			return new ResponseEntity<User>(userModified, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "api/users/{id}/flowerpot", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> modifyUserFlowerpots(@PathVariable("id") Integer id, @RequestBody FlowerPot fp) {
		Optional<User> user = su.findById(id);

		if (user.isPresent()) {
			su.addFlowerPot(user.get(), fp);
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		Optional<User> user = su.findById(id);

		if (user.isPresent()) {
			su.delete(id);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NOT Deleted", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "api/users/{id}/flowerpot/{macAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUserFlowerpot(@PathVariable("id") Integer id,
			@PathVariable("macAddress") String macAddress) {
		Optional<User> user = su.findById(id);

		if (user.isPresent() && !macAddress.isEmpty()) {
			su.removeFlowerPot(user.get(), macAddress);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NOT Deleted", HttpStatus.NOT_FOUND);
		}
	}

}
