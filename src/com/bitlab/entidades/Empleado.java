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
 * @author Douglas Isaias Valle Ortiz
 */
@Entity
@Table(name = "SRH_EP_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByEpId", query = "SELECT e FROM Empleado e WHERE e.epId = :epId"),
    @NamedQuery(name = "Empleado.findByEpNombres", query = "SELECT e FROM Empleado e WHERE e.epNombres = :epNombres"),
    @NamedQuery(name = "Empleado.findByEpApellidos", query = "SELECT e FROM Empleado e WHERE e.epApellidos = :epApellidos"),
    @NamedQuery(name = "Empleado.findByEpDireccion", query = "SELECT e FROM Empleado e WHERE e.epDireccion = :epDireccion"),
    @NamedQuery(name = "Empleado.findByEpFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.epFechaNacimiento = :epFechaNacimiento"),
    @NamedQuery(name = "Empleado.findByEpDui", query = "SELECT e FROM Empleado e WHERE e.epDui = :epDui"),
    @NamedQuery(name = "Empleado.findByAUsuarioModifica", query = "SELECT e FROM Empleado e WHERE e.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "Empleado.findByAUsuarioCrea", query = "SELECT e FROM Empleado e WHERE e.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "Empleado.findByAFechaCreacion", query = "SELECT e FROM Empleado e WHERE e.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "Empleado.findByAFechaModificacion", query = "SELECT e FROM Empleado e WHERE e.aFechaModificacion = :aFechaModificacion")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EP_ID", nullable = false)
    private Integer epId;
    @Column(name = "EP_NOMBRES", length = 200)
    private String epNombres;
    @Basic(optional = false)
    @Column(name = "EP_APELLIDOS", nullable = false, length = 200)
    private String epApellidos;
    @Basic(optional = false)
    @Column(name = "EP_DIRECCION", nullable = false, length = 500)
    private String epDireccion;
    @Column(name = "EP_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date epFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "EP_DUI", nullable = false, length = 20)
    private String epDui;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<HistorialEmpleado> historialEmpleadoList;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<Pagos> pagosList;
    @JoinColumn(name = "DP_ID", referencedColumnName = "DP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area dpId;
    @JoinColumn(name = "EC_ID", referencedColumnName = "EC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoCivil ecId;
    @JoinColumn(name = "ES_ID", referencedColumnName = "ES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado esId;
    @JoinColumn(name = "SL_ID", referencedColumnName = "SL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Salario slId;
    @JoinColumn(name = "SX_ID", referencedColumnName = "SX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sexo sxId;

    public Empleado() {
    }

    public Empleado(Integer epId) {
        this.epId = epId;
    }

    public Empleado(Integer epId, String epApellidos, String epDireccion, String epDui) {
        this.epId = epId;
        this.epApellidos = epApellidos;
        this.epDireccion = epDireccion;
        this.epDui = epDui;
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getEpNombres() {
        return epNombres;
    }

    public void setEpNombres(String epNombres) {
        this.epNombres = epNombres;
    }

    public String getEpApellidos() {
        return epApellidos;
    }

    public void setEpApellidos(String epApellidos) {
        this.epApellidos = epApellidos;
    }

    public String getEpDireccion() {
        return epDireccion;
    }

    public void setEpDireccion(String epDireccion) {
        this.epDireccion = epDireccion;
    }

    public Date getEpFechaNacimiento() {
        return epFechaNacimiento;
    }

    public void setEpFechaNacimiento(Date epFechaNacimiento) {
        this.epFechaNacimiento = epFechaNacimiento;
    }

    public String getEpDui() {
        return epDui;
    }

    public void setEpDui(String epDui) {
        this.epDui = epDui;
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

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public List<HistorialEmpleado> getHistorialEmpleadoList() {
        return historialEmpleadoList;
    }

    public void setHistorialEmpleadoList(List<HistorialEmpleado> historialEmpleadoList) {
        this.historialEmpleadoList = historialEmpleadoList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    public Area getDpId() {
        return dpId;
    }

    public void setDpId(Area dpId) {
        this.dpId = dpId;
    }

    public EstadoCivil getEcId() {
        return ecId;
    }

    public void setEcId(EstadoCivil ecId) {
        this.ecId = ecId;
    }

    public Estado getEsId() {
        return esId;
    }

    public void setEsId(Estado esId) {
        this.esId = esId;
    }

    public Salario getSlId() {
        return slId;
    }

    public void setSlId(Salario slId) {
        this.slId = slId;
    }

    public Sexo getSxId() {
        return sxId;
    }

    public void setSxId(Sexo sxId) {
        this.sxId = sxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epId != null ? epId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.epId == null && other.epId != null) || (this.epId != null && !this.epId.equals(other.epId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.Empleado[ epId=" + epId + " ]";
    }
    
}
