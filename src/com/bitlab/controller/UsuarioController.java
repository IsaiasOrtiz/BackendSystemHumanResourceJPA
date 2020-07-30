/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controller;

import com.bitlab.conexion.FabricaConexion;
import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.Encriptacion;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class UsuarioController extends AbstractController<Usuario> {

    public UsuarioController() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager manejadorEntidades() {
        return FabricaConexion.getInstancia().getFabrica().createEntityManager();
    }

   /**
    * retorna null si el usuario o clave no coinciden, 
    * en caso de un usuario valido retorna el objeto
    * usuario.
    * @param usuario
    * @param clave
    * @return 
    */
    public Usuario loginUsuario(String usuario, String clave) {
        Usuario us = null;
        String jpql = "SELECT c FROM Usuario c WHERE c.usUsuario = :user";
        Query q = manejadorEntidades().createQuery(usuario, Usuario.class);
        q.setParameter("user", usuario);
        us = (Usuario) q.getSingleResult();
        if (us != null) {
            Encriptacion en = new Encriptacion();
            if (clave.equals(en.getTextDesencriptado(us.getUsClave()))) {
                return us;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
