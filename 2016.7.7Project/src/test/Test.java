package test;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			conn=DriverManager.getConnection
					("jdbc:sqlserver://localhost:1433;databasename=myschool","Guo","961212");
			System.out.println("Connection success!");
			Scanner input=new Scanner(System.in);
			System.out.print("Student No.:");
			int id=input.nextInt();
			System.out.print("Password:");
			String pwd=input.next();
			System.out.print("Name:");
			String name=input.next();
			System.out.print("Sex:");
			String sex=input.next();
			System.out.print("Grade ID:");
			int gradeid=input.nextInt();
			System.out.print("Phone:");
			String phone=input.next();
			System.out.print("Address:");
			String address=input.next();
			System.out.print("Born Date:");
			String borndate=input.next();
			java.sql.Date time =java.sql.Date.valueOf(borndate);
			System.out.print("E-mail:");
			String email=input.next();
			//stmt=conn.createStatement();
			pstmt=conn.prepareStatement("insert into student(StudentNo,LoginPwd,StudentName,Sex,GradeId,Phone,Address,BornDate,Email)"
					+ "values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2,pwd);
			pstmt.setString(3,name);
			pstmt.setString(4,sex);
			pstmt.setInt(5,gradeid);
			pstmt.setString(6,phone);
			pstmt.setString(7,address);
			pstmt.setDate(8,time);
			pstmt.setString(9,email);
			pstmt.execute();
			System.out.println("Register success!");
			/*rs=pstmt.executeQuery();
			if(rs.next()){
				System.out.println("Login success!");
			}else{
				System.out.println("Login failed!");
			}*/
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException ex){
				System.out.println(ex);
			}
		}
	}

}
