package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class DnevnaSmenaDto implements Serializable {

    private short dnevnasmenaId;
    private java.util.Date datumdnevnesmene;
    private ZaposlenDto zaposlen;
    private SmenaDto smena;

    public DnevnaSmenaDto() {
    }

    public DnevnaSmenaDto(short dnevnasmenaId, java.util.Date datumdnevnesmene, ZaposlenDto zaposlenId, SmenaDto smenaId) {
        this.dnevnasmenaId = dnevnasmenaId;
        this.datumdnevnesmene = datumdnevnesmene;
        this.zaposlen = zaposlenId;
        this.smena = smenaId;

    }

    public short getDnevnasmenaId() {
        return dnevnasmenaId;
    }

    public void setDnevnasmenaId(short dnevnasmenaId) {
        this.dnevnasmenaId = dnevnasmenaId;
    }

    public java.util.Date getDatumdnevnesmene() {
        return datumdnevnesmene;
    }

    public void setDatumdnevnesmene(java.util.Date datumdnevnesmene) {
        this.datumdnevnesmene = datumdnevnesmene;
    }

    public ZaposlenDto getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(ZaposlenDto zaposlen) {
        this.zaposlen = zaposlen;
    }

    public SmenaDto getSmena() {
        return smena;
    }

    public void setSmena(SmenaDto smena) {
        this.smena = smena;
    }
}
