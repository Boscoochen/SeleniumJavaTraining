public class User {
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;

	public User(int id, String email, String first_name, String last_name, String avatar) {
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFrist_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvata() {
		return this.avatar;
	}

	public void setAvata(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "{id=" + this.getId() + ", " + "email=" + this.getEmail() + ", " + "first_name=" + this.getFirst_name()
				+ ", " + "last_name=" + this.getLast_name() + ", " + "avatar=" + this.getAvata() + "}";
	}
}