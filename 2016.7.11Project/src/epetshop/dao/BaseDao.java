package epetshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	private String driver = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";// ���ݿ������ַ���
	private String url = 
		"jdbc:sqlserver://localhost:1433;DatabaseName=PetShop";// ����URL�ַ���
	private  String user = "user20160711"; // ���ݿ��û���
	private  String password = "961212"; // �û�����
	Connection conn = null;// �������Ӷ���
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public Connection getConnection() {
		if(conn==null){
			// ��ȡ���Ӳ������쳣
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();// �쳣����
			}
		}	
		return conn;// �������Ӷ���
	}
	/**
	 * �ر����ݿ����ӡ�
	 * @param conn ���ݿ�����
	 * @param stmt Statement����
	 * @param rs �����
	 */
	public void closeAll(Connection conn, Statement stmt, 
					ResultSet rs) {
		// �����������Ϊ�գ���ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ�գ���ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����ɾ���ĵĲ���
	 * @param sql Ԥ����� SQL ���          
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int executeUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
