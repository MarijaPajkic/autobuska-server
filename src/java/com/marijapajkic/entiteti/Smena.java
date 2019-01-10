/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.entiteti;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "smena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smena.findAll", query = "SELECT s FROM Smena s")
    , @NamedQuery(name = "Smena.findBySmenaId", query = "SELECT s FROM Smena s WHERE s.smenaId = :smenaId")
    , @NamedQuery(name = "Smena.findByNazivsmene", query = "SELECT s FROM Smena s WHERE s.nazivsmene = :nazivsmene")
    , @NamedQuery(name = "Smena.findByPocetaksmene", query = "SELECT s FROM Smena s WHERE s.pocetaksmene = :pocetaksmene")
    , @NamedQuery(name = "Smena.findByKrajsmene", query = "SELECT s FROM Smena s WHERE s.krajsmene = :krajsmene")})
public class Smena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SMENA_ID")
    private Integer smenaId;
    @Size(max = 1024)
    @Column(name = "NAZIVSMENE")
    private String nazivsmene;
    @Size(max = 1024)
    @Column(name = "POCETAKSMENE")
    private String pocetaksmene;
    @Size(max = 1024)
    @Column(name = "KRAJSMENE")
    private String krajsmene;
    @OneToMany(mappedBy = "smenaId")
    private Collection<DnevnaSmena> dnevnaSmenaCollection;

    public Smena() {
    }

    public Smena(Integer smenaId) {
        this.smenaId = smenaId;
    }

    public Integer getSmenaId() {
        return smenaId;
    }

    public void setSmenaId(Integer smenaId) {
        this.smenaId = smenaId;
    }

    public String getNazivsmene() {
        return nazivsmene;
    }

    public void setNazivsmene(String nazivsmene) {
        this.nazivsmene = nazivsmene;
    }

    public String getPocetaksmene() {
        return pocetaksmene;
    }

    public void setPocetaksmene(String pocetaksmene) {
        this.pocetaksmene = pocetaksmene;
    }

    public String getKrajsmene() {
        return krajsmene;
    }

    public void setKrajsmene(String krajsmene) {
        this.krajsmene = krajsmene;
    }

    @XmlTransient
    public Collection<DnevnaSmena> getDnevnaSmenaCollection() {
        return dnevnaSmenaCollection;
    }

    public void setDnevnaSmenaCollection(Collection<DnevnaSmena> dnevnaSmenaCollection) {
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smenaId != null ? smenaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smena)) {
            return false;
        }
        Smena other = (Smena) object;
        if ((this.smenaId == null && other.smenaId != null) || (this.smenaId != null && !this.smenaId.equals(other.smenaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Smena[ smenaId=" + smenaId + " ]";
    }
    
}
