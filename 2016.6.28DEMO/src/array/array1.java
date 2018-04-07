package array;
import java.util.Scanner;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,sum=0,b,j;
		int[] a=new int[]{8,4,2,1,23,344,12};	
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
			sum+=a[i];
		}
		System.out.print("\n");
		System.out.println("Summary:"+sum);
		Scanner input=new Scanner(System.in);
		System.out.println("Please guess:");
		b=input.nextInt();
		for(i=0;i<a.length;i++){
			if(b==a[i]){
				System.out.println("Congratulations!");
				break;
			}
		}
		if(i==a.length){
			System.out.println("Sorry!There isn't the number you just input!");
		}
		for(i=0;i<a.length-1;i++){
			for(j=i;j<a.length;j++){
				if(a[i]>a[j]){
					b=a[i];
					a[i]=a[j];
					a[j]=b;
				}
			}
		}
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
