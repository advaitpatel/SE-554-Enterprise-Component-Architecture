/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
 * @author Advait
 */
@Entity
@Table(name = "SE554LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Se554log.findAll", query = "SELECT s FROM Se554log s"),
    @NamedQuery(name = "Se554log.findById", query = "SELECT s FROM Se554log s WHERE s.id = :id"),
    @NamedQuery(name = "Se554log.findByMessage", query = "SELECT s FROM Se554log s WHERE s.message = :message"),
    @NamedQuery(name = "Se554log.findByMsgCreatedTime", query = "SELECT s FROM Se554log s WHERE s.msgCreatedTime = :msgCreatedTime")})
public class Se554log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "MSG_CREATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date msgCreatedTime;

    public Se554log() {
    }

    public Se554log(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMsgCreatedTime() {
        return msgCreatedTime;
    }

    public void setMsgCreatedTime(Date msgCreatedTime) {
        this.msgCreatedTime = msgCreatedTime;
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
        if (!(object instanceof Se554log)) {
            return false;
        }
        Se554log other = (Se554log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servlets.Se554log[ id=" + id + " ]";
    }
    
}
