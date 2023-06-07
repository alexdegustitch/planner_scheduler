/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bentiteti;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author uSER
 */
@Entity
public class Korisnik {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @Column(length = 50, nullable = false)
    private String ime;
    @Column(length = 50, nullable = false)
    private String prezima;
    private String godina;
    
    @JoinColumn()
    @OneToMany
    private List<Obaveza> obaveze;
    @OneToMany
    private List<Pesma> pesme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezima() {
        return prezima;
    }

    public void setPrezima(String prezima) {
        this.prezima = prezima;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public List<Obaveza> getObaveze() {
        return obaveze;
    }

    public void setObaveze(List<Obaveza> obaveze) {
        this.obaveze = obaveze;
    }

    public List<Pesma> getPesme() {
        return pesme;
    }

    public void setPesme(List<Pesma> pesme) {
        this.pesme = pesme;
    }
    
    
    
    
}
