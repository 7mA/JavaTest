package dvd;
import java.util.*;
import java.text.*;

public class DVDmgr {
	DVDset dvd=new DVDset();
	public void initial(){
		dvd.set("Roman Holiday",false,"2016-6-1");
		dvd.set("Independence Ceremony",false,"2016-5-1");
		dvd.set("Independence Day",true,"");
	}
	
	public void Menu(){
		System.out.println("********Welcome*******");
		System.out.println("        1.add         ");
		System.out.println("        2.display     ");
		System.out.println("        3.delete      ");
		System.out.println("        4.lend        ");
		System.out.println("        5.return      ");
		System.out.println("        6.rank        ");
		System.out.println("        7.exit        ");
		System.out.println("**********************");
		int choice;
		Scanner input=new Scanner(System.in);
		choice=input.nextInt();
		switch(choice){
		case 1:
			add();
			Menu();
			break;
		case 2:
			display();
			Menu();
			break;
		case 3:
			del();
			Menu();
			break;
		case 4:
			lend();
			Menu();
			break;
		case 5:
			returnDVD();
			Menu();
			break;	
		case 6:
			showRank();
			Menu();
			break;	
		case 7:
			break;
		}
	}
	
	public void display(){
		int i;
		for(i=0;i<DVDset.counter;i++){
			dvd.display(i);
		}
		if(DVDset.counter==0){
			System.out.println("There is no DVD on sale!");
		}
	}
	
	public void add(){
		String n;
		String d;
		Scanner input=new Scanner(System.in);
		System.out.print("Name:");
		n=input.nextLine();
		dvd.set(n, true, "");
		System.out.println("Add Success!");
	}
	
	public void del(){
		String n;
		Scanner input=new Scanner(System.in);
		System.out.print("Name:");
		n=input.nextLine();
		int i;
		boolean dele=false;
		for(i=0;i<DVDset.counter;i++){
			if(n.equals(dvd.name[i]) && dvd.state[i]){
				int h=i;
				for(int j=h+1;j<DVDset.counter;j++){
					dvd.set(dvd.getName(j), dvd.getState(j), dvd.getDate(j),dvd.getRank(j),h);
					h++;
				}
				DVDset.counter--;
				dele=true;
				System.out.println("Delete Success!");
				break;
			}
		}
		if(!dele){
			System.out.println("There is no such DVD with the name that can be deleted!");
		}
	}
	
	public void lend(){
		String n;
		Scanner input=new Scanner(System.in);
		System.out.print("Name:");
		n=input.nextLine();
		int i;
		for(i=0;i<DVDset.counter;i++){
			if(n.equals(dvd.name[i]) && dvd.state[i]){
				dvd.lendState(i);
				System.out.println("Lead Success!Charge:2 yuan/day!");
				break;
			}
		}
		if(i==DVDset.counter){
			System.out.println("There is no such DVD with the name that can be lent!");
		}
	}
	
	public void returnDVD(){
		String n;
		Scanner input=new Scanner(System.in);
		System.out.print("Name:");
		n=input.nextLine();
		int i;
		for(i=0;i<DVDset.counter;i++){
			if(n.equals(dvd.name[i]) && !dvd.state[i]){
				Calendar ca=Calendar.getInstance();
				StringBuffer sb=new StringBuffer(ca.get(Calendar.YEAR)+"-"+(ca.get(Calendar.MONTH)+1)+"-"
						+ca.get(Calendar.DATE));
				long charge=(cash(dvd.date[i],sb.toString())+1)*2;
				System.out.println("The charge:"+charge+" yuan!Thank you for enjoying!");
				dvd.returnState(i);	
				break;
			}
		}
		if(i==DVDset.counter){
			System.out.println("There is no such DVD with the name that can be returned!");
		}
	}
	
	public long cash(String begin,String end){
		long cash=0;
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date d1=sd.parse(begin);
			Date d2=sd.parse(end);
			cash=(d2.getTime()-d1.getTime())/(24*60*60*1000);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return cash;
	}
	
	public void showRank(){
		int i,j,temp;
		int[] n=new int[DVDset.counter];
		for(i=0;i<DVDset.counter;i++){
			n[i]=i;
		}
		for(i=0;i<DVDset.counter-1;i++){
			for(j=i+1;j<DVDset.counter;j++){
				if(dvd.getRank(i)<dvd.getRank(j)){
					temp=n[i];
					n[i]=n[j];
					n[j]=temp;
				}
			}
		}
		if(DVDset.counter==0){
			System.out.println("There is no DVD on sale!");
		}else{
			for(i=0;i<DVDset.counter;i++){
				dvd.display(n[i]);
			}
		}
	}
}
