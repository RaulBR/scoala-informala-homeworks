package ro.sci.dbhomework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * This class is a abstract class that  makes a conection the database of  type "postgresql" named "eshop"
 * The connection is a local one 
 */
abstract class AbstractModelDaor {
	/*
	 * This protected method retires a DB connection of type Connection.
	 */
	
	protected Connection getDbConnection() {
	
		ConnectionManager conection=new ConnectionManager();
		Connection conn = conection.connect("postgresql", "localhost", 5432, "eshop", "postgres", "serpentina");
		return conn;
	}
	/*
	 * This methosd is a general model of adding or deleting data to the DB.
	 * @param String sqlQuery.
	 */
	protected void addRemoveDara(String sqlQuery){
		PreparedStatement ps = null;
		
		try {
			ps = getDbConnection().prepareStatement(sqlQuery);

			 ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("DB connection problem");
		} finally {
			try {
				finalize();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}

		}

	}
	/*
	 * This method closes the opened db connections.
	 */
	
	protected void finalize() throws Throwable  
	{  
	    try { getDbConnection().close(); } 
	    catch (SQLException e) { 
	        e.printStackTrace();
	    }
	    super.finalize();  
	}  
}
