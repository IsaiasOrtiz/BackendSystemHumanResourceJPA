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
@Table(name = "SRH_EC_ESTADO_CIVIL", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EC_ID", nullable = false)
    private Integer ecId;
    @Basic(optional = false)
    @Column(name = "EC_NOMBRE", nullable = false, length = 50)
    private String ecNombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer ecId) {
        this.ecId = ecId;
    }

    public EstadoCivil(Integer ecId, String ecNombre, int aUsuarioModifica, Date aFechaModificacion, int aUsuarioCrea, Date aFechaCreacion) {
        this.ecId = ecId;
        this.ecNombre = ecNombre;
        this.aUsuarioModifica = aUsuarioModifica;
        this.aFechaModificacion = aFechaModificacion;
        this.aUsuarioCrea = aUsuarioCrea;
        this.aFechaCreacion = aFechaCreacion;
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getEcNombre() {
        return ecNombre;
    }

    public void setEcNombre(String ecNombre) {
        this.ecNombre = ecNombre;
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
        hash += (ecId != null ? ecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.ecId == null && other.ecId != null) || (this.ecId != null && !this.ecId.equals(other.ecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.EstadoCivil[ ecId=" + ecId + " ]";
    }
    
}
