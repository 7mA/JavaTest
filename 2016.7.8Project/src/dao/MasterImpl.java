package dao;
import java.sql.*;
import java.util.*;

import entity.Master;
import entity.Pet;

public class MasterImpl extends BaseDao implements MasterDao{

	@Override
	public Master getByID(Master mas) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Master master=null;
		try{
			conn=this.getConnection();
			String sql="select * from master where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,mas.getId());
			rs=psmt.executeQuery();
			if(rs.next()){
				master=new Master();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
				master.setMoney(rs.getInt("money"));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return master;
	}

	@Override
	public int releasePetFromAdopt(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		Pet p=null;
		int result=0;
		try{
			conn=this.getConnection();
			String sql="delete from adopt where petId=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			result=psmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Integer> findMasterInAdopt(int id) {
		// TODO Auto-generated method stub
		List<Integer> idSet=new ArrayList();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet p=null;
		try{
			conn=this.getConnection();
			String sql="select petId from adopt where masterId=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,id);
			rs=psmt.executeQuery();
			while(rs.next()){
				idSet.add(rs.getInt(id));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return idSet;
	}

	@Override
	public int adopt(Master master, Pet pet) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet p=null;
		try{
			conn=this.getConnection();
			String sql="select * from adopt where petId=?";
			psmt=conn.prepareStatement(sql)	;
			psmt.setInt(1,pet.getId());
			rs=psmt.executeQuery();
			if(rs.next()){
				p=new Pet();
				p.setId(rs.getInt("id"));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		if(p!=null){
			System.out.println("The pet has been adopted!");
			return 0;
		}else{
			String sql="insert into adopt(masterId,petId)values(?,?)";
			Object[] param={master.getId(),pet.getId()};
			int result=this.executeUpdate(sql, param);
			return result;
		}
	}

	@Override
	public int save(Master master) {
		// TODO Auto-generated method stub
		String sql="insert into master(name,password,money)values(?,?,?)";
		Object[] param={master.getName(),master.getPassword(),master.getMoney()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public int del(Master master) {
		// TODO Auto-generated method stub
		String sql="delete from master where id=?";
		Object[] param={master.getId()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public int update(Master master) {
		// TODO Auto-generated method stub
		String sql="update master set name=?,password=?,money=? where id=?";
		Object[] param={master.getName(),master.getPassword(),master.getMoney(),master.getId()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public Master findMaster(Master mas) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Master master=null;
		try{
			conn=this.getConnection();
			String sql="select * from master where name=? and password=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,mas.getName());
			psmt.setString(2, mas.getPassword());
			rs=psmt.executeQuery();
			if(rs.next()){
				master=new Master();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
				master.setMoney(rs.getInt("money"));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return master;
	}
	
}
