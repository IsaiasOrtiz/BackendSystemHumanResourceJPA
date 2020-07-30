/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class FabricaConexion {
    private EntityManagerFactory fabrica;
    private static FabricaConexion instancia=new FabricaConexion();
    /**
     * Creando el constructor privado para poder hacer uso de la 
     * conexion como un singleton
     */
    private FabricaConexion()
    {
        fabrica=Persistence.createEntityManagerFactory("BackendRRHHPU");
    }
    /**
     * Retorna el manejador de entidades.
     * @return 
     */
    public EntityManagerFactory getFabrica() {
        return fabrica;
    }
    /**
     * Optenemos la instancia singleton.
     * @return 
     */
    public static FabricaConexion getInstancia() {
        return instancia;
    }
            
}
