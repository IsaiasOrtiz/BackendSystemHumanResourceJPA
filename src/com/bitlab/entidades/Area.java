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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SRH_DP_AREA", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DP_ID", nullable = false)
    private Integer dpId;
    @Basic(optional = false)
    @Column(name = "DP_NOMBRE", nullable = false, length = 150)
    private String dpNombre;
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
    @Basic(optional = false)
    @Column(name = "A_USUARIO_MODIFICA", nullable = false)
    private int aUsuarioModifica;
    @JoinColumn(name = "SC_ID", referencedColumnName = "SC_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal scId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dpId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Area() {
    }

    public Area(Integer dpId) {
        this.dpId = dpId;
    }

    public Area(Integer dpId, String dpNombre, int aUsuarioCrea, Date aFechaModificacion, Date aFechaCreacion, int aUsuarioModifica) {
        this.dpId = dpId;
        this.dpNombre = dpNombre;
        this.aUsuarioCrea = aUsuarioCrea;
        this.aFechaModificacion = aFechaModificacion;
        this.aFechaCreacion = aFechaCreacion;
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getDpNombre() {
        return dpNombre;
    }

    public void setDpNombre(String dpNombre) {
        this.dpNombre = dpNombre;
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

    public int getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(int aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Sucursal getScId() {
        return scId;
    }

    public void setScId(Sucursal scId) {
        this.scId = scId;
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
        hash += (dpId != null ? dpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.dpId == null && other.dpId != null) || (this.dpId != null && !this.dpId.equals(other.dpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Area[ dpId=" + dpId + " ]";
    }
    
}
