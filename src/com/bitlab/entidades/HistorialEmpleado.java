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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "SRH_HTP_HISTORIAL_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "HistorialEmpleado.findAll", query = "SELECT h FROM HistorialEmpleado h"),
    @NamedQuery(name = "HistorialEmpleado.findByHtpId", query = "SELECT h FROM HistorialEmpleado h WHERE h.htpId = :htpId"),
    @NamedQuery(name = "HistorialEmpleado.findByHtpDescripcion", query = "SELECT h FROM HistorialEmpleado h WHERE h.htpDescripcion = :htpDescripcion"),
    @NamedQuery(name = "HistorialEmpleado.findByAUsuarioModifica", query = "SELECT h FROM HistorialEmpleado h WHERE h.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "HistorialEmpleado.findByAUsuarioCrea", query = "SELECT h FROM HistorialEmpleado h WHERE h.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "HistorialEmpleado.findByAFechaModificacion", query = "SELECT h FROM HistorialEmpleado h WHERE h.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "HistorialEmpleado.findByAFechaCreacion", query = "SELECT h FROM HistorialEmpleado h WHERE h.aFechaCreacion = :aFechaCreacion")})
public class HistorialEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HTP_ID", nullable = false)
    private Integer htpId;
    @Column(name = "HTP_DESCRIPCION", length = 500)
    private String htpDescripcion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado epId;

    public HistorialEmpleado() {
    }

    public HistorialEmpleado(Integer htpId) {
        this.htpId = htpId;
    }

    public Integer getHtpId() {
        return htpId;
    }

    public void setHtpId(Integer htpId) {
        this.htpId = htpId;
    }

    public String getHtpDescripcion() {
        return htpDescripcion;
    }

    public void setHtpDescripcion(String htpDescripcion) {
        this.htpDescripcion = htpDescripcion;
    }

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htpId != null ? htpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialEmpleado)) {
            return false;
        }
        HistorialEmpleado other = (HistorialEmpleado) object;
        if ((this.htpId == null && other.htpId != null) || (this.htpId != null && !this.htpId.equals(other.htpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.HistorialEmpleado[ htpId=" + htpId + " ]";
    }
    
}
