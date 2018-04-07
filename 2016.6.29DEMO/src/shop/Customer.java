package shop;

public class Customer {
	private String username;
	private String password;
	private int year;
	private int month;
	private int date;
	private int cardNumber;
	private static boolean flag=false;
	
	public Customer(String u,String p,int y,int m,int d){
		this.username=u;
		this.password=p;
		this.year=y;
		this.month=m;
		this.date=d;
		this.cardNumber=(int)((Math.random()*(9999-1000))+1000);
		flag=true;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}

	public static boolean isFlag() {
		// TODO Auto-generated method stub
		return flag;
	}
	
}
