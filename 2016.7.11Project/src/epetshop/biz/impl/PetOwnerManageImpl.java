package epetshop.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import epetshop.biz.PetOwnerManage;
import epetshop.dao.PetDao;
import epetshop.dao.PetOwnerDao;
import epetshop.dao.impl.PetDaoImpl;
import epetshop.dao.impl.PetOwnerDaoImpl;
import epetshop.entity.Pet;
import epetshop.entity.PetOwner;

public class PetOwnerManageImpl implements PetOwnerManage{

	@Override
	public PetOwner login(PetOwner mas) {
		// TODO Auto-generated method stub
		PetOwner master=null;
		PetOwnerDao petownerdao=new PetOwnerDaoImpl();
		String name=mas.getName();
		String password=mas.getPassword();
		Object[] param={name,password};
		String sql="select * from petowner where name=? and password=?";
		master=petownerdao.selectOwner(sql,param);
		if(master==null){
			System.out.println("Login failed!");
			return null;
		}else{
			System.out.println("Login success!");
			return master;
		}
	}

	@Override
	public List<Pet> getMyPet(int ownerId) {
		// TODO Auto-generated method stub
		List<Pet> ps=new ArrayList();
		PetDao petdao=new PetDaoImpl();
		Object[] param={ownerId};
		String sql="select * from pet where owner_id=?";
		ps=petdao.selectPet(sql, param);
		return ps;
	}
}
