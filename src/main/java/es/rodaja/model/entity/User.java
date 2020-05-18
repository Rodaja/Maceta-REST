package es.rodaja.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique= true)
	private String email;
	private String userName;
	private String name;
	private String surname;
	private String password;
	private String country;
	@Column(unique= true)
	private String apiKey;
	
	private String temperature;
	private String theme;
	private boolean notifications; 
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<FlowerPot> listFlowerPots;

	public User() {
	}

	public User(String email, String userName, String name, String surname, String password, String country,
			String apiKey, List<FlowerPot> listFlowerPots, String temperature, String theme, boolean notifications) {
		super();
		this.email = email;
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.country = country;
		this.apiKey = apiKey;
		this.listFlowerPots = listFlowerPots;
		this.temperature = temperature;
		this.theme = theme;
		this.notifications = notifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public List<FlowerPot> getListFlowerPots() {
		return listFlowerPots;
	}

	public void setListFlowerPots(List<FlowerPot> listFlowerPots) {
		this.listFlowerPots = listFlowerPots;
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
		return "User [id=" + id + ", email=" + email + ", userName=" + userName + ", name=" + name + ", surname="
				+ surname + ", password=" + password + ", country=" + country + ", apiKey=" + apiKey
				+ ", listFlowerPots=" + listFlowerPots + ", temperature=" + temperature + ", theme=" + theme
				+ ", notifications=" + notifications + "]";
	}
}