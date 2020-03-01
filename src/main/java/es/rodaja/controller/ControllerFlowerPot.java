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

	@PutMapping(path = "api/flowerpots/{macAddress}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlowerPot> addMacetaUsuario(@PathVariable("macAddress") String macAddress, @RequestBody FlowerPot flowerpotModified) {
		Optional<FlowerPot> flowerpot = sf.findByMacAddress(macAddress);

		if (flowerpot.isPresent()) {
			sf.modify(flowerpotModified);
			return new ResponseEntity<FlowerPot>(flowerpotModified, HttpStatus.OK);
		} else {
			return new ResponseEntity<FlowerPot>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(path = "api/usuarios/{macAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrarMacetaUsuario(@PathVariable("macAddress") String macAddress) {
		Optional<FlowerPot> flowerpot = sf.findByMacAddress(macAddress);

		if (flowerpot.isPresent()) {
			sf.delete(macAddress);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NOT Deleted",HttpStatus.NOT_FOUND);
		}
	}
}
