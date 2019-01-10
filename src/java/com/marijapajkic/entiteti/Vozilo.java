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
@Table(name = "vozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vozilo.findAll", query = "SELECT v FROM Vozilo v")
    , @NamedQuery(name = "Vozilo.findByVoziloId", query = "SELECT v FROM Vozilo v WHERE v.voziloId = :voziloId")
    , @NamedQuery(name = "Vozilo.findByRegistracija", query = "SELECT v FROM Vozilo v WHERE v.registracija = :registracija")
    , @NamedQuery(name = "Vozilo.findByBrojsedista", query = "SELECT v FROM Vozilo v WHERE v.brojsedista = :brojsedista")})
public class Vozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOZILO_ID")
    private Integer voziloId;
    @Size(max = 1024)
    @Column(name = "REGISTRACIJA")
    private String registracija;
    @Column(name = "BROJSEDISTA")
    private Integer brojsedista;
    @OneToMany(mappedBy = "voziloId")
    private Collection<Voznja> voznjaCollection;
    @JoinColumn(name = "ZAPOSLEN_ID", referencedColumnName = "ZAPOSLEN_ID")
    @ManyToOne
    private Zaposlen zaposlenId;

    public Vozilo() {
    }

    public Vozilo(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public Integer getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public Integer getBrojsedista() {
        return brojsedista;
    }

    public void setBrojsedista(Integer brojsedista) {
        this.brojsedista = brojsedista;
    }

    @XmlTransient
    public Collection<Voznja> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Collection<Voznja> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
    }

    public Zaposlen getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(Zaposlen zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voziloId != null ? voziloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vozilo)) {
            return false;
        }
        Vozilo other = (Vozilo) object;
        if ((this.voziloId == null && other.voziloId != null) || (this.voziloId != null && !this.voziloId.equals(other.voziloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Vozilo[ voziloId=" + voziloId + " ]";
    }
    
}
