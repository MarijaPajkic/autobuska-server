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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "relacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacija.findAll", query = "SELECT r FROM Relacija r")
    , @NamedQuery(name = "Relacija.findByRelacijaId", query = "SELECT r FROM Relacija r WHERE r.relacijaId = :relacijaId")
    , @NamedQuery(name = "Relacija.findByVemepolaska", query = "SELECT r FROM Relacija r WHERE r.vremepolaska = :vremepolaska")
    , @NamedQuery(name = "Relacija.findByVremedolaska", query = "SELECT r FROM Relacija r WHERE r.vremedolaska = :vremedolaska")})
public class Relacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RELACIJA_ID")
    private Integer relacijaId;
    @Column(name = "VEMEPOLASKA")
    private String vremepolaska;
    @Column(name = "VREMEDOLASKA")
    private String vremedolaska;
    @JoinColumn(name = "KRAJNJESTAJALISTE_ID", referencedColumnName = "STAJALISTE_ID")
    @ManyToOne
    private Stajaliste krajnjestajalisteId;
    @JoinColumn(name = "POLAZNOSTAJALISTE_ID", referencedColumnName = "STAJALISTE_ID")
    @ManyToOne
    private Stajaliste polaznostajalisteId;
    @JoinColumn(name = "TIPSAOBRACAJA_ID", referencedColumnName = "TIPSAOBRACAJA_ID")
    @ManyToOne
    private TipSaobracaja tipsaobracajaId;
    @OneToMany(mappedBy = "relacijaId")
    private Collection<Voznja> voznjaCollection;
    @OneToMany(mappedBy = "relacijaId")
    private Collection<MedjuStajaliste> medjuStajalisteCollection;

    public Relacija() {
    }

    public Relacija(Integer relacijaId) {
        this.relacijaId = relacijaId;
    }

    public Integer getRelacijaId() {
        return relacijaId;
    }

    public void setRelacijaId(Integer relacijaId) {
        this.relacijaId = relacijaId;
    }

    public String getVremepolaska() {
        return vremepolaska;
    }

    public void setVremepolaska(String vremepolaska) {
        this.vremepolaska = vremepolaska;
    }

    public String getVremedolaska() {
        return vremedolaska;
    }

    public void setVremedolaska(String vremedolaska) {
        this.vremedolaska = vremedolaska;
    }

    public Stajaliste getKrajnjestajalisteId() {
        return krajnjestajalisteId;
    }

    public void setKrajnjestajalisteId(Stajaliste krajnjestajalisteId) {
        this.krajnjestajalisteId = krajnjestajalisteId;
    }

    public Stajaliste getPolaznostajalisteId() {
        return polaznostajalisteId;
    }

    public void setPolaznostajalisteId(Stajaliste polaznostajalisteId) {
        this.polaznostajalisteId = polaznostajalisteId;
    }

    public TipSaobracaja getTipsaobracajaId() {
        return tipsaobracajaId;
    }

    public void setTipsaobracajaId(TipSaobracaja tipsaobracajaId) {
        this.tipsaobracajaId = tipsaobracajaId;
    }

    @XmlTransient
    public Collection<Voznja> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Collection<Voznja> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
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
        hash += (relacijaId != null ? relacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacija)) {
            return false;
        }
        Relacija other = (Relacija) object;
        if ((this.relacijaId == null && other.relacijaId != null) || (this.relacijaId != null && !this.relacijaId.equals(other.relacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Relacija[ relacijaId=" + relacijaId + " ]";
    }
    
}
