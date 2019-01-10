/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.entiteti;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "placanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placanje.findAll", query = "SELECT p FROM Placanje p")
    , @NamedQuery(name = "Placanje.findByPlacanjeId", query = "SELECT p FROM Placanje p WHERE p.placanjeId = :placanjeId")
    , @NamedQuery(name = "Placanje.findByTipplacanja", query = "SELECT p FROM Placanje p WHERE p.tipplacanja = :tipplacanja")
    , @NamedQuery(name = "Placanje.findByDatumplacanja", query = "SELECT p FROM Placanje p WHERE p.datumplacanja = :datumplacanja")
    , @NamedQuery(name = "Placanje.findByVremeplacanja", query = "SELECT p FROM Placanje p WHERE p.vremeplacanja = :vremeplacanja")})
public class Placanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLACANJE_ID")
    private Integer placanjeId;
    @Size(max = 1024)
    @Column(name = "TIPPLACANJA")
    private String tipplacanja;
    @Column(name = "DATUMPLACANJA")
    @Temporal(TemporalType.DATE)
    private Date datumplacanja;
    @Column(name = "VREMEPLACANJA")
    @Temporal(TemporalType.TIME)
    private Date vremeplacanja;
    @JoinColumn(name = "KARTA_ID", referencedColumnName = "KARTA_ID")
    @ManyToOne
    private Karta kartaId;
    @OneToMany(mappedBy = "placanjeId")
    private Collection<Karta> kartaCollection;

    public Placanje() {
    }

    public Placanje(Integer placanjeId) {
        this.placanjeId = placanjeId;
    }

    public Integer getPlacanjeId() {
        return placanjeId;
    }

    public void setPlacanjeId(Integer placanjeId) {
        this.placanjeId = placanjeId;
    }

    public String getTipplacanja() {
        return tipplacanja;
    }

    public void setTipplacanja(String tipplacanja) {
        this.tipplacanja = tipplacanja;
    }

    public Date getDatumplacanja() {
        return datumplacanja;
    }

    public void setDatumplacanja(Date datumplacanja) {
        this.datumplacanja = datumplacanja;
    }

    public Date getVremeplacanja() {
        return vremeplacanja;
    }

    public void setVremeplacanja(Date vremeplacanja) {
        this.vremeplacanja = vremeplacanja;
    }

    public Karta getKartaId() {
        return kartaId;
    }

    public void setKartaId(Karta kartaId) {
        this.kartaId = kartaId;
    }

    @XmlTransient
    public Collection<Karta> getKartaCollection() {
        return kartaCollection;
    }

    public void setKartaCollection(Collection<Karta> kartaCollection) {
        this.kartaCollection = kartaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placanjeId != null ? placanjeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placanje)) {
            return false;
        }
        Placanje other = (Placanje) object;
        if ((this.placanjeId == null && other.placanjeId != null) || (this.placanjeId != null && !this.placanjeId.equals(other.placanjeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Placanje[ placanjeId=" + placanjeId + " ]";
    }
    
}
