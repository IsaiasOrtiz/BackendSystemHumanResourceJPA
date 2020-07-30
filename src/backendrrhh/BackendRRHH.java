/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendrrhh;

import com.bitlab.controller.AreaController;
import com.bitlab.controller.EmpleadoController;
import com.bitlab.entidades.Area;
import com.bitlab.entidades.Empleado;

/**
 *
 * @author elcon
 */
public class BackendRRHH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoController ac=new EmpleadoController();
        Empleado ar=new Empleado();
        for (Empleado a : ac.encontarTodos()) {
            System.out.println(a.getEsId().getEsNombre());
        }
    }
    
}
