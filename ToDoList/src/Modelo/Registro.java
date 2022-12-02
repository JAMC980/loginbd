
package Modelo;

import Conexion.ConexionMysql;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;


public class Registro {
    ConexionMysql con = new ConexionMysql();
    Connection cn=con.conectar();
    
    public void registrarbd(Tarea t){
    try {
        PreparedStatement ps=cn.prepareStatement("INSERT INTO todolist(nombre,prioridad,estado,notas)VALUES(?,?,?,?)");
        ps.setInt(1,t.getPrioridad());
        ps.setString(2,t.getNombre());
        ps.setString(3,t.getEstado());
        ps.setString(4,t.getNotas());
        ps.executeUpdate();
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error al registrar Datos."+e);
}
}
}