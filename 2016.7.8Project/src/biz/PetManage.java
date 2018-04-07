package biz;
import entity.*;
import dao.*;

import java.util.*;


public class PetManage {
	PetDao petdao=new PetDaoImpl();
	
	public int save(Pet pet){
		return petdao.save(pet);
	}
	
	public int del(Pet pet){
		return petdao.del(pet);
	}
	
	public Pet getByName(String name){
		return petdao.getByName(name);
	}
	
	public List<Pet> findByName(String name){
		return petdao.findByName(name);
	}
	
	public List<Pet> findByStrain(String strain){
		return petdao.findByStrain(strain);
	}
	
	public int update(Pet pet){
		return petdao.update(pet);
	}
	
	public List<Pet> query(){
		return petdao.query();
	}
	
	public Pet getByNameNc(String name){
		return petdao.getByNameNc(name);
	}
	
	public List<Pet> findByNameNc(String name){
		return petdao.findByNameNc(name);
	}
	
	public List<Pet> findByStrainNc(String strain){
		return petdao.findByStrainNc(strain);
	}
	
	public int findPetInAdopt(int id){
		return petdao.findPetInAdopt(id);
	}
	
	public void close(){
		petdao.close();
	}
}
