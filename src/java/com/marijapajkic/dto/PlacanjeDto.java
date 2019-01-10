package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class PlacanjeDto implements Serializable {

    private short placanjeId;
    private String tipplacanja;
    private java.util.Date datumplacanja;
    private java.util.Date vremeplacanja;
    private KartaDto karta;
    private Set<KartaDto> kartaCollection;

    public PlacanjeDto() {
    }

    public PlacanjeDto(short placanjeId, String tipplacanja, java.util.Date datumplacanja, java.util.Date vremeplacanja, KartaDto kartaId, Set<KartaDto> kartaCollection) {
        this.placanjeId = placanjeId;
        this.tipplacanja = tipplacanja;
        this.datumplacanja = datumplacanja;
        this.vremeplacanja = vremeplacanja;
        this.karta = karta;
        this.kartaCollection = kartaCollection;

    }

    public short getPlacanjeId() {
        return placanjeId;
    }

    public void setPlacanjeId(short placanjeId) {
        this.placanjeId = placanjeId;
    }

    public String getTipplacanja() {
        return tipplacanja;
    }

    public void setTipplacanja(String tipplacanja) {
        this.tipplacanja = tipplacanja;
    }

    public java.util.Date getDatumplacanja() {
        return datumplacanja;
    }

    public void setDatumplacanja(java.util.Date datumplacanja) {
        this.datumplacanja = datumplacanja;
    }

    public java.util.Date getVremeplacanja() {
        return vremeplacanja;
    }

    public void setVremeplacanja(java.util.Date vremeplacanja) {
        this.vremeplacanja = vremeplacanja;
    }

    public KartaDto getKarta() {
        return karta;
    }

    public void setKarta(KartaDto karta) {
        this.karta = karta;
    }

    public Set<KartaDto> getKartaCollection() {
        return kartaCollection;
    }

    public void setKartaCollection(Set<KartaDto> kartaCollection) {
        this.kartaCollection = kartaCollection;
    }
}
