package pet;

public class Dog extends Pet{
	private String strain;

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public Dog(String name,String strain){
		super(name);
		this.strain=strain;
	}
	
	public void print(){
		super.print();
		System.out.println("The pet is a "+strain+" dog!");
	}
	
	public void eat(){
		if(getHealth()>=100){
			System.out.println("The dog isn't hungry!");
		}else{
			setHealth(getHealth()+5);
			System.out.println("Health+5!\nThe Dog's Health:"+getHealth());
			System.out.print("\n");
		}
	}
}
