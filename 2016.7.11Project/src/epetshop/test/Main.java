package epetshop.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import epetshop.biz.PetOwnerManage;
import epetshop.biz.impl.PetOwnerManageImpl;
import epetshop.entity.Pet;
import epetshop.entity.PetOwner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		PetOwnerManage m=new PetOwnerManageImpl();
		List<Pet> ps=new ArrayList();
		System.out.print("Username:");
		String name=input.next();
		System.out.print("Password:");
		String password=input.next();
		PetOwner mas=new PetOwner();
		mas.setName(name);
		mas.setPassword(password);
		mas=m.login(mas);
		if(mas!=null){
			ps=m.getMyPet(mas.getId());
			for(Pet p:ps){
				System.out.println("ID:"+p.getId());
				System.out.println("Name:"+p.getName());
				System.out.println("Typename:"+p.getTypename());
				System.out.println("Health:"+p.getHealth());
				System.out.println("Love:"+p.getLove());
				System.out.println("Birthday:"+p.getBirthday());
				System.out.println("StoreID:"+p.getStoreid());
			}
			if(ps.isEmpty()){
				System.out.println("No result!");
			}
		}
	}

}
