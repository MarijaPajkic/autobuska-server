package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class RelacijaDto implements Serializable {

    private short relacijaId;
    private java.util.Date vemepolaska;
    private java.util.Date vremedolaska;
    private StajalisteDto krajnjestajaliste;
    private StajalisteDto polaznostajaliste;
    private TipSaobracajaDto tipsaobracaja;
    private Set<VoznjaDto> voznjaCollection;
    private Set<MedjuStajalisteDto> medjuStajalisteCollection;

    public RelacijaDto() {
    }

    public RelacijaDto(short relacijaId, java.util.Date vemepolaska, java.util.Date vremedolaska, StajalisteDto krajnjestajalisteId, StajalisteDto polaznostajalisteId, TipSaobracajaDto tipsaobracajaId, Set<VoznjaDto> voznjaCollection, Set<MedjuStajalisteDto> medjuStajalisteCollection) {
        this.relacijaId = relacijaId;
        this.vemepolaska = vemepolaska;
        this.vremedolaska = vremedolaska;
        this.krajnjestajaliste = krajnjestajalisteId;
        this.polaznostajaliste = polaznostajalisteId;
        this.tipsaobracaja = tipsaobracajaId;
        this.voznjaCollection = voznjaCollection;
        this.medjuStajalisteCollection = medjuStajalisteCollection;

    }

    public short getRelacijaId() {
        return relacijaId;
    }

    public void setRelacijaId(short relacijaId) {
        this.relacijaId = relacijaId;
    }

    public java.util.Date getVemepolaska() {
        return vemepolaska;
    }

    public void setVemepolaska(java.util.Date vemepolaska) {
        this.vemepolaska = vemepolaska;
    }

    public java.util.Date getVremedolaska() {
        return vremedolaska;
    }

    public void setVremedolaska(java.util.Date vremedolaska) {
        this.vremedolaska = vremedolaska;
    }

    public StajalisteDto getKrajnjestajaliste() {
        return krajnjestajaliste;
    }

    public void setKrajnjestajaliste(StajalisteDto krajnjestajaliste) {
        this.krajnjestajaliste = krajnjestajaliste;
    }

    public StajalisteDto getPolaznostajaliste() {
        return polaznostajaliste;
    }

    public void setPolaznostajaliste(StajalisteDto polaznostajaliste) {
        this.polaznostajaliste = polaznostajaliste;
    }

    public TipSaobracajaDto getTipsaobracaja() {
        return tipsaobracaja;
    }

    public void setTipsaobracaja(TipSaobracajaDto tipsaobracaja) {
        this.tipsaobracaja = tipsaobracaja;
    }

    public Set<VoznjaDto> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Set<VoznjaDto> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
    }

    public Set<MedjuStajalisteDto> getMedjuStajalisteCollection() {
        return medjuStajalisteCollection;
    }

    public void setMedjuStajalisteCollection(Set<MedjuStajalisteDto> medjuStajalisteCollection) {
        this.medjuStajalisteCollection = medjuStajalisteCollection;
    }
}
