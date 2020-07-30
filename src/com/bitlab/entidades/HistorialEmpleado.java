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
 * @author elcon
 */
@Entity
@Table(name = "SRH_HTP_HISTORIAL_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "HistorialEmpleado.findAll", query = "SELECT h FROM HistorialEmpleado h")})
public class HistorialEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HTP_ID", nullable = false)
    private Integer htpId;
    @Basic(optional = false)
    @Column(name = "HTP_DESCRIPCION", nullable = false, length = 500)
    private String htpDescripcion;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_MODIFICA", nullable = false)
    private int aUsuarioModifica;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_CREA", nullable = false)
    private int aUsuarioCrea;
    @Basic(optional = false)
    @Column(name = "A_FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Basic(optional = false)
    @Column(name = "A_FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado epId;

    public HistorialEmpleado() {
    }

    public HistorialEmpleado(Integer htpId) {
        this.htpId = htpId;
    }

    public HistorialEmpleado(Integer htpId, String htpDescripcion, int aUsuarioModifica, int aUsuarioCrea, Date aFechaModificacion, Date aFechaCreacion) {
        this.htpId = htpId;
        this.htpDescripcion = htpDescripcion;
        this.aUsuarioModifica = aUsuarioModifica;
        this.aUsuarioCrea = aUsuarioCrea;
        this.aFechaModificacion = aFechaModificacion;
        this.aFechaCreacion = aFechaCreacion;
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

    public int getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(int aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public int getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(int aUsuarioCrea) {
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
