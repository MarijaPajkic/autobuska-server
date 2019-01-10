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
@Table(name = "stajaliste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stajaliste.findAll", query = "SELECT s FROM Stajaliste s")
    , @NamedQuery(name = "Stajaliste.findByStajalisteId", query = "SELECT s FROM Stajaliste s WHERE s.stajalisteId = :stajalisteId")
    , @NamedQuery(name = "Stajaliste.findByNazivstajalista", query = "SELECT s FROM Stajaliste s WHERE s.nazivstajalista = :nazivstajalista")})
public class Stajaliste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAJALISTE_ID")
    private Integer stajalisteId;
    @Size(max = 1024)
    @Column(name = "NAZIVSTAJALISTA")
    private String nazivstajalista;
    @OneToMany(mappedBy = "krajnjestajalisteId")
    private Collection<Relacija> relacijaCollection;
    @OneToMany(mappedBy = "polaznostajalisteId")
    private Collection<Relacija> relacijaCollection1;
    @OneToMany(mappedBy = "stajalisteId")
    private Collection<MedjuStajaliste> medjuStajalisteCollection;

    public Stajaliste() {
    }

    public Stajaliste(Integer stajalisteId) {
        this.stajalisteId = stajalisteId;
    }

    public Integer getStajalisteId() {
        return stajalisteId;
    }

    public void setStajalisteId(Integer stajalisteId) {
        this.stajalisteId = stajalisteId;
    }

    public String getNazivstajalista() {
        return nazivstajalista;
    }

    public void setNazivstajalista(String nazivstajalista) {
        this.nazivstajalista = nazivstajalista;
    }

    @XmlTransient
    public Collection<Relacija> getRelacijaCollection() {
        return relacijaCollection;
    }

    public void setRelacijaCollection(Collection<Relacija> relacijaCollection) {
        this.relacijaCollection = relacijaCollection;
    }

    @XmlTransient
    public Collection<Relacija> getRelacijaCollection1() {
        return relacijaCollection1;
    }

    public void setRelacijaCollection1(Collection<Relacija> relacijaCollection1) {
        this.relacijaCollection1 = relacijaCollection1;
    }

    @XmlTransient
    public Collection<MedjuStajaliste> getMedjuStajalisteCollection() {
        return medjuStajalisteCollection;
    }

    public void setMedjuStajalisteCollection(Collection<MedjuStajaliste> medjuStajalisteCollection) {
        this.medjuStajalisteCollection = medjuStajalisteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stajalisteId != null ? stajalisteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stajaliste)) {
            return false;
        }
        Stajaliste other = (Stajaliste) object;
        if ((this.stajalisteId == null && other.stajalisteId != null) || (this.stajalisteId != null && !this.stajalisteId.equals(other.stajalisteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Stajaliste[ stajalisteId=" + stajalisteId + " ]";
    }
    
}
