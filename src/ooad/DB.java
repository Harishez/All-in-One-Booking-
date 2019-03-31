package ooad;
import java.sql.*;
public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad?autoReconnect=true&useSSL=false","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
