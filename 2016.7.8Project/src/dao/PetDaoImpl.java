package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Master;
import entity.Pet;

public class PetDaoImpl extends BaseDao implements PetDao{
	@Override
	public int findPetInAdopt(int id) {
		// TODO Auto-generated method stub
		int i=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet p=null;
		try{
			conn=this.getConnection();
			String sql="select masterId from adopt where petId=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,id);
			rs=psmt.executeQuery();
			if(rs.next()){
				i=rs.getInt("masterId");
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return i;
	}

	@Override
	public Pet getByNameNc(String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,name);
			rs=psmt.executeQuery();
			System.out.println("I'm finding the dog!");
			if(rs.next()){
				pet=new Pet();
				pet.setName(name);
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(rs.getString("strain"));
				System.out.println("I have found the dog!");	 	
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return pet;
	}

	@Override
	public List<Pet> findByNameNc(String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> pets=new ArrayList();
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where name like '%'+?+'%'";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,name);
			rs=psmt.executeQuery();
			while(rs.next()){
				pet=new Pet();
				pet.setName(rs.getString("name"));
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(rs.getString("strain"));
				pets.add(pet);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return pets;
	}

	@Override
	public List<Pet> findByStrainNc(String strain) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> pets=new ArrayList();
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where strain=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,strain);
			rs=psmt.executeQuery();
			while(rs.next()){
				pet=new Pet();
				pet.setName(rs.getString("name"));
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(strain);
				pets.add(pet);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return pets;
	}

	@Override
	public int save(Pet pet) {
		// TODO Auto-generated method stub
		String sql="insert into dog(name,health,love,strain)values(?,?,?,?)";
		Object[] param={pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public int del(Pet pet) {
		// TODO Auto-generated method stub
		if(findPetInAdopt(pet.getId())==0){
			String sql="delete from dog where id=?";
			Object[] param={pet.getId()};
			int result=this.executeUpdate(sql, param);
			return result;
		}else{
			return 0;
		}
	}

	@Override
	public Pet getByName(String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,name);
			rs=psmt.executeQuery();
			if(rs.next()){
				pet=new Pet();
				pet.setName(name);
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(rs.getString("strain"));	
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn, psmt, rs);
		}
		return pet;
	}

	@Override
	public List<Pet> findByName(String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> pets=new ArrayList();
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where name like '%'+?+'%'";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,name);
			rs=psmt.executeQuery();
			while(rs.next()){
				pet=new Pet();
				pet.setName(rs.getString("name"));
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(rs.getString("strain"));
				pets.add(pet);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn, psmt, rs);
		}
		return pets;
	}

	@Override
	public List<Pet> findByStrain(String strain) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> pets=new ArrayList();
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog where strain=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,strain);
			rs=psmt.executeQuery();
			while(rs.next()){
				pet=new Pet();
				pet.setName(rs.getString("name"));
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(strain);
				pets.add(pet);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn, psmt, rs);
		}
		return pets;
	}

	public int update(Pet pet){
		String sql="update dog set name=?,health=?,love=?,strain=? where id=?";
		Object[] param={pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain(),pet.getId()};
		int result=this.executeUpdate(sql, param);
		return result;
	}

	public List<Pet> query(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> pets=new ArrayList();
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="select * from dog";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				pet=new Pet();
				pet.setName(rs.getString("name"));
				pet.setId(rs.getInt("id"));
				pet.setHealth(rs.getInt("health"));
				pet.setLove(rs.getInt("love"));
				pet.setStrain(rs.getString("strain"));
				pets.add(pet);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return pets;
	}
	
	public void close(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Pet pet=null;
		try{
			conn=this.getConnection();
			String sql="";
			psmt=conn.prepareStatement(sql);
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn, psmt, rs);
		}
	}
}

