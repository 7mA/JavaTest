package motoVehicle;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String no,brand,myType,carType;
		int seatCount,days,rent=0;
		Car car;
		Bus bus;
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("Day(s):");
		days=input.nextInt();
		System.out.println("Vehicle type:");
		myType=input.next();
		if("car".equals(myType)){
			System.out.print("Car brand:");
			brand=input.next();
			System.out.println("Type:");
			if("BUICK".equals(brand)){
				System.out.println("2/3");
			}else if("BMW".equals(brand)){
				System.out.println("1");
			}
			carType=input.next();
			no="LB88888";
			System.out.println("The NO:"+no);
			car=new Car(no,brand,carType);
			rent=car.calrent(days);
		}else if("bus".equals(myType)){
			System.out.print("Car brand:");
			brand=input.next();
			System.out.println("Seat Count:");
			seatCount=input.nextInt();
			no="LB88888";
			System.out.println("The NO:"+no);
			bus=new Bus(no,brand,seatCount);
			rent=bus.calrent(days);
		}
		System.out.println("Reat:"+rent);
	}

}
