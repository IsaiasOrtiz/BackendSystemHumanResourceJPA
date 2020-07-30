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
@Table(name = "SRH_EP_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EP_ID", nullable = false)
    private Integer epId;
    @Basic(optional = false)
    @Column(name = "EP_NOMBRES", nullable = false, length = 200)
    private String epNombres;
    @Basic(optional = false)
    @Column(name = "EP_APELLIDOS", nullable = false, length = 200)
    private String epApellidos;
    @Basic(optional = false)
    @Column(name = "EP_DIRECCION", nullable = false, length = 500)
    private String epDireccion;
    @Basic(optional = false)
    @Column(name = "EP_FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date epFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "EP_DUI", nullable = false, length = 20)
    private String epDui;
    @Basic(optional = false)
    @Column(name = "EP_SALARIO", nullable = false)
    private double epSalario;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_MODIFICA", nullable = false)
    private int aUsuarioModifica;
    @Basic(optional = false)
    @Column(name = "A_USUARIO_CREA", nullable = false)
    private int aUsuarioCrea;
    @Basic(optional = false)
    @Column(name = "A_FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Basic(optional = false)
    @Column(name = "A_FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epId", fetch = FetchType.LAZY)
    private List<HistorialEmpleado> historialEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epId", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epId", fetch = FetchType.LAZY)
    private List<Pagos> pagosList;
    @JoinColumn(name = "DP_ID", referencedColumnName = "DP_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Area dpId;
    @JoinColumn(name = "EC_ID", referencedColumnName = "EC_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoCivil ecId;
    @JoinColumn(name = "ES_ID", referencedColumnName = "ES_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estado esId;
    @JoinColumn(name = "SX_ID", referencedColumnName = "SX_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sexo sxId;

    public Empleado() {
    }

    public Empleado(Integer epId) {
        this.epId = epId;
    }

    public Empleado(Integer epId, String epNombres, String epApellidos, String epDireccion, Date epFechaNacimiento, String epDui, double epSalario, int aUsuarioModifica, int aUsuarioCrea, Date aFechaCreacion, Date aFechaModificacion) {
        this.epId = epId;
        this.epNombres = epNombres;
        this.epApellidos = epApellidos;
        this.epDireccion = epDireccion;
        this.epFechaNacimiento = epFechaNacimiento;
        this.epDui = epDui;
        this.epSalario = epSalario;
        this.aUsuarioModifica = aUsuarioModifica;
        this.aUsuarioCrea = aUsuarioCrea;
        this.aFechaCreacion = aFechaCreacion;
        this.aFechaModificacion = aFechaModificacion;
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

    public double getEpSalario() {
        return epSalario;
    }

    public void setEpSalario(double epSalario) {
        this.epSalario = epSalario;
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
