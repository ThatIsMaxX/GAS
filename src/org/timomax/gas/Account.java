package org.timomax.gas;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.mysql.jdbc.PreparedStatement;


public class Account {
	  private static Connection conn = null;
	  private static SecureRandom random = null;
	  
	  private Account() {
		    try {
		    String dbHost = "84.200.206.229";
		    String dbName = "GAS";
		    String dbUser = "GAS";
		    String dbPassword = "uzrqO8bM0SjqYZM4";
		    String dbPassworda = "Kanino0057";
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
			          + "3306" + "/" + dbName + "?" + "user=" + dbUser + "&"
			          + "password=" + dbPassword);
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
	public static boolean Register(String username, String email, String password){
		conn = getInstance();
		if(conn != null){
			Statement rS;
			Statement cfV;
			try {
				cfV = conn.createStatement();
				String checkForValues = "SELECT * from users";
				ResultSet cfVResult = cfV.executeQuery(checkForValues);
				while(cfVResult.next()){
					if(username.equalsIgnoreCase(cfVResult.getString("username")) || email.equalsIgnoreCase(cfVResult.getString("email"))){
						return false;
					}
				}

			    byte[] saltb = new byte[128 / 8];
			    random.nextBytes(saltb);
				Base64.Encoder enc = Base64.getEncoder();
				String salts = enc.encodeToString(saltb);
				String sql = "INSERT INTO users(username, email, password, salt) VALUES (?, ?, ?, ?)";
				java.sql.PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, HashPassword(password, salts));
				ps.setString(4, salts);
				ps.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean CheckLogin(String username, String password){
	    conn = getInstance();
	    if(conn != null)
	    {
	    	Statement clS;
	        try {

	        clS = conn.createStatement();
	        String sql = "SELECT username, password, salt FROM users WHERE username = '"+username+"'";
	 	    ResultSet result = clS.executeQuery(sql);
	 	    while(result.next()){
	 	    	if(result.getString("password").equals(HashPassword(password, result.getString("salt")))){
		 	    	return true;
	 	    	}
	 	    }
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		return false;
		
	}
	private static String HashPassword(String pw, String salts){
		byte[] salt = salts.getBytes();
		KeySpec spec = new PBEKeySpec(pw.toCharArray(), salt, 65536, 128);
		SecretKeyFactory f;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash  = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			return enc.encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
