package es.rodaja.model.entity;

public class UserConfiguration {

	private String temperature;
	private String theme;
	private boolean notifications; 
	
	public UserConfiguration() {
		this.temperature = "celsius";
		this.theme = "light";
		this.notifications = false;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "UserConfiguration [temperature=" + temperature + ", theme=" + theme + ", notifications=" + notifications
				+ "]";
	}		
	
	
}

