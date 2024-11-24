package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class upd {

		private static final String UPDATE_Query="UPDATE  std SET Name=?WHERE Id=?";
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scn=new Scanner(System.in);
			//load the jdbc driver
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			//create the connection
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Monish@10")){
			PreparedStatement ps=con.prepareStatement(UPDATE_Query);{
				System.out.println("enter studentid:");
				int studentid=scn.nextInt();
				System.out.println("Enter  updation sname");
				String sname=scn.next();
				
				
				//set the values
				ps.setString(1, sname);
				ps.setInt(2, studentid);
				
				//execute query
				int count=ps.executeUpdate();
				if(count==0) {
					System.out.println("Record is not updated");
				}else {
					System.out.println("record is updated");
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