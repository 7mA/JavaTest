package shop;
import java.util.*;

public class MainMenu {
	private static int newpos=0;
	
	public void showLoginMenu(Customer[] c){
		System.out.println("********Welcome********");
		System.out.println("        1.Login        ");
		System.out.println("        2.Exit         ");
		System.out.println("***********************");
		boolean f;
		int no;
		String s1,s2;
		boolean f3;
		Manager mgr=new Manager();
		do{
			f=false;
			Scanner input=new Scanner(System.in);
			no=input.nextInt();
			if(no==1){
				System.out.print("Username:");
				s1=input.next();
				System.out.print("Password:");
				s2=input.next();
				f3=mgr.test(s1, s2);
				if(f3){
					showMainMenu(c);
				}else{
					while(!f3){
						System.out.println("Error!");
						System.out.print("Username:");
						s1=input.next();
						System.out.print("Password:");
						s2=input.next();
						f3=mgr.test(s1, s2);
					}
					showMainMenu(c);
				}
			}else if(no!=2){
				System.out.println("Error!");
				f=true;
			}
		}while(f);
	}
	public void showMainMenu(Customer[] c){
		System.out.println("*****************Menu*****************");
		System.out.println("        1.Customer Information        ");
		System.out.println("        2.Gift                        ");
		System.out.println("        0.return                      ");
		System.out.println("**************************************");
		boolean f;
		int no;
		do{
			f=false;
			Scanner input=new Scanner(System.in);
			no=input.nextInt();
			if(no==1){
				showCustMenu(c);
			}else if(no==2){
				showSendMenu(c);
			}else if(no==0){
				showLoginMenu(c);
			}else{
				System.out.println("Error!");
				f=true;
			}
		}while(f);
	}
	public void showCustMenu(Customer[] c){
		System.out.println("********Customer Information********");
		System.out.println("        1.Display all               ");
		System.out.println("        2.New customer              ");
		System.out.println("        3.Edit customer             ");
		System.out.println("        4.Find customer             ");
		System.out.println("        0.return                    ");
		System.out.println("************************************");
		boolean f;
		int no;
		do{
			f=false;
			Scanner input=new Scanner(System.in);
			no=input.nextInt();
			if(no==0){
				showMainMenu(c);
			}else if(no==1){
				for(int i=0;i<c.length;i++){
					if(c[i]!=null){
						System.out.println("Username:"+c[i].getUsername());
						System.out.println("Password:"+c[i].getPassword());
						System.out.println("Birthday:"+c[i].getYear()+"."+c[i].getMonth()+"."+c[i].getDate());
						System.out.println("Card Number:"+c[i].getCardNumber());
						System.out.print("\n");
					}
				}
				if(!Customer.isFlag()){
					System.out.println("You have no customer!");
				}
				showCustMenu(c);
			}else if(no==2){
				System.out.print("Username:");
				String u=input.next();
				System.out.print("Password:");
				String p=input.next();
				System.out.print("Birthday(y,m,d):");
				int y=input.nextInt();
				int m=input.nextInt();
				int d=input.nextInt();
				c[newpos]=new Customer(u,p,y,m,d);
				newpos=(newpos+1)%c.length;
				showCustMenu(c);
			}else if(no==3){
				if(Customer.isFlag()){
					System.out.print("Number:");
					int num=input.nextInt();
					while(num>c.length-1 || num<0 || c[num]==null){
						System.out.println("Error!");
						num=input.nextInt();
					}
					System.out.print("New Password:");
					String p=input.next();
					System.out.print("New Birthday(y,m,d):");
					int y=input.nextInt();
					int m=input.nextInt();
					int d=input.nextInt();
					c[num].setPassword(p);
					c[num].setYear(y);
					c[num].setMonth(m);
					c[num].setDate(d);
				}else{
					System.out.println("You have no customer!");
				}
				showCustMenu(c);
			}else if(no==4){
				System.out.print("Username:");
				String u=input.next();
				int i;
				for(i=0;i<c.length;i++){
					if(c[i]!=null && c[i].getUsername().equals(u)){
						break;
					}
				}
				if(i==c.length){
					System.out.println("Error!");
				}else{
					System.out.println("Username:"+c[i].getUsername());
					System.out.println("Password:"+c[i].getPassword());
					System.out.println("Birthday:"+c[i].getYear()+"."+c[i].getMonth()+"."+c[i].getDate());
					System.out.println("Card Number:"+c[i].getCardNumber());
					System.out.print("\n");
				}
				showCustMenu(c);
			}else{
				System.out.println("Error!");
				f=true;
			}
		}while(f);
	}
	public int showSendMenu(Customer[] c){
		Goods g=new Goods();
		System.out.println("********Gift********");
		System.out.println("      1.Prize       ");
		System.out.println("    2.Luck number   ");
		System.out.println("     3.Birthday     ");
		System.out.println("     0.return       ");
		System.out.println("********************");
		System.out.println("Ps.The information of the goods:");
		g.showGoods();
		boolean f;
		int no;
		do{
			f=false;
			boolean flag=false;
			Scanner input=new Scanner(System.in);
			no=input.nextInt();
			if(no==0){
				showMainMenu(c);
			}else if(no==1){
				for(int i=0;i<c.length;i++){
					if(c[i]!=null){
						if(i==c[i].getCardNumber()%10){
							System.out.println("Congratulations!"+c[i].getUsername()+
									" got the prize!");
							flag=true;
						}
					}
				}
				if(!flag){
					System.out.println("Sorry...No one got the prize...");
				}
				showSendMenu(c);
			}else if(no==2){
				int[] num=new int[10];
				boolean isLucky=false;
				for(int i=0;i<c.length;i++){
					if(c[i]!=null){
						for(int j=0;j<10;j++){
							num[j]=(int)((Math.random()*(9999-1000))+1000);
						}
						System.out.println(c[i].getUsername()+"'s card number:"+c[i].getCardNumber());
						System.out.println("The luck number:"+Arrays.toString(num));
						for(int j=0;j<10;j++){
							if(num[j]==c[i].getCardNumber()){
								System.out.println("Congratulations!"+c[i].getUsername()+
										" got the 1st prize!");
								System.out.println("The lucky number is:"+num[j]);
								isLucky=true;
								break;
							}
						}
						if(!isLucky){
							for(int j=0;j<10;j++){
								if((num[j]%1000==c[i].getCardNumber()%1000) 
										|| (num[j]/10==c[i].getCardNumber()/10)){
									System.out.println("Congratulations!"+c[i].getUsername()+
											" got the 2nd prize!");
									System.out.println("The lucky number is:"+num[j]);
									isLucky=true;
									break;
								}
							}
						}
						if(!isLucky){
							for(int j=0;j<10;j++){
								if(((num[j]%1000)/10==(c[i].getCardNumber()%1000)/10) 
										|| (num[j]/100==c[i].getCardNumber()/100)
										|| (num[j]%100==c[i].getCardNumber()%100)){
									System.out.println("Congratulations!"+c[i].getUsername()+
											" got the 3rd prize!");
									System.out.println("The lucky number is:"+num[j]);
									isLucky=true;
									break;
								}
							}
						}
						if(!isLucky){
							System.out.println("Sorry,the customer(s) didn't get any prize...");
						}
					}
					isLucky=false;
				}
				if(!Customer.isFlag()){
					System.out.println("You haven't any customer!");
				}
				showSendMenu(c);
			}else if(no==3){
				boolean flag2=false;
				Calendar ca=Calendar.getInstance();
				for(int i=0;i<c.length;i++){
					if(c[i]!=null && c[i].getMonth()==ca.get(Calendar.MONTH)+1 
							&& c[i].getDate()==ca.get(Calendar.DATE)){
						System.out.println("Happy birthday to "+c[i].getUsername()+"!");
						flag2=true;
					}
				}
				if(!flag2){
					System.out.println("Sorry...Today isn't anyone's birthday...");
				}
				showSendMenu(c);
			}else if(no!=1 && no!=2 && no!=3){
				System.out.println("Error!");
				f=true; 
			}
		}while(f);
		return no;
	}
}