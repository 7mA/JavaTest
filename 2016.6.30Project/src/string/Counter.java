package string;
import java.io.IOException;
import java.util.*;

public class Counter {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String s;
		char c;
		Scanner input=new Scanner(System.in);
		System.out.print("Please input a string:");
		s=input.next();
		System.out.print("Please input a character:");
		c=(char)System.in.read();
		System.out.println("Time(s):"+counter(s,c));
	}
	
	public static int counter(String inputs,char word){
		int c=0;
		int i;
		for(i=0;i<inputs.length();i++){
			if(word==inputs.charAt(i)){
				c++;
			}
		}
		return c;
	}

}
