package array;
import java.util.Arrays;

public class array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char[] a={'d','s','e','t','b','r'};
		int i;
		Arrays.sort(a);
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}*/
		String[] a={"dsa","fas","gefa","bgres"};
		String[] b=Arrays.copyOf(a,4);
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		//Arrays.fill(b, "sji");
		//System.out.println(Arrays.toString(b));
		System.out.println(Arrays.binarySearch(b,"bgres"));//binarySearch方法必须用于已排序的数组
	}

}
