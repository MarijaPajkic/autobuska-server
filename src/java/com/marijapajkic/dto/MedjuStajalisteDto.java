package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class MedjuStajalisteDto implements Serializable {

    private short medjustajalisteId;
    private java.util.Date vremedolaskanastajaliste;
    private StajalisteDto stajaliste;
    private RelacijaDto relacija;

    public MedjuStajalisteDto() {
    }

    public MedjuStajalisteDto(short medjustajalisteId, java.util.Date vremedolaskanastajaliste, StajalisteDto stajalisteId, RelacijaDto relacijaId) {
        this.medjustajalisteId = medjustajalisteId;
        this.vremedolaskanastajaliste = vremedolaskanastajaliste;
        this.stajaliste = stajalisteId;
        this.relacija = relacijaId;

    }

    public short getMedjustajalisteId() {
        return medjustajalisteId;
    }

    public void setMedjustajalisteId(short medjustajalisteId) {
        this.medjustajalisteId = medjustajalisteId;
    }

    public java.util.Date getVremedolaskanastajaliste() {
        return vremedolaskanastajaliste;
    }

    public void setVremedolaskanastajaliste(java.util.Date vremedolaskanastajaliste) {
        this.vremedolaskanastajaliste = vremedolaskanastajaliste;
    }

    public StajalisteDto getStajaliste() {
        return stajaliste;
    }

    public void setStajaliste(StajalisteDto stajaliste) {
        this.stajaliste = stajaliste;
    }

    public RelacijaDto getRelacija() {
        return relacija;
    }

    public void setRelacija(RelacijaDto relacija) {
        this.relacija = relacija;
    }
}
