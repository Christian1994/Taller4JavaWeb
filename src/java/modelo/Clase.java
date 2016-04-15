/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NOREÑA
 */
@Entity
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByNumero", query = "SELECT c FROM Clase c WHERE c.numero = :numero"),
    @NamedQuery(name = "Clase.findByFecha", query = "SELECT c FROM Clase c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Clase.findByAsignatura", query = "SELECT c FROM Clase c WHERE c.asignatura = :asignatura"),
    @NamedQuery(name = "Clase.findByTema", query = "SELECT c FROM Clase c WHERE c.tema = :tema"),
    @NamedQuery(name = "Clase.findByHorainicio", query = "SELECT c FROM Clase c WHERE c.horainicio = :horainicio"),
    @NamedQuery(name = "Clase.findByHorafin", query = "SELECT c FROM Clase c WHERE c.horafin = :horafin"),
    @NamedQuery(name = "Clase.findByProfesor", query = "SELECT c FROM Clase c WHERE c.profesor = :profesor")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "asignatura")
    private String asignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horafin")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "profesor")
    private String profesor;

    public Clase() {
    }

    public Clase(Integer numero) {
        this.numero = numero;
    }

    public Clase(Integer numero, Date fecha, String asignatura, String tema, Date horainicio, Date horafin, String profesor) {
        this.numero = numero;
        this.fecha = fecha;
        this.asignatura = asignatura;
        this.tema = tema;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.profesor = profesor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Clase[ numero=" + numero + " ]";
    }
    
}
