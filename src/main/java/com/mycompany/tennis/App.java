package com.mycompany.tennis;

import java.sql.*;

public class App 
{
    public static void main(String... args){
        Connection conn = null;
        try {
            // MySQL driver MySQL Connector
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false","root","root");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT NOM, PRENOM, ID FROM JOUEUR");
            while(rs.next()) {
                final String nom = rs.getString("NOM");
                final String prenom = rs.getString("PRENOM");
                final Long id = rs.getLong("ID");
                System.out.println(id + " : " + prenom + " " + nom);
            }
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
