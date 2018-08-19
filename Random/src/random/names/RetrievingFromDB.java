package random.names;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetrievingFromDB {
	public static void main(String[] args) {
		System.out.println(retrieveFromDataBase());
	}
	public static String retrieveFromDataBase()
	{
		 Connection con=null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 String dbUrl="jdbc:mysql://localhost:3306/people"
					+ "?user=root&password=root";
		 ArrayList<String> names=new ArrayList<String>();
		 String name="";
				try {
					
					con = DriverManager.getConnection(dbUrl);
					String sql="Select name from people_db";
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						names.add(rs.getString(1));
					}
					
					int index=(int)(Math.random()*names.size());
					
					name=names.get(index);
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					/*
					 * 5. Close all the JDBC Objects
					 */

					if(con != null){
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(stmt != null){
						try {
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					

				}
				return name;
	}

}
