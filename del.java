package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class del {
		private static final String  DELETE_QUERY="DELETE FROM std WHERE Id=?";

		public static void main(String[] args) {
			
			Scanner scn=new Scanner(System.in);
			//load the jdbc driver
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			//create the connection
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Monish@10")){
			PreparedStatement ps=con.prepareStatement(DELETE_QUERY);{
				System.out.println("enter  the studentid which to delete:");
				int studentid=scn.nextInt();
				
				
				
				//set the values
				ps.setInt(1, studentid);
				
				//execute query
				int count=ps.executeUpdate();
				if(count==0) {
					System.out.println("Record is not deleted");
				}else {
					System.out.println("record is deleted");
				}
			}
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				se.printStackTrace();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				
		
				
			}

		}

}