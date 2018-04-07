package cn.guo.dp.demo;

public class Tall extends GirlDecorator {

	private Girl g;
	
	public Tall(Girl g){
		this.g = g;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return g.getDescription() + "+is very tall";
	}

}
