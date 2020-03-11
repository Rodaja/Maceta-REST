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
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String password;
	private String country;
	@Column(unique= true)
	private String apiKey;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<FlowerPot> listFlowerPots;

	public User() {
	}

	public User(String email, String name, String firstSurname, String secondSurname, String password, String country,
			String apiKey, List<FlowerPot> listFlowerPots) {
		super();
		this.email = email;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.password = password;
		this.country = country;
		this.apiKey = apiKey;
		this.listFlowerPots = listFlowerPots;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
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

	public List<FlowerPot> getListFlowerPots() {
		return listFlowerPots;
	}

	public void setListFlowerPots(List<FlowerPot> listFlowerPots) {
		this.listFlowerPots = listFlowerPots;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", password=" + password + ", country=" + country + ", apiKey="
				+ apiKey + ", listFlowerPots=" + listFlowerPots + "]";
	}



}
