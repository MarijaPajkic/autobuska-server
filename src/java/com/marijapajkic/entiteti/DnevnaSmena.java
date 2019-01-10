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
@Table(name = "dnevnasmena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DnevnaSmena.findAll", query = "SELECT d FROM DnevnaSmena d")
    , @NamedQuery(name = "DnevnaSmena.findByDnevnasmenaId", query = "SELECT d FROM DnevnaSmena d WHERE d.dnevnasmenaId = :dnevnasmenaId")
    , @NamedQuery(name = "DnevnaSmena.findByDatumdnevnesmene", query = "SELECT d FROM DnevnaSmena d WHERE d.datumdnevnesmene = :datumdnevnesmene")})
public class DnevnaSmena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNEVNASMENA_ID")
    private Integer dnevnasmenaId;
    @Column(name = "DATUMDNEVNESMENE")
    @Temporal(TemporalType.DATE)
    private Date datumdnevnesmene;
    @JoinColumn(name = "ZAPOSLEN_ID", referencedColumnName = "ZAPOSLEN_ID")
    @ManyToOne
    private Zaposlen zaposlenId;
    @JoinColumn(name = "SMENA_ID", referencedColumnName = "SMENA_ID")
    @ManyToOne
    private Smena smenaId;

    public DnevnaSmena() {
    }

    public DnevnaSmena(Integer dnevnasmenaId) {
        this.dnevnasmenaId = dnevnasmenaId;
    }

    public Integer getDnevnasmenaId() {
        return dnevnasmenaId;
    }

    public void setDnevnasmenaId(Integer dnevnasmenaId) {
        this.dnevnasmenaId = dnevnasmenaId;
    }

    public Date getDatumdnevnesmene() {
        return datumdnevnesmene;
    }

    public void setDatumdnevnesmene(Date datumdnevnesmene) {
        this.datumdnevnesmene = datumdnevnesmene;
    }

    public Zaposlen getZaposlenId() {
        return zaposlenId;
    }

    public void setZaposlenId(Zaposlen zaposlenId) {
        this.zaposlenId = zaposlenId;
    }

    public Smena getSmenaId() {
        return smenaId;
    }

    public void setSmenaId(Smena smenaId) {
        this.smenaId = smenaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnevnasmenaId != null ? dnevnasmenaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DnevnaSmena)) {
            return false;
        }
        DnevnaSmena other = (DnevnaSmena) object;
        if ((this.dnevnasmenaId == null && other.dnevnasmenaId != null) || (this.dnevnasmenaId != null && !this.dnevnasmenaId.equals(other.dnevnasmenaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.DnevnaSmena[ dnevnasmenaId=" + dnevnasmenaId + " ]";
    }
    
}
