package org.timomax.gas;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Account {
	  private static Connection conn = null;
	  public static final String ID = "$31$";
	  public static final int DEFAULT_COST = 16;
	  private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
	  private static final int SIZE = 128;
	  private static final Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");
	  private final SecureRandom random = null;
	  private final int cost = 0;
	  
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
	    String passwordHash = HashPassword(password);
	    if(conn != null)
	    {
	    	Statement getImageInfo;
	        try {

	        getImageInfo = conn.createStatement();
	        String sql = "SELECT username, password FROM users WHERE username = '"+username+"'";
	 	    ResultSet result = getImageInfo.executeQuery(sql);
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
	private static String HashPassword(String pw){
		String hash = null;
		return hash;
	}
	
}
