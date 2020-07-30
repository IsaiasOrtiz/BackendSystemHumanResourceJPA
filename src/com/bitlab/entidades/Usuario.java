/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
@Entity
@Table(name = "SRH_US_USUARIO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsId", query = "SELECT u FROM Usuario u WHERE u.usId = :usId"),
    @NamedQuery(name = "Usuario.findByUsUsuario", query = "SELECT u FROM Usuario u WHERE u.usUsuario = :usUsuario"),
    @NamedQuery(name = "Usuario.findByUsClave", query = "SELECT u FROM Usuario u WHERE u.usClave = :usClave"),
    @NamedQuery(name = "Usuario.findByAFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "Usuario.findByAUsuarioCrea", query = "SELECT u FROM Usuario u WHERE u.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "Usuario.findByAUsuarioModifica", query = "SELECT u FROM Usuario u WHERE u.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "Usuario.findByAFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.aFechaCreacion = :aFechaCreacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "US_ID", nullable = false)
    private Integer usId;
    @Column(name = "US_USUARIO", length = 100)
    private String usUsuario;
    @Basic(optional = false)
    @Column(name = "US_CLAVE", nullable = false, length = 400)
    private String usClave;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado epId;
    @JoinColumn(name = "TP_ID", referencedColumnName = "TP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipo tpId;

    public Usuario() {
    }

    public Usuario(Integer usId) {
        this.usId = usId;
    }

    public Usuario(Integer usId, String usClave) {
        this.usId = usId;
        this.usClave = usClave;
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsUsuario() {
        return usUsuario;
    }

    public void setUsUsuario(String usUsuario) {
        this.usUsuario = usUsuario;
    }

    public String getUsClave() {
        return usClave;
    }

    public void setUsClave(String usClave) {
        this.usClave = usClave;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public Empleado getEpId() {
        return epId;
    }

    public void setEpId(Empleado epId) {
        this.epId = epId;
    }

    public Tipo getTpId() {
        return tpId;
    }

    public void setTpId(Tipo tpId) {
        this.tpId = tpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usId != null ? usId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usId == null && other.usId != null) || (this.usId != null && !this.usId.equals(other.usId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Usuario[ usId=" + usId + " ]";
    }
    
}
