package org.timomax.gas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
	  private static Connection conn = null;
	  private Account() {
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://84.200.206.229:3306/GAS?user=root&password=Kanino0057");
		    } catch (ClassNotFoundException e) {
		      System.out.println("Treiber nicht gefunden");
		      System.exit(0);
		    } catch (SQLException e) {
		      System.out.println(e);
		      System.out.println("Connect nicht moeglich");
		      System.exit(0);
		    }
		  }
		 
		  private static Connection getInstance()

		  
		  {
		    if(conn == null)
		      new Account();
		    return conn;
		  }
	public static boolean CheckLogin(String username, String password){
	    conn = getInstance();
	    String passwordHash = null;
	    if(conn != null)
	    {
	    	Statement getImageInfo;
	        try {

	        getImageInfo = conn.createStatement();
	        String getImageInfosql = "SELECT username, password FROM users WHERE username = '"+username+"'";
	 	    ResultSet result = getImageInfo.executeQuery(getImageInfosql);
	 	    while(result.next()){
	 	    	if(result.getString("password").equals(passwordHash)){
		 	    	return true;
	 	    	}
	 	    }
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		return false;
		
	}

}
