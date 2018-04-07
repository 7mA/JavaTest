package book;

public class ExFactory {
	public static EX create(int id)  {
		switch (id) {
		case 1:
			return new CD();
		case 3:
			return new Bag();
		case 2:
			return new Pen();
		default:
			return null;
		}
	}
}
