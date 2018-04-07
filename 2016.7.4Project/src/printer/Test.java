package printer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InBox inbox=null;
		Paper paper=null;
		Printer printer=new Printer();
		
		inbox=new GreyInBox();
		paper=new A4();
		printer.setInbox(inbox);
		printer.setPaper(paper);
		printer.print();
		
		inbox=new ColorInBox();
		paper=new B5();
		printer.setInbox(inbox);
		printer.setPaper(paper);
		printer.print();
	}

}
