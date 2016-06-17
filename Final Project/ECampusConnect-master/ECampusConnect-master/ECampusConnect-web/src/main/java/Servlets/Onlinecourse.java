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
@Table(name = "ONLINECOURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlinecourse.findAll", query = "SELECT o FROM Onlinecourse o"),
    @NamedQuery(name = "Onlinecourse.findById", query = "SELECT o FROM Onlinecourse o WHERE o.id = :id"),
    @NamedQuery(name = "Onlinecourse.findByCode", query = "SELECT o FROM Onlinecourse o WHERE o.code = :code"),
    @NamedQuery(name = "Onlinecourse.findByCredithours", query = "SELECT o FROM Onlinecourse o WHERE o.credithours = :credithours"),
    @NamedQuery(name = "Onlinecourse.findByInstructor", query = "SELECT o FROM Onlinecourse o WHERE o.instructor = :instructor"),
    @NamedQuery(name = "Onlinecourse.findByUrl", query = "SELECT o FROM Onlinecourse o WHERE o.url = :url")})
public class Onlinecourse implements Serializable {

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
    @Column(name = "URL")
    private String url;

    public Onlinecourse() {
    }

    public Onlinecourse(Long id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Onlinecourse)) {
            return false;
        }
        Onlinecourse other = (Onlinecourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servlets.Onlinecourse[ id=" + id + " ]";
    }
    
}
