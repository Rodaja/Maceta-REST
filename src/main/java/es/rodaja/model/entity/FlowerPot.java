package es.rodaja.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flowerpot")
public class FlowerPot {

	@Id
	private String macAddress;
	private int groundHumidity; 
	private int brightness;
	private int airHumidity;
	private int airTemperature;
	
	public FlowerPot() {
	}
	
	public FlowerPot(String macAddress, int groundHumidity, int brightness, int airHumidity, int airTemperature) {
		super();
		this.macAddress = macAddress;
		this.groundHumidity = groundHumidity;
		this.brightness = brightness;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public int getGroundHumidity() {
		return groundHumidity;
	}

	public void setGroundHumidity(int groundHumidity) {
		this.groundHumidity = groundHumidity;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public int getAirHumidity() {
		return airHumidity;
	}

	public void setAirHumidity(int airHumidity) {
		this.airHumidity = airHumidity;
	}

	public int getAirTemperature() {
		return airTemperature;
	}

	public void setAirTemperature(int airTemperature) {
		this.airTemperature = airTemperature;
	}

	@Override
	public String toString() {
		return "FlowerPot [macAddress=" + macAddress + ", groundHumidity=" + groundHumidity + ", brightness="
				+ brightness + ", airHumidity=" + airHumidity + ", airTemperature=" + airTemperature + "]";
	}
	
	
}
