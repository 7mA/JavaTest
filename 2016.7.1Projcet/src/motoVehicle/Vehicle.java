package motoVehicle;

public abstract class Vehicle {
	private String no;
	private String brand;
	
	public Vehicle(){}
	
	public Vehicle(String no,String brand){
		this.no=no;
		this.brand=brand;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public abstract int calrent(int days);
}
