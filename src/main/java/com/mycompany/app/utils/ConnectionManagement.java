package com.mycompany.app.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagement {

    Connection connection = null;

    private static ConnectionManagement INSTANCE;

    private ConnectionManagement(){

        Properties prop = new Properties();
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            System.out.println("Prenom: " + prop.getProperty("personnalinfos.prenom"));

             Class.forName("com.mysql.cj.jdbc.Driver");
             String strconn = "jdbc:mysql://" + prop.getProperty("mysql.url")+ ":"
                     + prop.getProperty("mysql.port")+ "/" + prop.getProperty("mysql.dbname")
                     + "?user=" + prop.getProperty("mysql.username")
                     + "&password="+prop.getProperty("mysql.password");
             System.out.println(strconn);
             this.connection = DriverManager.getConnection(strconn);
        } catch (SQLException e) {
            System.out.println("Probleme SQL");
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("Désolé, mais le fichier est introuvable");
        } catch (ClassNotFoundException e) {
            System.out.println("Probleme Driver");

        }
    }

    public static ConnectionManagement getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ConnectionManagement();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try {
            if(connection != null && !connection.isClosed())
                this.connection.close();
        } catch (SQLException e) {
            System.out.println("ERREUR SYSTEM");
        }finally {
            connection = null;
            INSTANCE = null;
        }
    }
}
