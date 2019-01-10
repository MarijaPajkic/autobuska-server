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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "korisnickinalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KorisnickiNalog.findAll", query = "SELECT k FROM KorisnickiNalog k")
    , @NamedQuery(name = "KorisnickiNalog.findByKorisnickinalogId", query = "SELECT k FROM KorisnickiNalog k WHERE k.korisnickinalogId = :korisnickinalogId")
    , @NamedQuery(name = "KorisnickiNalog.findByKorisnickoime", query = "SELECT k FROM KorisnickiNalog k WHERE k.korisnickoime = :korisnickoime")
    , @NamedQuery(name = "KorisnickiNalog.findByKorisnckiemail", query = "SELECT k FROM KorisnickiNalog k WHERE k.korisnckiemail = :korisnckiemail")
    , @NamedQuery(name = "KorisnickiNalog.findByKorisnickalozinka", query = "SELECT k FROM KorisnickiNalog k WHERE k.korisnickalozinka = :korisnickalozinka")})
public class KorisnickiNalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KORISNICKINALOG_ID")
    private Integer korisnickinalogId;
    @Size(max = 1024)
    @Column(name = "KORISNICKOIME")
    private String korisnickoime;
    @Size(max = 1024)
    @Column(name = "KORISNCKIEMAIL")
    private String korisnckiemail;
    @Size(max = 1024)
    @Column(name = "KORISNICKALOZINKA")
    private String korisnickalozinka;
    @JoinColumn(name = "ZAPOSLEN_ID", referencedColumnName = "ZAPOSLEN_ID")
    @ManyToOne
    private Zaposlen zaposlenId;
    @OneToMany(mappedBy = "korisnickinalogId")
    private Collection<Zaposlen> zaposlenCollection;

    public KorisnickiNalog() {
    }

    public KorisnickiNalog(Integer korisnickinalogId) {
        this.korisnickinalogId = korisnickinalogId;
    }

    public Integer getKorisnickinalogId() {
        return korisnickinalogId;
    }

    public void setKorisnickinalogId(Integer korisnickinalogId) {
        this.korisnickinalogId = korisnickinalogId;
    }

    public String getKorisnickoime() {
        return korisnickoime;
    }

    public void setKorisnickoime(String korisnickoime) {
        this.korisnickoime = korisnickoime;
    }

    public String getKorisnckiemail() {
        return korisnckiemail;
    }

    public void setKorisnckiemail(String korisnckiemail) {
        this.korisnckiemail = korisnckiemail;
    }

    public String getKorisnickalozinka() {
        return korisnickalozinka;
    }

    public void setKorisnickalozinka(String korisnickalozinka) {
        this.korisnickalozinka = korisnickalozinka;
    }

    public Zaposlen getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(Zaposlen zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    @XmlTransient
    public Collection<Zaposlen> getZaposlenCollection() {
        return zaposlenCollection;
    }

    public void setZaposlenCollection(Collection<Zaposlen> zaposlenCollection) {
        this.zaposlenCollection = zaposlenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnickinalogId != null ? korisnickinalogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KorisnickiNalog)) {
            return false;
        }
        KorisnickiNalog other = (KorisnickiNalog) object;
        if ((this.korisnickinalogId == null && other.korisnickinalogId != null) || (this.korisnickinalogId != null && !this.korisnickinalogId.equals(other.korisnickinalogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.KorisnickiNalog[ korisnickinalogId=" + korisnickinalogId + " ]";
    }
    
}
