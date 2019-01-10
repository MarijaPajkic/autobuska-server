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
@Table(name = "zanimanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zanimanje.findAll", query = "SELECT z FROM Zanimanje z")
    , @NamedQuery(name = "Zanimanje.findByZanimanjeId", query = "SELECT z FROM Zanimanje z WHERE z.zanimanjeId = :zanimanjeId")
    , @NamedQuery(name = "Zanimanje.findByNazivzanimanja", query = "SELECT z FROM Zanimanje z WHERE z.nazivzanimanja = :nazivzanimanja")})
public class Zanimanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZANIMANJE_ID")
    private Integer zanimanjeId;
    @Size(max = 1024)
    @Column(name = "NAZIVZANIMANJA")
    private String nazivzanimanja;
    @OneToMany(mappedBy = "zanimanjeId")
    private Collection<Zaposlen> zaposlenCollection;

    public Zanimanje() {
    }

    public Zanimanje(Integer zanimanjeId) {
        this.zanimanjeId = zanimanjeId;
    }

    public Integer getZanimanjeId() {
        return zanimanjeId;
    }

    public void setZanimanjeId(Integer zanimanjeId) {
        this.zanimanjeId = zanimanjeId;
    }

    public String getNazivzanimanja() {
        return nazivzanimanja;
    }

    public void setNazivzanimanja(String nazivzanimanja) {
        this.nazivzanimanja = nazivzanimanja;
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
        hash += (zanimanjeId != null ? zanimanjeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zanimanje)) {
            return false;
        }
        Zanimanje other = (Zanimanje) object;
        if ((this.zanimanjeId == null && other.zanimanjeId != null) || (this.zanimanjeId != null && !this.zanimanjeId.equals(other.zanimanjeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Zanimanje[ zanimanjeId=" + zanimanjeId + " ]";
    }
    
}
