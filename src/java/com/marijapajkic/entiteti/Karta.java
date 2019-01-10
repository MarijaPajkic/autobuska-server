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
@Table(name = "karta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karta.findAll", query = "SELECT k FROM Karta k")
    , @NamedQuery(name = "Karta.findByKartaId", query = "SELECT k FROM Karta k WHERE k.kartaId = :kartaId")
    , @NamedQuery(name = "Karta.findByPrevoznik", query = "SELECT k FROM Karta k WHERE k.prevoznik = :prevoznik")
    , @NamedQuery(name = "Karta.findByRelacija", query = "SELECT k FROM Karta k WHERE k.relacija = :relacija")
    , @NamedQuery(name = "Karta.findByDatumpolaska", query = "SELECT k FROM Karta k WHERE k.datumpolaska = :datumpolaska")
    , @NamedQuery(name = "Karta.findByVremepolaska", query = "SELECT k FROM Karta k WHERE k.vremepolaska = :vremepolaska")
    , @NamedQuery(name = "Karta.findByBrojsedista", query = "SELECT k FROM Karta k WHERE k.brojsedista = :brojsedista")
    , @NamedQuery(name = "Karta.findByPeron", query = "SELECT k FROM Karta k WHERE k.peron = :peron")
    , @NamedQuery(name = "Karta.findByCena", query = "SELECT k FROM Karta k WHERE k.cena = :cena")
    , @NamedQuery(name = "Karta.findByPopust", query = "SELECT k FROM Karta k WHERE k.popust = :popust")
    , @NamedQuery(name = "Karta.findByStanicnausluga", query = "SELECT k FROM Karta k WHERE k.stanicnausluga = :stanicnausluga")})
public class Karta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KARTA_ID")
    private Integer kartaId;
    @Size(max = 1024)
    @Column(name = "PREVOZNIK")
    private String prevoznik;
    @Size(max = 1024)
    @Column(name = "RELACIJA")
    private String relacija;
    @Column(name = "DATUMPOLASKA")
    @Temporal(TemporalType.DATE)
    private Date datumpolaska;
    @Column(name = "VREMEPOLASKA")
    @Temporal(TemporalType.TIME)
    private Date vremepolaska;
    @Column(name = "BROJSEDISTA")
    private Integer brojsedista;
    @Column(name = "PERON")
    private Integer peron;
    @Column(name = "CENA")
    private Long cena;
    @Size(max = 1024)
    @Column(name = "POPUST")
    private String popust;
    @Column(name = "STANICNAUSLUGA")
    private Long stanicnausluga;
    @OneToMany(mappedBy = "kartaId")
    private Collection<Placanje> placanjeCollection;
    @OneToMany(mappedBy = "kartaId")
    private Collection<Rezervacija> rezervacijaCollection;
    @JoinColumn(name = "PLACANJE_ID", referencedColumnName = "PLACANJE_ID")
    @ManyToOne
    private Placanje placanjeId;
    @JoinColumn(name = "VOZNJA_ID", referencedColumnName = "VOZNJA_ID")
    @ManyToOne
    private Voznja voznjaId;

    public Karta() {
    }

    public Karta(Integer kartaId) {
        this.kartaId = kartaId;
    }

    public Integer getKartaId() {
        return kartaId;
    }

    public void setKartaId(Integer kartaId) {
        this.kartaId = kartaId;
    }

    public String getPrevoznik() {
        return prevoznik;
    }

    public void setPrevoznik(String prevoznik) {
        this.prevoznik = prevoznik;
    }

    public String getRelacija() {
        return relacija;
    }

    public void setRelacija(String relacija) {
        this.relacija = relacija;
    }

    public Date getDatumpolaska() {
        return datumpolaska;
    }

    public void setDatumpolaska(Date datumpolaska) {
        this.datumpolaska = datumpolaska;
    }

    public Date getVremepolaska() {
        return vremepolaska;
    }

    public void setVremepolaska(Date vremepolaska) {
        this.vremepolaska = vremepolaska;
    }

    public Integer getBrojsedista() {
        return brojsedista;
    }

    public void setBrojsedista(Integer brojsedista) {
        this.brojsedista = brojsedista;
    }

    public Integer getPeron() {
        return peron;
    }

    public void setPeron(Integer peron) {
        this.peron = peron;
    }

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public String getPopust() {
        return popust;
    }

    public void setPopust(String popust) {
        this.popust = popust;
    }

    public Long getStanicnausluga() {
        return stanicnausluga;
    }

    public void setStanicnausluga(Long stanicnausluga) {
        this.stanicnausluga = stanicnausluga;
    }

    @XmlTransient
    public Collection<Placanje> getPlacanjeCollection() {
        return placanjeCollection;
    }

    public void setPlacanjeCollection(Collection<Placanje> placanjeCollection) {
        this.placanjeCollection = placanjeCollection;
    }

    @XmlTransient
    public Collection<Rezervacija> getRezervacijaCollection() {
        return rezervacijaCollection;
    }

    public void setRezervacijaCollection(Collection<Rezervacija> rezervacijaCollection) {
        this.rezervacijaCollection = rezervacijaCollection;
    }

    public Placanje getPlacanjeId() {
        return placanjeId;
    }

    public void setPlacanjeId(Placanje placanjeId) {
        this.placanjeId = placanjeId;
    }

    public Voznja getVoznjaId() {
        return voznjaId;
    }

    public void setVoznjaId(Voznja voznjaId) {
        this.voznjaId = voznjaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kartaId != null ? kartaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karta)) {
            return false;
        }
        Karta other = (Karta) object;
        if ((this.kartaId == null && other.kartaId != null) || (this.kartaId != null && !this.kartaId.equals(other.kartaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Karta[ kartaId=" + kartaId + " ]";
    }
    
}
