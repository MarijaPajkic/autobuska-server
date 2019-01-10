package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class VoziloDto implements Serializable {

    private short voziloId;
    private String registracija;
    private short brojsedista;
    private Set<VoznjaDto> voznjaCollection;
    private ZaposlenDto zaposlen;

    public VoziloDto() {
    }

    public VoziloDto(short voziloId, String registracija, short brojsedista, Set<VoznjaDto> voznjaCollection, ZaposlenDto zaposlenId) {
        this.voziloId = voziloId;
        this.registracija = registracija;
        this.brojsedista = brojsedista;
        this.voznjaCollection = voznjaCollection;
        this.zaposlen = zaposlenId;

    }

    public short getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(short voziloId) {
        this.voziloId = voziloId;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public short getBrojsedista() {
        return brojsedista;
    }

    public void setBrojsedista(short brojsedista) {
        this.brojsedista = brojsedista;
    }

    public Set<VoznjaDto> getVoznjaCollection() {
        return voznjaCollection;
    }

    public void setVoznjaCollection(Set<VoznjaDto> voznjaCollection) {
        this.voznjaCollection = voznjaCollection;
    }

    public ZaposlenDto getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(ZaposlenDto zaposlen) {
        this.zaposlen = zaposlen;
    }
}
