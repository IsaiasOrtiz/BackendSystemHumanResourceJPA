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
@Table(name = "SRH_PG_PAGOS", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PG_ID", nullable = false)
    private Integer pgId;
    @Basic(optional = false)
    @Column(name = "PG_FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date pgFecha;
    @Basic(optional = false)
    @Column(name = "PG_MONTO", nullable = false)
    private double pgMonto;
    @Basic(optional = false)
    @Column(name = "A_FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_MODIFICA", nullable = false)
    private int aUsuarioModifica;
    @Basic(optional = false)
    @Column(name = "A_FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_CREA", nullable = false)
    private int aUsuarioCrea;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado epId;

    public Pagos() {
    }

    public Pagos(Integer pgId) {
        this.pgId = pgId;
    }

    public Pagos(Integer pgId, Date pgFecha, double pgMonto, Date aFechaCreacion, int aUsuarioModifica, Date aFechaModificacion, int aUsuarioCrea) {
        this.pgId = pgId;
        this.pgFecha = pgFecha;
        this.pgMonto = pgMonto;
        this.aFechaCreacion = aFechaCreacion;
        this.aUsuarioModifica = aUsuarioModifica;
        this.aFechaModificacion = aFechaModificacion;
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public Date getPgFecha() {
        return pgFecha;
    }

    public void setPgFecha(Date pgFecha) {
        this.pgFecha = pgFecha;
    }

    public double getPgMonto() {
        return pgMonto;
    }

    public void setPgMonto(double pgMonto) {
        this.pgMonto = pgMonto;
    }

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public int getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(int aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public int getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(int aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
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
        hash += (pgId != null ? pgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.pgId == null && other.pgId != null) || (this.pgId != null && !this.pgId.equals(other.pgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Pagos[ pgId=" + pgId + " ]";
    }
    
}
