package motoVehicle;

public class Bus extends Vehicle{
	private int seatCount;

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
	public Bus(String no,String brand,int seatCount){
		super(no,brand);
		this.seatCount=seatCount;
	}
	
	public int calrent(int days){
		if(seatCount<=16){
			return days*800;
		}else{
			return days*1500;
		}
	}
}
