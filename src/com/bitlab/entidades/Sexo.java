/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elcon
 */
@Entity
@Table(name = "SRH_SX_SEXO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SX_ID", nullable = false)
    private Integer sxId;
    @Basic(optional = false)
    @Column(name = "SX_NOMBRE", nullable = false, length = 20)
    private String sxNombre;
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
    @Basic(optional = false)
    @Column(name = "A_FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sxId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Sexo() {
    }

    public Sexo(Integer sxId) {
        this.sxId = sxId;
    }

    public Sexo(Integer sxId, String sxNombre, int aUsuarioModifica, Date aFechaModificacion, int aUsuarioCrea, Date aFechaCreacion) {
        this.sxId = sxId;
        this.sxNombre = sxNombre;
        this.aUsuarioModifica = aUsuarioModifica;
        this.aFechaModificacion = aFechaModificacion;
        this.aUsuarioCrea = aUsuarioCrea;
        this.aFechaCreacion = aFechaCreacion;
    }

    public Integer getSxId() {
        return sxId;
    }

    public void setSxId(Integer sxId) {
        this.sxId = sxId;
    }

    public String getSxNombre() {
        return sxNombre;
    }

    public void setSxNombre(String sxNombre) {
        this.sxNombre = sxNombre;
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

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sxId != null ? sxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.sxId == null && other.sxId != null) || (this.sxId != null && !this.sxId.equals(other.sxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Sexo[ sxId=" + sxId + " ]";
    }
    
}
