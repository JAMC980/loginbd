/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ListarTareas;
import Modelo.Registro;
import Modelo.Tarea;
import Vista.frm_RegistrarTarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_Frm_RegistrarTarea implements ActionListener {
    frm_RegistrarTarea frm_rt;

    public Controlador_Frm_RegistrarTarea(frm_RegistrarTarea frm_rt) {
        this.frm_rt = frm_rt;
        this.frm_rt.btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==frm_rt.btnGuardar){
           String nombre=frm_rt.txtTarea.getText();
           int cantidad=Integer.parseInt(frm_rt.txtEstado.getText());
           Double estado=Double.parseDouble(frm_rt.txtEstado.getText());
           
           Tarea n=new Tarea();
           Registro R=new Registro();
           R.registrarbd(n);
           Listartareas lt=new Listartareas();
           
           limpiarentradas();
           
           
       }
    }

    private void limpiarentradas() {
        frm_rt.txtTarea.setText("");
        frm_rt.txtEstado.setText("");
        frm_rt.txtNotas.setText("");
    }
    
}
