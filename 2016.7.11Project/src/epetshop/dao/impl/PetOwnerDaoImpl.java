package epetshop.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import epetshop.dao.impl.*;
import epetshop.dao.*;
import epetshop.entity.PetOwner;

public class PetOwnerDaoImpl extends BaseDao implements PetOwnerDao{

	@Override
	public List<PetOwner> getAllOwner() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
	    List<PetOwner> ms=new ArrayList();
	    try{
			conn=this.getConnection();
			String sql="select * from petowner";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				PetOwner master=new PetOwner();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
				master.setMoney(rs.getInt("money"));
				ms.add(master);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ms;
	}

	@Override
	public int updateOwner(String sql,Object[] param) {
		// TODO Auto-generated method stub
		int result=this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public PetOwner selectOwner(String sql, Object[] param) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		PetOwner master=null;
		try{
			conn=this.getConnection();
			psmt=conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					psmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			rs=psmt.executeQuery();
			if(rs.next()){
				master=new PetOwner();
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
