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
		// ����JDBC��URL
		ds.setJdbcUrl(url);
		// �������ݿ�ĵ����û���
		ds.setUser(username);
		// �������ݿ���û�����
		ds.setPassword(passwd);
		// �������ӳص����������
		ds.setMaxPoolSize(60);
		// �������ӳص���С������
		ds.setMinPoolSize(5);
		// �������ӳس�ʼ������
		ds.setInitialPoolSize(20);
		// �������ӳصĻ���Statement�������
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
			System.out.println("- �쳣 - ���ӳػ�ȡ���ӳ����쳣 " + el.toString());
		}
		return con;
	}

}
