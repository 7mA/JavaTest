package entity;
import java.util.*;

public class Pet {
	private int id;
	private String name;
	private int health;
	private int love;
	private String strain;
	
	/*private int masterid;
	private Date adoptTime;
	private String status;*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public void show(){
		System.out.println("ID:"+id);
		System.out.println("Name:"+name);
		System.out.println("Health:"+health);
		System.out.println("Love:"+love);
		System.out.println("Strain:"+strain);
	}
	/*public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}
	public Date getAdoptTime() {
		return adoptTime;
	}
	public void setAdoptTime(Date adoptTime) {
		this.adoptTime = adoptTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
}
