package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class Conection {

	public static Connection getConnection() {
		Connection connection = null;
		String databaseName = "ElectronDB";
		String user = "sys";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String connectionString = "jdbc:oracle:thin:@localhost:1521:ElectronDB ","sys",
//					"1234" + password + ";";
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ElectronDB ","sys",
					"1234");
		} catch (Exception ex) {

		}

		return connection;
	}
}
