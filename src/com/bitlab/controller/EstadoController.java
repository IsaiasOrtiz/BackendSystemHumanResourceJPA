/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controller;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Estado;
import javax.persistence.EntityManager;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EstadoController extends AbstractController<Estado>{

    public EstadoController() {
        super(Estado.class);
    }

    @Override
    protected EntityManager manejadorEntidades() {
       return FabricaConexion.getInstancia().getFabrica().createEntityManager();
    }
    
}
