/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controlador.Controlador_Frm_RegistrarTarea;
import Vista.frm_RegistrarTarea;

public class Principal {
    public static frm_RegistrarTarea frm_rt;
    public static Controlador.Controlador_Frm_RegistrarTarea c_frm_rt;
    
    public static void main(String[] args) {

    frm_rt=new frm_RegistrarTarea();
    frm_rt.setVisible(true);
    frm_rt.setLocationRelativeTo(null);
    c_frm_rt=new Controlador_Frm_RegistrarTarea(frm_rt);
    }
    
}
