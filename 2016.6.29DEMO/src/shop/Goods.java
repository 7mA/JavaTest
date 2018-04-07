package shop;

public class Goods {
	String[] goods=new String[]{"fan","laundry","fridge"};
	double[] price=new double[]{123,400,2000};
	public void showGoods(){
		for(int i=0;i<goods.length;i++){
			System.out.println(goods[i]+":"+price[i]);
		}
	}
}
