package es.rodaja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.rodaja.model.entity.ResetPassword;
import es.rodaja.model.service.ServiceResetPassword;
import es.rodaja.model.service.ServiceUser;


public class ControllerResetPassword {
	
	@Autowired
	private ServiceResetPassword srp;
	private ServiceUser su;
	
	@GetMapping(path = "api/resetPassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findAll(@RequestBody ResetPassword resetPassword) {
		if (resetPassword.getEmail() != null) {
			if (resetPassword.getCode() != null) {
				return new ResponseEntity<String>("Code sent",HttpStatus.BAD_REQUEST);
			} else {
				srp.sendEmail(resetPassword.getEmail());
				return new ResponseEntity<String>("Email sent to " + resetPassword.getEmail(),HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

}
