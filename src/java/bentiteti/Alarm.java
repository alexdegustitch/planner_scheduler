/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bentiteti;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author uSER
 */
@Entity
public class Alarm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    private Date datum;
    
    private Time vreme;
    
    @Column(nullable = false)
    private boolean navijen;
    @Column(nullable = false)
    private boolean periodican;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getVreme() {
        return vreme;
    }

    public void setVreme(Time vreme) {
        this.vreme = vreme;
    }

    public boolean isNavijen() {
        return navijen;
    }

    public void setNavijen(boolean navijen) {
        this.navijen = navijen;
    }

    public boolean isPeriodican() {
        return periodican;
    }

    public void setPeriodican(boolean periodican) {
        this.periodican = periodican;
    }
    
    
    
}
