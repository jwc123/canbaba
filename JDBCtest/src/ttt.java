import static org.junit.Assert.*;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ttt {

	static String url="jdbc:mysql://localhost:3306/jdbc";
	static String user="root";
	static String passwd="root";
	@Test
	public void testConnectDb() throws PropertyVetoException, SQLException {
		//fail("Not yet implemented");
	     DBhelper aBhelper=new DBhelper(url,user,passwd);
         //Connection connection=aBhelper.ConnectDb();
       Connection connection=aBhelper.ConnectDb();

	}

	@Test
	public void testGetConnection() throws PropertyVetoException, SQLException {
		//fail("Not yet implemented");
		   DBhelper bBhelper=new DBhelper(url,user,passwd);
	       Connection connection=bBhelper.getConnection();

	}

}
