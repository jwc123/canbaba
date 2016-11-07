import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBhelper {

	String url;
	String username;
	String passwd;
	static ComboPooledDataSource ds;

	public DBhelper(String url, String username, String passwd) throws PropertyVetoException {
		System.out.println("123");
		this.passwd = passwd;
		this.url = url;
		this.username = username;
		ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		// 设置JDBC的URL
		ds.setJdbcUrl(url);
		// 设置数据库的登入用户名
		ds.setUser(username);
		// 设置数据库的用户密码
		ds.setPassword(passwd);
		// 设置连接池的最大连接数
		ds.setMaxPoolSize(60);
		// 设置连接池的最小连接数
		ds.setMinPoolSize(5);
		// 设置连接池初始连接数
		ds.setInitialPoolSize(20);
		// 设置连接池的缓存Statement的最大数
		ds.setMaxStatements(200);
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection ConnectDb() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, passwd);
		return connection;
	}

	public static synchronized Connection getConnection() throws SQLException {		
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException el) {
			System.out.println("- 异常 - 连接池获取连接出现异常 " + el.toString());
		}
		return con;
	}

}
