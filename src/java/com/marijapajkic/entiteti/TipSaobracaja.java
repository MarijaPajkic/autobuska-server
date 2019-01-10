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
@Table(name = "tipsaobracaja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipSaobracaja.findAll", query = "SELECT t FROM TipSaobracaja t")
    , @NamedQuery(name = "TipSaobracaja.findByTipsaobracajaId", query = "SELECT t FROM TipSaobracaja t WHERE t.tipsaobracajaId = :tipsaobracajaId")
    , @NamedQuery(name = "TipSaobracaja.findByTipsaobracajaNaziv", query = "SELECT t FROM TipSaobracaja t WHERE t.tipsaobracajaNaziv = :tipsaobracajaNaziv")})
public class TipSaobracaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPSAOBRACAJA_ID")
    private Integer tipsaobracajaId;
    @Size(max = 1024)
    @Column(name = "TIPSAOBRACAJA_NAZIV")
    private String tipsaobracajaNaziv;
    @OneToMany(mappedBy = "tipsaobracajaId")
    private Collection<Relacija> relacijaCollection;

    public TipSaobracaja() {
    }

    public TipSaobracaja(Integer tipsaobracajaId) {
        this.tipsaobracajaId = tipsaobracajaId;
    }

    public Integer getTipsaobracajaId() {
        return tipsaobracajaId;
    }

    public void setTipsaobracajaId(Integer tipsaobracajaId) {
        this.tipsaobracajaId = tipsaobracajaId;
    }

    public String getTipsaobracajaNaziv() {
        return tipsaobracajaNaziv;
    }

    public void setTipsaobracajaNaziv(String tipsaobracajaNaziv) {
        this.tipsaobracajaNaziv = tipsaobracajaNaziv;
    }

    @XmlTransient
    public Collection<Relacija> getRelacijaCollection() {
        return relacijaCollection;
    }

    public void setRelacijaCollection(Collection<Relacija> relacijaCollection) {
        this.relacijaCollection = relacijaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipsaobracajaId != null ? tipsaobracajaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipSaobracaja)) {
            return false;
        }
        TipSaobracaja other = (TipSaobracaja) object;
        if ((this.tipsaobracajaId == null && other.tipsaobracajaId != null) || (this.tipsaobracajaId != null && !this.tipsaobracajaId.equals(other.tipsaobracajaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marijapajkic.entiteti.TipSaobracaja[ tipsaobracajaId=" + tipsaobracajaId + " ]";
    }
    
}
