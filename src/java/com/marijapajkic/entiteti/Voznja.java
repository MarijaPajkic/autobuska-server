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
@Table(name = "voznja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voznja.findAll", query = "SELECT v FROM Voznja v")
    , @NamedQuery(name = "Voznja.findByVoznjaId", query = "SELECT v FROM Voznja v WHERE v.voznjaId = :voznjaId")
    , @NamedQuery(name = "Voznja.findByBrojkola", query = "SELECT v FROM Voznja v WHERE v.brojkola = :brojkola")
    , @NamedQuery(name = "Voznja.findByDatumvoznje", query = "SELECT v FROM Voznja v WHERE v.datumvoznje = :datumvoznje")})
public class Voznja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VOZNJA_ID")
    private String voznjaId;
    @Column(name = "BROJKOLA")
    private Integer brojkola;
    @Column(name = "DATUMVOZNJE")
    @Temporal(TemporalType.DATE)
    private Date datumvoznje;
    @JoinColumn(name = "VOZILO_ID", referencedColumnName = "VOZILO_ID")
    @ManyToOne
    private Vozilo voziloId;
    @JoinColumn(name = "RELACIJA_ID", referencedColumnName = "RELACIJA_ID")
    @ManyToOne
    private Relacija relacijaId;
    @JoinColumn(name = "ZAPOSLEN_ID", referencedColumnName = "ZAPOSLEN_ID")
    @ManyToOne
    private Zaposlen zaposlenId;
    @OneToMany(mappedBy = "voznjaId")
    private Collection<Karta> kartaCollection;

    public Voznja() {
    }

    public Voznja(String voznjaId) {
        this.voznjaId = voznjaId;
    }

    public String getVoznjaId() {
        return voznjaId;
    }

    public void setVoznjaId(String voznjaId) {
        this.voznjaId = voznjaId;
    }

    public Integer getBrojkola() {
        return brojkola;
    }

    public void setBrojkola(Integer brojkola) {
        this.brojkola = brojkola;
    }

    public Date getDatumvoznje() {
        return datumvoznje;
    }

    public void setDatumvoznje(Date datumvoznje) {
        this.datumvoznje = datumvoznje;
    }

    public Vozilo getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Vozilo voziloId) {
        this.voziloId = voziloId;
    }

    public Relacija getRelacijaId() {
        return relacijaId;
    }

    public void setRelacijaId(Relacija relacijaId) {
        this.relacijaId = relacijaId;
    }

    public Zaposlen getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(Zaposlen zaposlenId) {
        this.zaposlenId = zaposlenId;
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
        hash += (voznjaId != null ? voznjaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voznja)) {
            return false;
        }
        Voznja other = (Voznja) object;
        if ((this.voznjaId == null && other.voznjaId != null) || (this.voznjaId != null && !this.voznjaId.equals(other.voznjaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.Voznja[ voznjaId=" + voznjaId + " ]";
    }
    
}
