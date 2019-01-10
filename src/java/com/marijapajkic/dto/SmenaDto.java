package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class SmenaDto implements Serializable {

    private short smenaId;
    private String nazivsmene;
    private String pocetaksmene;
    private String krajsmene;
    private Set<DnevnaSmenaDto> dnevnaSmenaCollection;

    public SmenaDto() {
    }

    public SmenaDto(short smenaId, String nazivsmene, String pocetaksmene, String krajsmene, Set<DnevnaSmenaDto> dnevnaSmenaCollection) {
        this.smenaId = smenaId;
        this.nazivsmene = nazivsmene;
        this.pocetaksmene = pocetaksmene;
        this.krajsmene = krajsmene;
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;

    }

    public short getSmenaId() {
        return smenaId;
    }

    public void setSmenaId(short smenaId) {
        this.smenaId = smenaId;
    }

    public String getNazivsmene() {
        return nazivsmene;
    }

    public void setNazivsmene(String nazivsmene) {
        this.nazivsmene = nazivsmene;
    }

    public String getPocetaksmene() {
        return pocetaksmene;
    }

    public void setPocetaksmene(String pocetaksmene) {
        this.pocetaksmene = pocetaksmene;
    }

    public String getKrajsmene() {
        return krajsmene;
    }

    public void setKrajsmene(String krajsmene) {
        this.krajsmene = krajsmene;
    }

    public Set<DnevnaSmenaDto> getDnevnaSmenaCollection() {
        return dnevnaSmenaCollection;
    }

    public void setDnevnaSmenaCollection(Set<DnevnaSmenaDto> dnevnaSmenaCollection) {
        this.dnevnaSmenaCollection = dnevnaSmenaCollection;
    }
}
