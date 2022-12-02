
package Conexion;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionMysql {
    Connection cn;
    
    public Connection conectar(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","");
        System.out.println("Conexion exitosa");
    }catch(ClassNotFoundException | SQLException e){
        System.out.println("Error de conexion"+e);
    }
    return cn;
    }
}
