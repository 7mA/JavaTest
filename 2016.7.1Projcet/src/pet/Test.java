package pet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog("Darry","Golden");
		dog.print();
		System.out.print("\n");
		dog.setHealth(80);
		
		Penguin pgn=new Penguin("Nana","Famale");
		pgn.print();
		System.out.print("\n");
		pgn.setHealth(100);
		
		Master ma=new Master();
		ma.feed(dog);
		ma.feed(pgn);
	}

}
