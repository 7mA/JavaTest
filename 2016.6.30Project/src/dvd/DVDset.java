package dvd;
import java.util.*;

public class DVDset {
	String[] name=new String[50];
	boolean[] state=new boolean[50];
	String[] date=new String[50];
	int[] count=new int[50];
	static int counter=0;
	
	public void set(String n,boolean s,String d){
		name[counter]=n;
		state[counter]=s;
		date[counter]=d;
		if(s==false){
			count[counter]=1;
		}else{
			count[counter]=0;
		}
		counter++;
	}
	
	public void set(String n,boolean s,String d,int c,int index){
		name[index]=n;
		state[index]=s;
		date[index]=d;
		count[index]=c;
	}
	
	public void lendState(int index){
		Calendar ca=Calendar.getInstance();
		StringBuffer sb=new StringBuffer(ca.get(Calendar.YEAR)+"-"+(ca.get(Calendar.MONTH)+1)+"-"
				+ca.get(Calendar.DATE));
		state[index]=!state[index];
		date[index]=sb.toString();
		count[index]++;
	}
	
	public void returnState(int index){
		state[index]=!state[index];
		date[index]="";
	}
	
	public void display(int num){
		System.out.println(name[num]+" "+state[num]+" "+date[num]+" watched:"+count[num]);
	}
	
	public String getName(int n){
		return name[n];
	}
	
	public boolean getState(int n){
		return state[n];
	}
	
	public String getDate(int n){
		return date[n];
	}
	
	public int getRank(int n){
		return count[n];
	}
}
