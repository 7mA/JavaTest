package epetshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import epetshop.dao.BaseDao;
import epetshop.dao.PetDao;
import epetshop.entity.Pet;
import epetshop.entity.PetOwner;

public class PetDaoImpl extends BaseDao implements PetDao{

	@Override
	public List<Pet> selectPet(String sql,Object[] param) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Pet> ps=new ArrayList();
		try{
			conn=this.getConnection();
			psmt=conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					psmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			} 
			rs=psmt.executeQuery();
			while(rs.next()){
				Pet p=new Pet();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setTypename(rs.getString("typename"));
				p.setHealth(rs.getInt("health"));
				p.setLove(rs.getInt("love"));
				p.setBirthday(rs.getDate("birthday"));
				p.setOwnerid(rs.getInt("owner_id"));
				p.setStoreid(rs.getInt("store_id"));
				ps.add(p);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ps;
	}
		
	
}
