package listDemo;

public abstract class Pet {
	private String name="";
	private int health=100;
	private int love=0;
	
	public Pet(){
		this.health=95;
		System.out.println("A pet is coming...");
	}
	
	public Pet(String n){
		this.name=n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}
	
	public void print(){
		System.out.println("The information of the pet:");
		System.out.println("Name:"+name);
		System.out.println("Health:"+health);
		System.out.println("Love:"+love);
	}
	
	public abstract void eat();
}
