/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controller;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Sucursal;
import javax.persistence.EntityManager;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SucursalController extends AbstractController<Sucursal>{

    public SucursalController() {
        super(Sucursal.class);
    }

    @Override
    protected EntityManager manejadorEntidades() {
        return FabricaConexion.getInstancia().getFabrica().createEntityManager();
    }
    
}
