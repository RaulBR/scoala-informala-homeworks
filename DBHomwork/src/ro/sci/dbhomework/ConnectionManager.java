package ro.sci.dbhomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This class facilitates a connection to a database.
 * 
 */
public class ConnectionManager {
	
	public ConnectionManager() {
		loadDriver();
	}
	/* This method makes a DB connection 
	 * @param type -Type of connection (String)
	 * @param host -host name (String)
	 * @param port 
	 * @param dbName -Data base name (String)
	 * @param pw -DB password (String).
	 * 
	 */
	
	public Connection connect(String type, String host, int port, String dbName, String user, String pw) {
		return coneection(type,host,port,dbName,user,pw);
	}
	private  Connection coneection(String type, String host, int port, String dbName, String user, String pw){
		
	Connection connection = null;
	DriverManager.setLoginTimeout(60);
	String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
			.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=").append(pw)
			.toString();
	try {
		connection = DriverManager.getConnection(url);
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return connection;
}
	private void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
