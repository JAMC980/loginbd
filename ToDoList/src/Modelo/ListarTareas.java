
package Modelo;

import Conexion.ConexionMysql;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;




public class ListarTareas {
    ConexionMysql con=new ConexionMysql();
    Connection cn=con.conectar();
    
    public void MostrarTabla(JTable tabla){
    DefaultTableModel modelo=new DefaultTableModel();
    modelo.addColumn("Prioridad");
    modelo.addColumn("Nombre");
    modelo.addColumn("Estado de la tarea");
    modelo.addColumn("Notas");
    String consultasql="SELECT FROM todolist";
    Statement st;
    try{
        st=cn.createStatement();
        ResultSet rs=st.executeQuery(consultasql);
       
        while(rs.next()){
            Object [] lista =(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            modelo.addRow(lista);
    }
        tabla.setModel(modelo);
    }catch(SQLException e){
        System.out.println("Error al enlistar los datos."+e);
    }
}
    
}
