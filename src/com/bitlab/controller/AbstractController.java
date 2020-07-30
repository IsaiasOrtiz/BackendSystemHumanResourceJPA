/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public abstract class AbstractController<T> {

    private final String CREAR = "crear";
    private final String EDITAR = "editar";
    private final String DESTRUIR = "destruir";
    
    public Class<T> entityClass;

    public AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     * Crea la entidad que es recibida como parametro.
     * @param entidad 
     */
    public void crear(T entidad) {
        opciones(CREAR, entidad);
    }
    /**
     * Edita la entidad que recibe como parametro
     * aunque si no existe tambien la crea.
     * @param entidad 
     */
    public void editar(T entidad) {
        opciones(EDITAR, entidad);
    }
    /**
     * Elimina la entidad recibida.
     * @param entidad 
     */
    public void destruir(T entidad) {
        opciones(DESTRUIR, entidad);
    }
    /**
     * Creacion del metodo el cual recibe una accion y una entidad
     * la cual para no repetir el codigo fue creada de esta manera.
     * tiene las opciones de crear, editar, destruit una entidad.
     * @param ACCION
     * @param entidad 
     */
    public void opciones(final String ACCION, T entidad) {
        EntityManager en = manejadorEntidades();
        try {
            en.getTransaction().begin();
            switch (ACCION) {
                case CREAR:
                    en.persist(entidad);
                    break;
                case EDITAR:
                    en.merge(entidad);
                    break;
                case DESTRUIR:
                    en.remove(entidad);
                    break;
                default:
                    throw new IllegalArgumentException("Opcion no encontrada.");
            }
            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            if (en.isOpen()) {
                en.close();
            }
        }
    }
     public List<T> encontarTodos() {

        return encontarTodos(true, -1, -1);

    }
    public List<T> encontarTodos(int maxResult, int firstResult) {

        return encontarTodos(false, maxResult, firstResult);

    }
    public List<T> encontarTodos(boolean all, int maxResult, int firstResult) {
        EntityManager em = manejadorEntidades();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResult);
            q.setFirstResult(firstResult);}
        List<T> lista=q.getResultList();
        em.close();
        return lista;
    }
    
    protected abstract EntityManager manejadorEntidades();
}
