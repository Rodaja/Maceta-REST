package es.rodaja.model.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogFileTest {

	@Test
	void collectDataTest() {
		LogFile logFile = new LogFile();
		System.out.println(logFile.collectData("GET"));
		
	}

}
