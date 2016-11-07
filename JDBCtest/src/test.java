import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	static String url="jdbc:mysql://localhost:3306/jdbc";
	static String user="root";
	static String passwd="root";
	public static void main(String[] args) throws SQLException, PropertyVetoException {
	       DBhelper aBhelper=new DBhelper(url,user,passwd);
	         //Connection connection=aBhelper.ConnectDb();
	       Connection connection=aBhelper.getConnection();
	       
	       System.out.println();
	         ResultSet set=connection.prepareStatement("select * from client_info").executeQuery();
	         while (set.next()) {
	        	  System.out.println(set.getString("e"));				
			}	 
	         add(connection, 6, 66);
	         
	}
	
	public static void add(Connection connection,int i,int j)
	{
		try {
			//connection.prepareStatement("insert into client_info(d,e) values ('"+i+"','"+j+"')").execute();
			connection.prepareStatement("insert into client_info(d,e) values ('"+i+"','"+j+"')").execute();
			PreparedStatement updateSales = connection.prepareStatement("insert into client_info(d,e) values (?,?); ");
			updateSales.setInt(1, 1);
			updateSales.setInt(3, 4);
			updateSales.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
