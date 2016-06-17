/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.course;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dhaval
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Code")
    @NotNull(message = "Course Code cannot be null.")
    private String courseCode;
    
    @Column(name = "Instructor")
    @NotNull(message = "Instructor cannot be null.")
    private String instructor;

    @Column(name = "CreditHours")
    @DecimalMax("12.0")
    private double creditHours;

    /**
     * Get the value of creditHours
     *
     * @return the value of creditHours
     */
    public double getCreditHours() {
        return creditHours;
    }

    /**
     * Set the value of creditHours
     *
     * @param creditHours new value of creditHours
     */
    public void setCreditHours(double creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * Get the value of instructor
     *
     * @return the value of instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Set the value of instructor
     *
     * @param instructor new value of instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }


    /**
     * Get the value of courseCode
     *
     * @return the value of courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Set the value of courseCode
     *
     * @param courseCode new value of courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLocation() {
        return null;
    }
    
    public void setLocation(String location) {
        
    }
    
    public String getUrl() {
        return null;
    }

    public void setUrl(String url) {
        
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "se.project.ecampusconnect.course.Course[ id=" + id + " ]";
    }
    
}
