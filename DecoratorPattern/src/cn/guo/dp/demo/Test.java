package cn.guo.dp.demo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Girl g = new Tall(new GoldenHair(new AmericanGirl()));
		System.out.println(g.getDescription());
	}

}
