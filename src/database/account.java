package database;

public class account {
	String numberbank, firstname, lastname, password;
	int money;
	public account() {
	}
	
	public account(String numberbank, String firstname, String lastname, String password, int money) {
		this.numberbank = numberbank;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.money = money;
	}
	
	
	public String getNumberbank() {
		return numberbank;
	}
	public void setNumberbank(String numberbank) {
		this.numberbank = numberbank;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
