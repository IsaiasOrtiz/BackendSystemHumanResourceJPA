/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author elcon
 */
public class Encriptacion {
    private final String LLAVE="ECHO_TECH_BIT_LAB--1212";
    BasicTextEncryptor encriptador=new BasicTextEncryptor();
    /**
     * Asigna la llave de encriptacion y desencriptacion.
     */
    public Encriptacion()
    {
       encriptador.setPassword(LLAVE);
    }
    /**
     * Encripta el texto optenido por el parametro.
     * @param cadena
     * @return 
     */
    public String getTextEncriptado(String cadena)
    {
    return (encriptador.encrypt(cadena));
    }  
    /**
     * Desencripta el texto encriptado que se le envia por parametro
     * @param cadena
     * @return 
     */
    public String getTextDesencriptado(String cadena)
    {
    return (encriptador.decrypt(cadena));
    } 
            
}
