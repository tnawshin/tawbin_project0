package com.revature.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	
	/*
	 * Connections are a vital tool in JDBC
	 * We use the ConnectionFactory to establish a connection 
	 * with the database
	 * 
	 * This will use a lazy singleton design pattern to 
	 * return the same single connectionfactory instance
	 * each time one is requested so that we can monitor
	 * the amount of connections that our connectionfactory 
	 * generates 
	 * 
	 * In order to establish a connection, we need four things - 
	 * Driver, DB location (URL), DB username, db password 
	 */

	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {	
	}
	
	public static synchronized ConnectionFactory getInstance() {
			if(cf == null) cf = new ConnectionFactory();
			return cf;
	}
	
	/*
	 * Connection - one of the core interfaces in the JDBC API
	 * - manages our connection to (session with) the database
	 * - allows us to execute SQL statements and return results 
	 * - has information about DB tables, stored procedures, and 
	 * all other related db objects. 
	 */
	public Connection getConnection() {
		Connection conn = null;
		//Properties prop = new Properties();
		//String path = "ers/classes/database.properties";
		
			try {
				//prop.load(new FileReader(path));
				//the following line of code uses reflection and the 
				// .properties file in order to instantiate our driver
				//  class listed in the file
				Class.forName("oracle.jdbc.driver.OracleDriver");
				/*
				 * The DriverManager provides a basic service for 
				 * managing a set of JDBC drivers. As part of its 
				 * initialization, the DriverManager class will 
				 * attempt to load the driver class referenced previously
				 */
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@ersdb.cj15fv7pibeg.us-east-2.rds.amazonaws.com:1521/ORCL", 
						"ERSDB1", 
						"password123");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
	}

}