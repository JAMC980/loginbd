/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos_sql;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author USER
 * 
 */
public class ConexionBD {
    public static String url = "jdbc:mysql://localhost/login_bd";
    public static String usuario = "root";
    public static String contraseña = "root";
    public static String clase = "com.mysql.jdbc.Driver";
    
    public static Connection conectar(){
        Connection conexion = null;
        
       try{
           Class.forName(clase);
           conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
           System.out.println("Conexion establecida.");
       }catch (ClassNotFoundException e){
          System.out.println(e);  
       } 
       return conexion;
    }
}
