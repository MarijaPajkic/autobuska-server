/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author marij
 */
public class RezervacijaCompleteDto implements Serializable {
    
    private String tipplacanja;
    private String prevoznik;
    private String relacija;
    private java.util.Date datumpolaska;
    private short brojsedista;
    private short peron;
    private long cena;
    private String popust;
    private long stanicnausluga;
    private String voznjaId;
    private String tiprezervisanja;

    public RezervacijaCompleteDto() {
    }

    public RezervacijaCompleteDto(String tipplacanja, String prevoznik, String relacija, Date datumpolaska, short brojsedista, short peron, long cena, String popust, long stanicnausluga, String voznjaId, String tiprezervisanja) {
        this.tipplacanja = tipplacanja;
        this.prevoznik = prevoznik;
        this.relacija = relacija;
        this.datumpolaska = datumpolaska;
        this.brojsedista = brojsedista;
        this.peron = peron;
        this.cena = cena;
        this.popust = popust;
        this.stanicnausluga = stanicnausluga;
        this.voznjaId = voznjaId;
        this.tiprezervisanja = tiprezervisanja;
    }

    public String getTipplacanja() {
        return tipplacanja;
    }

    public void setTipplacanja(String tipplacanja) {
        this.tipplacanja = tipplacanja;
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

    public Date getDatumpolaska() {
        return datumpolaska;
    }

    public void setDatumpolaska(Date datumpolaska) {
        this.datumpolaska = datumpolaska;
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

    public String getVoznjaId() {
        return voznjaId;
    }

    public void setVoznjaId(String voznjaId) {
        this.voznjaId = voznjaId;
    }

    public String getTiprezervisanja() {
        return tiprezervisanja;
    }

    public void setTiprezervisanja(String tiprezervisanja) {
        this.tiprezervisanja = tiprezervisanja;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.tipplacanja);
        hash = 61 * hash + Objects.hashCode(this.prevoznik);
        hash = 61 * hash + Objects.hashCode(this.relacija);
        hash = 61 * hash + Objects.hashCode(this.datumpolaska);
        hash = 61 * hash + this.brojsedista;
        hash = 61 * hash + this.peron;
        hash = 61 * hash + (int) (this.cena ^ (this.cena >>> 32));
        hash = 61 * hash + Objects.hashCode(this.popust);
        hash = 61 * hash + (int) (this.stanicnausluga ^ (this.stanicnausluga >>> 32));
        hash = 61 * hash + Objects.hashCode(this.voznjaId);
        hash = 61 * hash + Objects.hashCode(this.tiprezervisanja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RezervacijaCompleteDto other = (RezervacijaCompleteDto) obj;
        if (this.brojsedista != other.brojsedista) {
            return false;
        }
        if (this.peron != other.peron) {
            return false;
        }
        if (this.cena != other.cena) {
            return false;
        }
        if (this.stanicnausluga != other.stanicnausluga) {
            return false;
        }
        if (!Objects.equals(this.tipplacanja, other.tipplacanja)) {
            return false;
        }
        if (!Objects.equals(this.prevoznik, other.prevoznik)) {
            return false;
        }
        if (!Objects.equals(this.relacija, other.relacija)) {
            return false;
        }
        if (!Objects.equals(this.popust, other.popust)) {
            return false;
        }
        if (!Objects.equals(this.voznjaId, other.voznjaId)) {
            return false;
        }
        if (!Objects.equals(this.tiprezervisanja, other.tiprezervisanja)) {
            return false;
        }
        if (!Objects.equals(this.datumpolaska, other.datumpolaska)) {
            return false;
        }
        return true;
    }
    
    
}
