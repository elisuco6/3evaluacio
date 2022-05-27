package repasoGeneral.repasoGeneral1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost:3306/constructor";
	final private String user = "root";
	final private String passwd = "";
	
	public void insertInfoDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"
							+ "user=" + user + "&password=" + passwd );

		  
		   statement = connect.createStatement();
		   
		   preparedStatement = connect
		       .prepareStatement("insert into infoconstructor(constructorId, constructorRef, name, nationality, url) values (?, ?, ?, ?, ?)");
		   
		   preparedStatement.setInt(1, 1);
		   preparedStatement.setString(2, "Prueba");
		   preparedStatement.setString(3, "Prueba");
		   preparedStatement.setString(4, "Prueba");
		   preparedStatement.setString(5, "Prueba");
		   //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		   preparedStatement.executeUpdate();
		
		   preparedStatement = connect
				   .prepareStatement("SELECT * from infoconstructor");
		   System.out.println("QUERY ---> select * from infoconstructor");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSetInfo(resultSet);
		
		} catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	public void insertStandingsDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"
							+ "user=" + user + "&password=" + passwd );

		  
		   statement = connect.createStatement();
		   
		   preparedStatement = connect
		       .prepareStatement("insert into standingsconstructor(constructorStandingsId, raceId, points, position, wins) values (?, ?, ?, ?, ?)");
		   
		   preparedStatement.setInt(1, 1);
		   preparedStatement.setInt(2, 1);
		   preparedStatement.setInt(3, 1);
		   preparedStatement.setInt(4, 1);
		   preparedStatement.setInt(5, 1);
		   //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		   preparedStatement.executeUpdate();
		
		   preparedStatement = connect
				   .prepareStatement("SELECT * from standingsconstructor");
		   System.out.println("QUERY ---> select * from standingsconstructor");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSetStandings(resultSet);
		
		} catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	private void writeResultSetInfo(ResultSet resultSet) throws SQLException {
		
		while (resultSet.next()) {
			
		   int constructorId = resultSet.getInt(1);
		   String constructorRef= resultSet.getString(2);
		   String name = resultSet.getString(3);
		   String nationality = resultSet.getString(4);
		   String url = resultSet.getString(5);
		   
		   System.out.println("Registration: " + constructorId);
		   System.out.println("Name: " + constructorRef);
		   System.out.println("Type: " + name);
		   System.out.println("Dimensions: " + nationality);
		   System.out.println("Owner NIF: " + url);
		   System.out.println("###################################");
		}
	}
	
private void writeResultSetStandings(ResultSet resultSet) throws SQLException {
		
		while (resultSet.next()) {
		   int constructorStandingsId = resultSet.getInt(1);
		   int raceId= resultSet.getInt(2);
		   int points = resultSet.getInt(3);
		   int position = resultSet.getInt(4);
		   int wins = resultSet.getInt(5);
		   
		   System.out.println("Registration: " + constructorStandingsId);
		   System.out.println("Name: " + raceId);
		   System.out.println("Type: " + points);
		   System.out.println("Dimensions: " + position);
		   System.out.println("Owner NIF: " + wins);
		   System.out.println("###################################");
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}
}
