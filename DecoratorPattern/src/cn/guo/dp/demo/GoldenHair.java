package cn.guo.dp.demo;

public class GoldenHair extends GirlDecorator {

	private Girl g;
	
	public GoldenHair(Girl g){
		this.g = g;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return g.getDescription() + "+with golden hair";
	}

}
