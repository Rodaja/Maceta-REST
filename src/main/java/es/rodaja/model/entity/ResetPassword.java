package es.rodaja.model.entity;

public class ResetPassword {

	private String email;
	private String password;
	private String code;

	public ResetPassword(String email, String password, String code) {
		super();
		this.email = email;
		this.password = password;
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResetPassword [email=" + email + ", password=" + password + ", code=" + code + "]";
	}

}
