package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//step1 load the driver
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		int i;
		System.out.println("***************");
		System.out.println("  1.Register   ");
		System.out.println("  2.Login      ");
		System.out.println("***************");
		Scanner input=new Scanner(System.in);
		i=input.nextInt();
		if(i==1){
			//step2 build connection
			try{
				conn=DriverManager.getConnection
						("jdbc:sqlserver://localhost:1433;DatabaseName=studb","Guo","961212");
				System.out.println("Connection success!");
				System.out.print("Name:");
				String name=input.next();
				System.out.print("Password:");
				String pwd=input.next();
				System.out.print("Class:");
				String stuclass=input.next();
				System.out.print("Age:");
				int age=input.nextInt();
				System.out.print("Gender:");
				String gender=input.next();
				StringBuffer sql=new StringBuffer
						("insert into stuinfo(stuname,stupwd,stuclass,stuage,stuGender)"
								+ "values('");
				sql.append(name+"',");
				sql.append("'"+pwd+"',");
				sql.append("'"+stuclass+"',");
				sql.append(age+",");
				sql.append("'"+gender+"')");
				/*StringBuffer sql=new StringBuffer
					("update stuinfo set stupwd='654321' where id=1");*/
				/*StringBuffer sql=new StringBuffer
					("delete from stuinfo where id=1");*/
				stmt=conn.createStatement();	
				stmt.execute(sql.toString());
				/*rs=stmt.executeQuery("select * from stuinfo");
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+"¡¡"
							+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
				}*/
				System.out.println("Register success!");
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				/*if(rs!=null){
					rs.close();
				}*/
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		}else if(i==2){
			//step2 build connection
			try{
				conn=DriverManager.getConnection
						("jdbc:sqlserver://localhost:1433;DatabaseName=studb","Guo","961212");
				System.out.println("Connection success!");
				System.out.print("Name:");
				String name=input.next();
				System.out.print("Password:");
				String pwd=input.next();
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select * from stuinfo");
				while(rs.next()){
					if(rs.getString(2).equals(name) && rs.getString(3).equals(pwd)){
						i=0;
						System.out.println("Login success!");
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+"¡¡"
								+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
						break;
					}
				}
				if(i!=0){
					System.out.println("Wrong name or password!");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				/*if(rs!=null){
					rs.close();
				}*/
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		}else{
			System.out.println("Wrong number!");
		}
	}
	
}	
