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

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.service.ServiceFlowerPot;

@RestController
public class ControllerFlowerPot {
	
	@Autowired
	private ServiceFlowerPot sf;
	
	@PostMapping(path = "api/flowerpots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlowerPot> guardar(@RequestBody FlowerPot fp) {
		if (sf.save(fp)) {
			return new ResponseEntity<FlowerPot>(fp, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<FlowerPot>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "api/flowerpots", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlowerPot>> listar() {
		List<FlowerPot> flowerpots = sf.findAll();
		return new ResponseEntity<List<FlowerPot>>(flowerpots, HttpStatus.OK);
	}

}
