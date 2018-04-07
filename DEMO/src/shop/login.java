package shop;
import java.util.Random;
import java.util.Scanner;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int j;
		String userName="";
		String password="";
		Scanner input=new Scanner(System.in);
		for(i=0;i<3;i++){
			System.out.println("Username:");
			userName=input.next();
			System.out.println("Password:");
			password=input.next();
			if("Guo".equals(userName) && "961212".equals(password)){
				System.out.println("Connected!");
				break;
			}else{
				System.out.println("Error!You have "+(2-i)+" chance(s)!");
				continue;
			}
		}
		if(i==3){
			System.out.println("End!");
		}else{
			i=(int)((Math.random()*10)+1);
			j=(int)((Math.random()*10)+1);
			if(i==j){
				System.out.println("Congratulations!Your number is "+i+"!");
			}else{
				System.out.println("Sorry!Your number is "+i+",but the goal is "+j+"!");
			}
		}
	}

}
