package test;
import entity.*;
import dao.*;
import biz.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("1.Pet Management");
		System.out.println("2.Master Management");
		int i=input.nextInt();
		if(i==1){
			test.doPetManage();
		}else if(i==2){
			test.doMasterManage();
		}else{
			System.out.println("Error Number!");
		}
		/*PetDao petdao=new PetDaoImpl();
		Pet pet=new Pet();
		pet.setId(3);
		int result=petdao.update(pet);
		if(result==1){
			System.out.println("Update success!");
		}else{
			System.out.println("Update error!");
		}
		
		MasterManage m=new MasterManage();
		m.Login();*/
	}
	
	public void doPetManage(){
		PetManage pm=new PetManage();
		Scanner input=new Scanner(System.in);
		List<Pet> pets=new ArrayList();
		pets.addAll(pm.query());
		for(Pet pet:pets){
			pet.show();
			System.out.print("\n");
		}
		System.out.println("1.Add");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exact Search By Name");
		System.out.println("5.Fuzzy Search By Name");
		System.out.println("6.Search By Strain");
		int i=input.nextInt();
		if(i==1){
			System.out.print("Name:");
			String name=input.next();
			System.out.print("Health:");
			int health=input.nextInt();
			System.out.print("Love:");
			int love=input.nextInt();
			System.out.print("Strain:");
			String strain=input.next();
			Pet p=new Pet();
			p.setHealth(health);
			p.setLove(love);
			p.setName(name);
			p.setStrain(strain);
			pm.save(p);
			System.out.println("Add success!");
		}else if(i==2){
			System.out.print("ID:");
			int id=input.nextInt();
			System.out.print("Name:");
			String name=input.next();
			System.out.print("Health:");
			int health=input.nextInt();
			System.out.print("Love:");
			int love=input.nextInt();
			System.out.print("Strain:");
			String strain=input.next();
			Pet p=new Pet();
			p.setId(id);
			p.setHealth(health);
			p.setLove(love);
			p.setName(name);
			p.setStrain(strain);
			int result=pm.update(p);
			if(result==1){
				System.out.println("Update success!");
			}else{
				System.out.println("Update failed!");
			}
		}else if(i==3){
			System.out.print("ID:");
			int id=input.nextInt();
			Pet p=new Pet();
			p.setId(id);
			int result=pm.del(p);
			if(result==1){
				System.out.println("Delete success!");
			}else{
				System.out.println("Delete failed!");
			}
		}else if(i==4){
			System.out.print("Name:");
			String name=input.next();
			Pet p=pm.getByName(name);
			if(p!=null){
				p.show();
			}else{
				System.out.println("No result!");
			}
		}else if(i==5){
			System.out.print("Name:");
			String name=input.next();
			List<Pet> ps=pm.findByName(name);
			for(Pet p:ps){
				p.show();
			}
			if(ps.isEmpty()){
				System.out.println("No result!");
			} 	
		}else if(i==6){
			System.out.print("Strain:");
			String strain=input.next();
			List<Pet> ps=pm.findByStrain(strain);
			for(Pet p:ps){
				p.show();
			}
			if(ps.isEmpty()){
				System.out.println("No result!");
			}
		}else{
			System.out.println("Invalid number!");
		}
		pm.close();
	}
	
	public void doMasterManage(){
		MasterManage m=new MasterManage();
		PetManage pm=new PetManage();
		List<Pet> ps=new ArrayList();
		Scanner input=new Scanner(System.in);
		System.out.print("Username:");
		String name=input.next();
		System.out.print("Password:");
		String password=input.next();
		Master mas=new Master();
		mas.setName(name);
		mas.setPassword(password);
		mas=m.Login(mas);
		if(mas!=null){
			System.out.println("1.Adopt");
			System.out.println("2.Release");
			int i=input.nextInt();
			if(i==1){
				System.out.println("1.Exact Search By Name");
				System.out.println("2.Fuzzy Search By Name");
				System.out.println("3.Search By Strain");
				int j=input.nextInt();
				if(j==1){
					System.out.print("Name:");
					String n=input.next();
					Pet p=pm.getByNameNc(n);
					if(mas.getMoney()>=100 && p!=null){
						if(m.adopt(mas, p)==1){
							System.out.println("Adopt success!");
							mas.setMoney(mas.getMoney()-100);
							m.update(mas);
						}else{
							System.out.println("Adopt failed!");
						}
					}else{
						System.out.println("Adopt failed!");
					}
				}else if(j==2){
					System.out.print("Name:");
					String n=input.next();
					List<Pet> ps2=pm.findByNameNc(n);
					for(Pet p:ps2){
						if(mas.getMoney()>=100 && p!=null){
							if(m.adopt(mas, p)==1){
								System.out.println("Adopt success!");
								mas.setMoney(mas.getMoney()-100);
								m.update(mas);
							}else{
								System.out.println("Adopt failed!");
							}
						}
					}
					if(ps2.isEmpty()){
						System.out.println("Adopt failed!");
					}
				}else if(j==3){
					System.out.print("Strain:");
					String s=input.next();
					List<Pet> ps3=pm.findByStrainNc(s);
					for(Pet p:ps3){
						if(mas.getMoney()>=100 && p!=null){
							if(m.adopt(mas, p)==1){
								System.out.println("Adopt success!");
								mas.setMoney(mas.getMoney()-100);
								m.update(mas);
							}else{
								System.out.println("Adopt failed!");
							}
						}
					}
					if(ps3.isEmpty()){
						System.out.println("Adopt failed!");
					}
				}else{
					System.out.println("Invalid number!");
				}
			}else if(i==2){
				List<Integer> idSet=m.findMasterInAdopt(mas.getId());
				System.out.println("Pet ID:");
				int j=input.nextInt();
				for(int k:idSet){
					if(j==k){
						m.releasePetFromAdopt(j);
						System.out.println("Release success!");
						mas.setMoney(mas.getMoney()+100);
						m.update(mas);
						j=-1;
						break;
					}
				}
				if(j!=-1){
					System.out.println("Release failed!");
				}
			}
			ps=pm.query();
			Master mastemp=new Master();
			for(Pet p:ps){
				p.show();
				int id=pm.findPetInAdopt(p.getId());
				if(id!=0){
					mastemp.setId(id);
					mastemp=m.getByID(mastemp);
					System.out.println("Master:"+mastemp.getName());
					System.out.print("\n");
				}else{
					System.out.println("Master:none");
					System.out.print("\n");
				}
			}
			pm.close();
		}
	}

}
