package biz;
import entity.*;
import dao.*;

import java.util.*;

public class MasterManage {
	public Master master=null;
	public Master Login(Master mas){
		MasterDao masterdao=new MasterImpl();
		master=masterdao.findMaster(mas);
		if(master==null){
			System.out.println("Login failed!");
			return null;
		}else{
			System.out.println("Login success!");
			return master;
		}
	}
	
	MasterDao masterdao=new MasterImpl();
	
	public int save(Master master){
		return masterdao.save(master);
	}
	
	public int del(Master master){
		return masterdao.del(master);
	}
	
	public Master getByName(Master master){
		return masterdao.findMaster(master);
	}
	
	public int update(Master master){
		return masterdao.update(master);
	}
	
	public int adopt(Master master, Pet pet){
		return masterdao.adopt(master, pet);
	}
	
	public List<Integer> findMasterInAdopt(int id){
		return masterdao.findMasterInAdopt(id);
	}
	
	public int releasePetFromAdopt(int id){
		return masterdao.releasePetFromAdopt(id);
	}
	
	public Master getByID(Master mas){
		return masterdao.getByID(mas);
	}
}
