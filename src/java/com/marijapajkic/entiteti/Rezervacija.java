/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.entiteti;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author marij
 */
@Entity
@Table(name = "rezervacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")
    , @NamedQuery(name = "Rezervacija.findByRezervacijaId", query = "SELECT r FROM Rezervacija r WHERE r.rezervacijaId = :rezervacijaId")
    , @NamedQuery(name = "Rezervacija.findByDatumrezervacije", query = "SELECT r FROM Rezervacija r WHERE r.datumrezervacije = :datumrezervacije")
    , @NamedQuery(name = "Rezervacija.findByVremerezervacije", query = "SELECT r FROM Rezervacija r WHERE r.vremerezervacije = :vremerezervacije")
    , @NamedQuery(name = "Rezervacija.findByTiprezervisanja", query = "SELECT r FROM Rezervacija r WHERE r.tiprezervisanja = :tiprezervisanja")})
public class Rezervacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REZERVACIJA_ID")
    private Integer rezervacijaId;
    @Column(name = "DATUMREZERVACIJE")
    @Temporal(TemporalType.DATE)
    private Date datumrezervacije;
    @Column(name = "VREMEREZERVACIJE")
    @Temporal(TemporalType.TIME)
    private Date vremerezervacije;
    @Size(max = 1024)
    @Column(name = "TIPREZERVISANJA")
    private String tiprezervisanja;
    @JoinColumn(name = "KARTA_ID", referencedColumnName = "KARTA_ID")
    @ManyToOne
    private Karta kartaId;

    public Rezervacija() {
    }

    public Rezervacija(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Date getDatumrezervacije() {
        return datumrezervacije;
    }

    public void setDatumrezervacije(Date datumrezervacije) {
        this.datumrezervacije = datumrezervacije;
    }

    public Date getVremerezervacije() {
        return vremerezervacije;
    }

    public void setVremerezervacije(Date vremerezervacije) {
        this.vremerezervacije = vremerezervacije;
    }

    public String getTiprezervisanja() {
        return tiprezervisanja;
    }

    public void setTiprezervisanja(String tiprezervisanja) {
        this.tiprezervisanja = tiprezervisanja;
    }

    public Karta getKartaId() {
        return kartaId;
    }

    public void setKartaId(Karta kartaId) {
        this.kartaId = kartaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezervacijaId != null ? rezervacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.rezervacijaId == null && other.rezervacijaId != null) || (this.rezervacijaId != null && !this.rezervacijaId.equals(other.rezervacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Rezervacija[ rezervacijaId=" + rezervacijaId + " ]";
    }
    
}
