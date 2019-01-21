package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class StajalisteDto implements Serializable {

    private short stajalisteId;
    private String nazivstajalista;
    private Set<RelacijaDto> relacijaCollection;
    private Set<RelacijaDto> relacijaCollection1;
    private Set<MedjuStajalisteDto> medjuStajalisteCollection;

    public StajalisteDto() {
    }

    public StajalisteDto(short stajalisteId) {
        this.stajalisteId = stajalisteId;
    }

    public StajalisteDto(short stajalisteId, String nazivstajalista, Set<RelacijaDto> relacijaCollection, Set<RelacijaDto> relacijaCollection1, Set<MedjuStajalisteDto> medjuStajalisteCollection) {
        this.stajalisteId = stajalisteId;
        this.nazivstajalista = nazivstajalista;
        this.relacijaCollection = relacijaCollection;
        this.relacijaCollection1 = relacijaCollection1;
        this.medjuStajalisteCollection = medjuStajalisteCollection;

    }

    public short getStajalisteId() {
        return stajalisteId;
    }

    public void setStajalisteId(short stajalisteId) {
        this.stajalisteId = stajalisteId;
    }

    public String getNazivstajalista() {
        return nazivstajalista;
    }

    public void setNazivstajalista(String nazivstajalista) {
        this.nazivstajalista = nazivstajalista;
    }

    public Set<RelacijaDto> getRelacijaCollection() {
        return relacijaCollection;
    }

    public void setRelacijaCollection(Set<RelacijaDto> relacijaCollection) {
        this.relacijaCollection = relacijaCollection;
    }

    public Set<RelacijaDto> getRelacijaCollection1() {
        return relacijaCollection1;
    }

    public void setRelacijaCollection1(Set<RelacijaDto> relacijaCollection1) {
        this.relacijaCollection1 = relacijaCollection1;
    }

    public Set<MedjuStajalisteDto> getMedjuStajalisteCollection() {
        return medjuStajalisteCollection;
    }

    public void setMedjuStajalisteCollection(Set<MedjuStajalisteDto> medjuStajalisteCollection) {
        this.medjuStajalisteCollection = medjuStajalisteCollection;
    }
}
