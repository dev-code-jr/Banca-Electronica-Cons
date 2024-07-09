package org.chamale.chanquin.dao;
import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author Edwar René Chamalé González - 2022222
 * @author Jose Rodrigo Chanquín Mac - 2022240
 * 
 */
public class Conexion {
    private Connection conexion;
    private static Conexion instancia;
    
    private Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/BancaElectronica?useSSL=false",
                        "root",
                        "m7zhktr7");
        } catch(ClassNotFoundException | SQLException |
                InstantiationException | IllegalAccessException e){
                e.getMessage();
        }
    }
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
}
