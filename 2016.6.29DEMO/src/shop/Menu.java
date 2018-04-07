package shop;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu m=new MainMenu();
		Customer[] c;
		c=new Customer[10];
		Manager mgr=new Manager();
		m.showLoginMenu(c);
		System.out.println("Thank you for using!");
	}

}
