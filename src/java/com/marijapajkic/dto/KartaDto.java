package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class KartaDto implements Serializable {

    private short kartaId;
    private String prevoznik;
    private String relacija;
    private java.util.Date datumpolaska;
    private String vremepolaska;
    private short brojsedista;
    private short peron;
    private long cena;
    private String popust;
    private long stanicnausluga;
    private Set<PlacanjeDto> placanjeCollection;
    private Set<RezervacijaDto> rezervacijaCollection;
    private PlacanjeDto placanje;
    private VoznjaDto voznja;

    public KartaDto() {
    }

    public KartaDto(short kartaId) {
        this.kartaId = kartaId;
    }

    public KartaDto(short kartaId, String prevoznik, String relacija, java.util.Date datumpolaska, String vremepolaska, short brojsedista, short peron, long cena, String popust, long stanicnausluga, Set<PlacanjeDto> placanjeCollection, Set<RezervacijaDto> rezervacijaCollection, PlacanjeDto placanjeId, VoznjaDto voznjaId) {
        this.kartaId = kartaId;
        this.prevoznik = prevoznik;
        this.relacija = relacija;
        this.datumpolaska = datumpolaska;
        this.vremepolaska = vremepolaska;
        this.brojsedista = brojsedista;
        this.peron = peron;
        this.cena = cena;
        this.popust = popust;
        this.stanicnausluga = stanicnausluga;
        this.placanjeCollection = placanjeCollection;
        this.rezervacijaCollection = rezervacijaCollection;
        this.placanje = placanjeId;
        this.voznja = voznjaId;

    }

    public short getKartaId() {
        return kartaId;
    }

    public void setKartaId(short kartaId) {
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

    public java.util.Date getDatumpolaska() {
        return datumpolaska;
    }

    public void setDatumpolaska(java.util.Date datumpolaska) {
        this.datumpolaska = datumpolaska;
    }

    public String getVremepolaska() {
        return vremepolaska;
    }

    public void setVremepolaska(String vremepolaska) {
        this.vremepolaska = vremepolaska;
    }

    public short getBrojsedista() {
        return brojsedista;
    }

    public void setBrojsedista(short brojsedista) {
        this.brojsedista = brojsedista;
    }

    public short getPeron() {
        return peron;
    }

    public void setPeron(short peron) {
        this.peron = peron;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    public String getPopust() {
        return popust;
    }

    public void setPopust(String popust) {
        this.popust = popust;
    }

    public long getStanicnausluga() {
        return stanicnausluga;
    }

    public void setStanicnausluga(long stanicnausluga) {
        this.stanicnausluga = stanicnausluga;
    }

    public Set<PlacanjeDto> getPlacanjeCollection() {
        return placanjeCollection;
    }

    public void setPlacanjeCollection(Set<PlacanjeDto> placanjeCollection) {
        this.placanjeCollection = placanjeCollection;
    }

    public Set<RezervacijaDto> getRezervacijaCollection() {
        return rezervacijaCollection;
    }

    public void setRezervacijaCollection(Set<RezervacijaDto> rezervacijaCollection) {
        this.rezervacijaCollection = rezervacijaCollection;
    }

    public PlacanjeDto getPlacanje() {
        return placanje;
    }

    public void setPlacanje(PlacanjeDto placanje) {
        this.placanje = placanje;
    }

    public VoznjaDto getVoznja() {
        return voznja;
    }

    public void setVoznja(VoznjaDto voznja) {
        this.voznja = voznja;
    }
    
    
}
