package com.marijapajkic.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

public class MedjuStajalisteDto implements Serializable {

    private short medjustajalisteId;
    private String vremedolaskanastajaliste;
    private StajalisteDto stajaliste;
    private RelacijaDto relacija;

    public MedjuStajalisteDto() {
    }

    public MedjuStajalisteDto(short medjustajalisteId) {
        this.medjustajalisteId = medjustajalisteId;
    }

    public MedjuStajalisteDto(short medjustajalisteId, String vremedolaskanastajaliste, StajalisteDto stajalisteId, RelacijaDto relacijaId) {
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

    public String getVremedolaskanastajaliste() {
        return vremedolaskanastajaliste;
    }

    public void setVremedolaskanastajaliste(String vremedolaskanastajaliste) {
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
