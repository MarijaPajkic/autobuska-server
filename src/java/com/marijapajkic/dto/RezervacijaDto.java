package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class RezervacijaDto implements Serializable {

    private short rezervacijaId;
    private java.util.Date datumrezervacije;
    private String vremerezervacije;
    private String tiprezervisanja;
    private KartaDto karta;

    public RezervacijaDto() {
    }

    public RezervacijaDto(short rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public RezervacijaDto(short rezervacijaId, java.util.Date datumrezervacije, String vremerezervacije, String tiprezervisanja, KartaDto kartaId) {
        this.rezervacijaId = rezervacijaId;
        this.datumrezervacije = datumrezervacije;
        this.vremerezervacije = vremerezervacije;
        this.tiprezervisanja = tiprezervisanja;
        this.karta = kartaId;

    }

    public short getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(short rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public java.util.Date getDatumrezervacije() {
        return datumrezervacije;
    }

    public void setDatumrezervacije(java.util.Date datumrezervacije) {
        this.datumrezervacije = datumrezervacije;
    }

    public String getVremerezervacije() {
        return vremerezervacije;
    }

    public void setVremerezervacije(String vremerezervacije) {
        this.vremerezervacije = vremerezervacije;
    }

    public String getTiprezervisanja() {
        return tiprezervisanja;
    }

    public void setTiprezervisanja(String tiprezervisanja) {
        this.tiprezervisanja = tiprezervisanja;
    }

    public KartaDto getKarta() {
        return karta;
    }

    public void setKarta(KartaDto karta) {
        this.karta = karta;
    }    
    
}
