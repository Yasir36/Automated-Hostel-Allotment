package com.aha.dbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;
    private DBConnection(){}
    public static Connection getConnection()
    {
        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedhostelallotment", "root", "root");
            } catch (Exception ex) {
                System.out.println("exception in connection get "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return con;
    }	
}
