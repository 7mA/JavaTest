package pet;

public class Penguin extends Pet{
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Penguin(String name,String gender){
		super(name);
		this.gender=gender;
	}
	
	public void print(){
		super.print();
		System.out.println("The pet is a "+gender+" penguin!");
	}
	
	public void eat(){
		if(getHealth()>=100){
			System.out.println("The penguin isn't hungry!");
		}else{
			setHealth(getHealth()+3);
			System.out.println("Health+3!\nThe Penguin's Health:"+getHealth());
		}
	}
}
