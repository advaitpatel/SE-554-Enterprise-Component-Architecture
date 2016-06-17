/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Advait
 */
@Entity
@Table(name = "INCLASSCOURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inclasscourse.findAll", query = "SELECT i FROM Inclasscourse i"),
    @NamedQuery(name = "Inclasscourse.findById", query = "SELECT i FROM Inclasscourse i WHERE i.id = :id"),
    @NamedQuery(name = "Inclasscourse.findByCode", query = "SELECT i FROM Inclasscourse i WHERE i.code = :code"),
    @NamedQuery(name = "Inclasscourse.findByCredithours", query = "SELECT i FROM Inclasscourse i WHERE i.credithours = :credithours"),
    @NamedQuery(name = "Inclasscourse.findByInstructor", query = "SELECT i FROM Inclasscourse i WHERE i.instructor = :instructor"),
    @NamedQuery(name = "Inclasscourse.findByLocation", query = "SELECT i FROM Inclasscourse i WHERE i.location = :location")})
public class Inclasscourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "CODE")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDITHOURS")
    private Double credithours;
    @Size(max = 255)
    @Column(name = "INSTRUCTOR")
    private String instructor;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;

    public Inclasscourse() {
    }

    public Inclasscourse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCredithours() {
        return credithours;
    }

    public void setCredithours(Double credithours) {
        this.credithours = credithours;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inclasscourse)) {
            return false;
        }
        Inclasscourse other = (Inclasscourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servlets.Inclasscourse[ id=" + id + " ]";
    }
    
}
