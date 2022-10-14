package com.mycompany.tennis;

import java.sql.*;

public class App 
{
    public static void main(String... args){
        Connection conn = null;
        try {
            // MySQL driver MySQL Connector
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false","root","root");
            conn.setAutoCommit(false);
            //Statement statement = conn.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT NOM, PRENOM, ID FROM JOUEUR WHERE ID=15");
            //PreparedStatement preparedStatement = conn.prepareStatement("SELECT NOM, PRENOM, ID FROM JOUEUR WHERE ID=?");
            //preparedStatement.setLong(1, 14);
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE JOUEUR SET  NOM=?, PRENOM=? WHERE ID=?");
            preparedStatement.setString(1,"Errani");
            preparedStatement.setString(2, "Sara");
            preparedStatement.setLong(3, 24);
            //ResultSet rs = preparedStatement.executeQuery();
            int nbResult = preparedStatement.executeUpdate();
            conn.commit();
            /*if(rs.next()) {
                final String nom = rs.getString("NOM");
                final String prenom = rs.getString("PRENOM");
                final Long id = rs.getLong("ID");
                System.out.println(id + " : " + prenom + " " + nom);
            }*/
            System.out.println("nbResult: " + nbResult);
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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
