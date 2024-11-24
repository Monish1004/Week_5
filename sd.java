package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class sd {

	private static final String Insert_Query="INSERT INTO std (Id,Name,Address) VALUES(?,?,?)";
		public static void main(String[] args)   {
			Scanner scn=new Scanner(System.in);

			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			//create the connection
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Monish@10")){
			PreparedStatement ps=con.prepareStatement(Insert_Query);{
				System.out.println("enter id:");
				int id=scn.nextInt();
				System.out.println("Enter name");
				String nme=scn.next();
				System.out.println("Enter add");
				String add=scn.next();
				
				
				//set the values
				ps.setInt(1, id);
				ps.setString(2, nme);
				ps.setString(3, add);
				//execute query
				int count=ps.executeUpdate();
				if(count==0) {
					System.out.println("Record is not registered");
				}else {
					System.out.println("record is registered");
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