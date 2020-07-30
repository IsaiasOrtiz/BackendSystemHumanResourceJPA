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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
@Entity
@Table(name = "SRH_SC_SUCURSAL", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByScId", query = "SELECT s FROM Sucursal s WHERE s.scId = :scId"),
    @NamedQuery(name = "Sucursal.findByScNombre", query = "SELECT s FROM Sucursal s WHERE s.scNombre = :scNombre"),
    @NamedQuery(name = "Sucursal.findByAFechaModificacion", query = "SELECT s FROM Sucursal s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "Sucursal.findByAUsuarioModifica", query = "SELECT s FROM Sucursal s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "Sucursal.findByAFechaCreacion", query = "SELECT s FROM Sucursal s WHERE s.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "Sucursal.findByAUsuarioCrea", query = "SELECT s FROM Sucursal s WHERE s.aUsuarioCrea = :aUsuarioCrea")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SC_ID", nullable = false)
    private Integer scId;
    @Column(name = "SC_NOMBRE", length = 50)
    private String scNombre;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @OneToMany(mappedBy = "scId", fetch = FetchType.LAZY)
    private List<Area> areaList;

    public Sucursal() {
    }

    public Sucursal(Integer scId) {
        this.scId = scId;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScNombre() {
        return scNombre;
    }

    public void setScNombre(String scNombre) {
        this.scNombre = scNombre;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
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

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scId != null ? scId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.scId == null && other.scId != null) || (this.scId != null && !this.scId.equals(other.scId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Sucursal[ scId=" + scId + " ]";
    }
    
}
