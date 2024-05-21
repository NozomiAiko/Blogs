package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static public String driver="com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3309/db_blog";
    static public String usuario = "root";
    static public String password = "";
    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            try {
                conn= DriverManager.getConnection(url,usuario,password);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
               
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        System.out.println("CERRANDO CONEXION");
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DESCONECTAR"+ ex.getMessage());
        }
    }

}
