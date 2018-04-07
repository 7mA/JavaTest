package epetshop.entity;
/**
 * Master entity class
 * @author asus
 * @create 2016.7.11
 */
public class PetOwner {
	/**
	 * Master's ID
	 */
	private int id;
	
	/**
	 * Master's name
	 */
	private String name;
	
	/**
	 * password
	 */
	private String password;
	
	/**
	 * Master's balance
	 */
	private double money;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
