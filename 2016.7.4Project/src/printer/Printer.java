package printer;

public class Printer {
	InBox inbox;
	Paper paper;
	
	public void setInbox(InBox inbox){
		this.inbox=inbox;
	}
	
	public void setPaper(Paper paper){
		this.paper=paper;
	}
	
	public void print(){
		System.out.println("Inbox:"+inbox.getColor());
		System.out.println("Paper:"+paper.getSize());
	}
}
