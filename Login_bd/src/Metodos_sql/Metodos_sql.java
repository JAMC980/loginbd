/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos_sql;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Metodos_sql {

    public static ConexionBD conexion = new ConexionBD();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public int guardar(String nombre, String apellidos, String correo, String contraseña) throws IOException {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO usuarios(nombre,apellidos,correo,contraseña)Values (?,?,?,?)");
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion(sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, correo);
            sentencia_preparada.setString(4, contraseña);

            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            conexion.close();
        } catch (SQLException e){

            System.out.println(e);

        }
        return resultado;
        }

    private PreparedStatement conexion(String sentencia_guardar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String buscarNombre(String correo){

    String busqueda_nombre = null;
        Connection conexion = null;
    try{
        conexion = ConexionBD.conectar();
        String sentencia_buscar = ("SELECT nombre,apelllidos FROM usuarios WHERE correo = '"+correo+"'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
        resultado = sentencia_preparada.executeQuery();
        if(resultado.next()){
            String nombre = resultado.getString("nombre");
            String apellidos = resultado.getString("apellidos");
            busqueda_nombre = (nombre +" "+ apellidos);
        }
        conexion.close();
    }catch(IOException | SQLException e){
        System.out.println(e);
    }
    return busqueda_nombre;
    }
    public static String buscarUsuarioRegistrado(String correo, String contraseña){
        String busqueda_usuario = null;
        Connection conexion = null;
        try{
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario = ("SELECT nombre,correo,contraseña FROM usuarios WHERE correo ='"+correo+"' && contraseña = '"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_usuario = "usuario encontrado.";
            }else{
                busqueda_usuario = "usuario no encontrado.";
            }
            conexion.close();
        }catch(SQLException e){
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return busqueda_usuario;
    }
}