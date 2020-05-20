package es.rodaja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.service.ServiceFlowerPot;

@RestController
public class ControllerFlowerPot {

	@Autowired
	private ServiceFlowerPot sf;

	@PostMapping(path = "api/flowerpots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlowerPot> save(@RequestBody FlowerPot flowerpot) {
		Optional<FlowerPot> flowerpotDataBase = sf.findByMacAddress(flowerpot.getMacAddress());

		if (flowerpotDataBase.isPresent()) {
			flowerpot.setName(flowerpotDataBase.get().getName());
			flowerpot.setImageUrl(flowerpotDataBase.get().getImageUrl());
			return new ResponseEntity<FlowerPot>(flowerpot, HttpStatus.CREATED);
		} else {
			if (sf.save(flowerpot)) {
				return new ResponseEntity<FlowerPot>(flowerpot, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<FlowerPot>(HttpStatus.BAD_REQUEST);
			}

		}

	}

	@GetMapping(path = "api/flowerpots", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlowerPot>> findAll() {
		List<FlowerPot> flowerpots = sf.findAll();
		return new ResponseEntity<List<FlowerPot>>(flowerpots, HttpStatus.OK);
	}

	@GetMapping(path = "api/flowerpots/{macAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlowerPot> findByMacAddress(@PathVariable("macAddress") String macAddress) {
		Optional<FlowerPot> flowerpot = sf.findByMacAddress(macAddress);
		if (flowerpot.isPresent()) {
			return new ResponseEntity<FlowerPot>(flowerpot.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<FlowerPot>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "api/flowerpots/update", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> updateSystem() {
		File file = null;
		InputStreamResource resource = null;
		try {

			file = new File("/arduino/Maceta-Arduino/code.bin");

			resource = new InputStreamResource(new FileInputStream(file));
			
			System.out.println(file.getAbsolutePath());
			
			System.out.println("Sended");
			return ResponseEntity.ok().contentLength(file.length())
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Bad Request");
			return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST);
		}

		
	}

	@PutMapping(path = "api/flowerpots/{macAddress}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlowerPot> modify(@PathVariable("macAddress") String macAddress,
			@RequestBody FlowerPot flowerpotModified) {
		Optional<FlowerPot> flowerpot = sf.findByMacAddress(macAddress);

		if (flowerpot.isPresent()) {
			FlowerPot flowerpotDataBase = flowerpot.get();

			sf.modify(sf.checkData(flowerpotDataBase, flowerpotModified));

			return new ResponseEntity<FlowerPot>(flowerpotModified, HttpStatus.OK);
		} else {
			return new ResponseEntity<FlowerPot>(HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * @DeleteMapping(path = "api/flowerpots/{macAddress}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<String>
	 * delete(@PathVariable("macAddress") String macAddress) { Optional<FlowerPot>
	 * flowerpot = sf.findByMacAddress(macAddress);
	 * 
	 * if (flowerpot.isPresent()) { sf.delete(macAddress); return new
	 * ResponseEntity<String>("Deleted", HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("NOT Deleted",HttpStatus.NOT_FOUND); } }
	 */
}
