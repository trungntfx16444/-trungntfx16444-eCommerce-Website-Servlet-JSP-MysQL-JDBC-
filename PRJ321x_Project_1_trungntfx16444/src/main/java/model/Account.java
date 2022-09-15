package model;

public class Account {
	private String usr;
	private String pwd;
	private int role;
	private String name, address, phone;
	private int check;

	public Account() {
		super();
	}

	public Account(String usr, String pwd, int role, String name, String address, String phone, int check) {
		super();
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.check = check;
	}

	public String getUsr() {
		return usr;
	}

	public String getPwd() {
		return pwd;
	}

	public int getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public int getCheck() {
		return check;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Account [usr=" + usr + ", pwd=" + pwd + ", role=" + role + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", check=" + check + "]";
	}

}
