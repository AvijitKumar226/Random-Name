package random.names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreNameToDB {
 
	public static void main(String[] args) throws Exception {
		storeName();
		
	}
	public static  void storeName() throws Exception {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 
		File file=new File("F:/Db_name/names.txt");
		FileReader in=new FileReader(file);
		BufferedReader reader=new BufferedReader(in);
		String name="";
		ArrayList<String> names=new ArrayList<String>();
		while((name=reader.readLine())!=null)
		{
			names.add(name);
		}
		reader.close();
		try {
		String dbUrl="jdbc:mysql://localhost:3306/people"
			+ "?user=root&password=root";
		con = DriverManager.getConnection(dbUrl);
		String sql="insert into people_db values(?,?) ";
		pstmt=con.prepareStatement(sql);
		
		int id=1;
		for(int i=0;i<names.size();i++) {
			pstmt.setInt(1, id);
			pstmt.setString(2,names.get(i));
			
			pstmt.addBatch();
			
			id++;
		}
		int[] ind=pstmt.executeBatch();
		for (int i : ind) {
			System.out.println("Effected row"+i);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
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
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

		}
		
	}

}
