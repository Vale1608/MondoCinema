package cinema.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConnectionDatabase {

	    public static Connection getConnection() {

	        //STEP 1: Register JDBC driver
	        Connection connection = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            //STEP 2: Open a connection
	            System.out.println("Connecting to database...");
	            //controllare dentro l'interno
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/esercizio?serverTimezone=Europe/Rome",
	                    "root",
	                    "Glorietta1993");
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return connection;


	    }

	}

