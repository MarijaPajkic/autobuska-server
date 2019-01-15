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
@Table(name = "zaposlen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposlen.findAll", query = "SELECT z FROM Zaposlen z")
    , @NamedQuery(name = "Zaposlen.findByZaposlenId", query = "SELECT z FROM Zaposlen z WHERE z.zaposlenId = :zaposlenId")
    , @NamedQuery(name = "Zaposlen.findByIme", query = "SELECT z FROM Zaposlen z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposlen.findByPrezime", query = "SELECT z FROM Zaposlen z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposlen.findByJmbg", query = "SELECT z FROM Zaposlen z WHERE z.jmbg = :jmbg")
    , @NamedQuery(name = "Zaposlen.findByAdresaprebivalista", query = "SELECT z FROM Zaposlen z WHERE z.adresaprebivalista = :adresaprebivalista")
    , @NamedQuery(name = "Zaposlen.findByKontakttelefon", query = "SELECT z FROM Zaposlen z WHERE z.kontakttelefon = :kontakttelefon")
    , @NamedQuery(name = "Zaposlen.findByDatumzaposljavanja", query = "SELECT z FROM Zaposlen z WHERE z.datumzaposljavanja = :datumzaposljavanja")
    , @NamedQuery(name = "Zaposlen.findByStatus", query = "SELECT z FROM Zaposlen z WHERE z.status = :status")})
public class Zaposlen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZAPOSLEN_ID")
    private Integer zaposlenId;
    @Size(max = 1024)
    @Column(name = "IME")
    private String ime;
    @Size(max = 1024)
    @Column(name = "PREZIME")
    private String prezime;
    @Column(name = "JMBG")
    private String jmbg;
    @Size(max = 1024)
    @Column(name = "ADRESAPREBIVALISTA")
    private String adresaprebivalista;
    @Column(name = "KONTAKTTELEFON")
    private String kontakttelefon;
    @Column(name = "DATUMZAPOSLJAVANJA")
    @Temporal(TemporalType.DATE)
    private Date datumzaposljavanja;
    @Column(name = "STATUS")
    private Boolean status;
    @OneToMany(mappedBy = "zaposlenId")
    private Collection<KorisnickiNalog> korisnickiNalogCollection;
    @JoinColumn(name = "KORISNICKINALOG_ID", referencedColumnName = "KORISNICKINALOG_ID")
    @ManyToOne
    private KorisnickiNalog korisnickinalogId;
    @JoinColumn(name = "ZANIMANJE_ID", referencedColumnName = "ZANIMANJE_ID")
    @ManyToOne
    private Zanimanje zanimanjeId;
    @OneToMany(mappedBy = "zaposlenId")
    private Collection<Voznja> voznjaCollection;
    @OneToMany(mappedBy = "zaposlenId")
    private Collection<DnevnaSmena> dnevnaSmenaCollection;
    @OneToMany(mappedBy = "zaposlenId")
    private Collection<Vozilo> voziloCollection;

    public Zaposlen() {
    }

    public Zaposlen(Integer zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    public Integer getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(Integer zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresaprebivalista() {
        return adresaprebivalista;
    }

    public void setAdresaprebivalista(String adresaprebivalista) {
        this.adresaprebivalista = adresaprebivalista;
    }

    public String getKontakttelefon() {
        return kontakttelefon;
    }

    public void setKontakttelefon(String kontakttelefon) {
        this.kontakttelefon = kontakttelefon;
    }

    public Date getDatumzaposljavanja() {
        return datumzaposljavanja;
    }

    public void setDatumzaposljavanja(Date datumzaposljavanja) {
        this.datumzaposljavanja = datumzaposljavanja;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<KorisnickiNalog> getKorisnickiNalogCollection() {
        return korisnickiNalogCollection;
    }

    public void setKorisnickiNalogCollection(Collection<KorisnickiNalog> korisnickiNalogCollection) {
        this.korisnickiNalogCollection = korisnickiNalogCollection;
    }

    public KorisnickiNalog getKorisnickinalogId() {
        return korisnickinalogId;
    }

    public void setKorisnickinalogId(KorisnickiNalog korisnickinalogId) {
        this.korisnickinalogId = korisnickinalogId;
    }

    public Zanimanje getZanimanjeId() {
        return zanimanjeId;
    }

    public void setZanimanjeId(Zanimanje zanimanjeId) {
        this.zanimanjeId = zanimanjeId;
    }

    @XmlTransient
    public Collection<Voznja> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Collection<Voznja> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
    }

    @XmlTransient
    public Collection<DnevnaSmena> getDnevnaSmenaCollection() {
        return dnevnaSmenaCollection;
    }

    public void setDnevnaSmenaCollection(Collection<DnevnaSmena> dnevnaSmenaCollection) {
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;
    }

    @XmlTransient
    public Collection<Vozilo> getVoziloCollection() {
        return voziloCollection;
    }

    public void setVoziloCollection(Collection<Vozilo> voziloCollection) {
        this.voziloCollection = voziloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaposlenId != null ? zaposlenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposlen)) {
            return false;
        }
        Zaposlen other = (Zaposlen) object;
        if ((this.zaposlenId == null && other.zaposlenId != null) || (this.zaposlenId != null && !this.zaposlenId.equals(other.zaposlenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Zaposlen[ zaposlenId=" + zaposlenId + " ]";
    }

}
