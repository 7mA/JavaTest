package cn.guo.hf.demo;

public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HumanFactory factory = new HumanFactory();
		Human human = HumanFactory.createMale();
		human.eat();
		human.sleep();
		human.beat();
	}

}
