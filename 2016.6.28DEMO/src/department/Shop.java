package department;
import java.util.*;

public class Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0,j;
		String userName="";
		String password="";
		String s1="";
		String s2="";
		int[] n=new int[10];
		boolean isLucky=false;
		int cardNumber=0;
		int max=9999;
		int min=1000;
		boolean isRegister=false;
		boolean isLogin=false;
		Scanner input=new Scanner(System.in);
		
		do{
			while(i!=1 && i!=2 && i!=3 && i!=4){
				System.out.println("******Shopping System******");
				System.out.println("      1.Register           ");
				System.out.println("      2.Login              ");
				System.out.println("      3.Luck Number        ");
				System.out.println("      4.Exit               ");
				System.out.println("***************************");
				i=input.nextInt();		
				if(i!=1 && i!=2 && i!=3 && i!=4){
					System.out.println("Invalid Number!");
				}
			}
			switch(i){
			case 1:
				System.out.print("Please input your username:");
				userName=input.next();
				System.out.print("Please input your password:");
				password=input.next();
				cardNumber=(int)((Math.random()*(max-min))+min);
				System.out.println("Register Success!");
				System.out.println("Your username:"+userName);
				System.out.println("Your password:"+password);
				System.out.println("Your card number:"+cardNumber);
				isRegister=true;
				isLogin=false;
				i=0;
				break;
			case 2:
				if(!isRegister){
					System.out.println("Please register before loginning!");
				}else if(isLogin){
					System.out.println("You have just logined!");
				}else{
					for(j=0;j<3;j++){
						System.out.print("Please input your username:");
						s1=input.next();
						System.out.print("Please input your password:");
						s2=input.next();
						if(s1.equals(userName) && s2.equals(password)){
							System.out.println("Login success!");
							isLogin=true;
							break;
						}else{
							System.out.println("Error!You have "+(2-j)+" chance(s)!");
							continue;
						}
					}
				}
				i=0;
				break;
			case 3:
				if(!(isRegister && isLogin)){
					System.out.println("Please register and login before doing luck number!");
				}else{
					for(j=0;j<10;j++){
						n[j]=(int)((Math.random()*(max-min))+min);
					}
					System.out.println("Your card number:"+cardNumber);
					System.out.println("The luck number:"+Arrays.toString(n));
					for(j=0;j<10;j++){
						if(n[j]==cardNumber){
							System.out.println("Congratulations!You got the 1st prize!");
							System.out.println("The lucky number is:"+n[j]);
							isLucky=true;
							break;
						}
					}
					if(!isLucky){
						for(j=0;j<10;j++){
							if((n[j]%1000==cardNumber%1000) || (n[j]/10==cardNumber/10)){
								System.out.println("Congratulations!You got the 2nd prize!");
								System.out.println("The lucky number is:"+n[j]);
								isLucky=true;
								break;
							}
						}
					}
					if(!isLucky){
						for(j=0;j<10;j++){
							if(((n[j]%1000)/10==(cardNumber%1000)/10) || (n[j]/100==cardNumber/100)
									|| (n[j]%100==cardNumber%100)){
								System.out.println("Congratulations!You got the 3rd prize!");
								System.out.println("The lucky number is:"+n[j]);
								isLucky=true;
								break;
							}
						}
					}
					if(!isLucky){
						System.out.println("Sorry,you didn't get any prize...");
					}
				}
				i=0;
				isLucky=false;
				break;
			}
		}while(i!=4);
		System.out.println("Thank you for your using!");
	}

}