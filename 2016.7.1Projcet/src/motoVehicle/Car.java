package motoVehicle;

public class Car extends Vehicle{
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Car(String no,String brand,String type){
		super(no,brand);
		this.type=type;
	}
	
	public int calrent(int days){
		if("1".equals(type)){
			return days*500;
		}else if("2".equals(type)){
			return days*600;
		}else if("3".equals(type)){
			return days*300;
		}
		return 0;
	}
}
