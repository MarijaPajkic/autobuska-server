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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marij
 */
@Entity
@Table(name = "me_ustajaliste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedjuStajaliste.findAll", query = "SELECT m FROM MedjuStajaliste m")
    , @NamedQuery(name = "MedjuStajaliste.findByMedjustajalisteId", query = "SELECT m FROM MedjuStajaliste m WHERE m.medjustajalisteId = :medjustajalisteId")
    , @NamedQuery(name = "MedjuStajaliste.findByVremedolaskanastajaliste", query = "SELECT m FROM MedjuStajaliste m WHERE m.vremedolaskanastajaliste = :vremedolaskanastajaliste")})
public class MedjuStajaliste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDJUSTAJALISTE_ID")
    private Integer medjustajalisteId;
    @Column(name = "VREMEDOLASKANASTAJALISTE")
    @Temporal(TemporalType.TIME)
    private Date vremedolaskanastajaliste;
    @JoinColumn(name = "STAJALISTE_ID", referencedColumnName = "STAJALISTE_ID")
    @ManyToOne
    private Stajaliste stajalisteId;
    @JoinColumn(name = "RELACIJA_ID", referencedColumnName = "RELACIJA_ID")
    @ManyToOne
    private Relacija relacijaId;

    public MedjuStajaliste() {
    }

    public MedjuStajaliste(Integer medjustajalisteId) {
        this.medjustajalisteId = medjustajalisteId;
    }

    public Integer getMedjustajalisteId() {
        return medjustajalisteId;
    }

    public void setMedjustajalisteId(Integer medjustajalisteId) {
        this.medjustajalisteId = medjustajalisteId;
    }

    public Date getVremedolaskanastajaliste() {
        return vremedolaskanastajaliste;
    }

    public void setVremedolaskanastajaliste(Date vremedolaskanastajaliste) {
        this.vremedolaskanastajaliste = vremedolaskanastajaliste;
    }

    public Stajaliste getStajalisteId() {
        return stajalisteId;
    }

    public void setStajalisteId(Stajaliste stajalisteId) {
        this.stajalisteId = stajalisteId;
    }

    public Relacija getRelacijaId() {
        return relacijaId;
    }

    public void setRelacijaId(Relacija relacijaId) {
        this.relacijaId = relacijaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medjustajalisteId != null ? medjustajalisteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedjuStajaliste)) {
            return false;
        }
        MedjuStajaliste other = (MedjuStajaliste) object;
        if ((this.medjustajalisteId == null && other.medjustajalisteId != null) || (this.medjustajalisteId != null && !this.medjustajalisteId.equals(other.medjustajalisteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.MedjuStajaliste[ medjustajalisteId=" + medjustajalisteId + " ]";
    }
    
}
