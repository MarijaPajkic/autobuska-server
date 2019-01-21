package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class VoznjaDto implements Serializable {

    private String voznjaId;
    private short brojkola;
    private java.util.Date datumvoznje;
    private VoziloDto vozilo;
    private RelacijaDto relacija;
    private ZaposlenDto zaposlen;
    private Set<KartaDto> kartaCollection;

    public VoznjaDto() {
    }

    public VoznjaDto(String voznjaId) {
        this.voznjaId = voznjaId;
    }

    public VoznjaDto(String voznjaId, short brojkola, java.util.Date datumvoznje, VoziloDto voziloId, RelacijaDto relacijaId, ZaposlenDto zaposlenId, Set<KartaDto> kartaCollection) {
        this.voznjaId = voznjaId;
        this.brojkola = brojkola;
        this.datumvoznje = datumvoznje;
        this.vozilo = voziloId;
        this.relacija = relacijaId;
        this.zaposlen = zaposlenId;
        this.kartaCollection = kartaCollection;

    }

    public String getVoznjaId() {
        return voznjaId;
    }

    public void setVoznjaId(String voznjaId) {
        this.voznjaId = voznjaId;
    }

    public short getBrojkola() {
        return brojkola;
    }

    public void setBrojkola(short brojkola) {
        this.brojkola = brojkola;
    }

    public java.util.Date getDatumvoznje() {
        return datumvoznje;
    }

    public void setDatumvoznje(java.util.Date datumvoznje) {
        this.datumvoznje = datumvoznje;
    }

    public VoziloDto getVozilo() {
        return vozilo;
    }

    public void setVozilo(VoziloDto vozilo) {
        this.vozilo = vozilo;
    }

    public RelacijaDto getRelacija() {
        return relacija;
    }

    public void setRelacija(RelacijaDto relacija) {
        this.relacija = relacija;
    }

    public ZaposlenDto getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(ZaposlenDto zaposlen) {
        this.zaposlen = zaposlen;
    }

    public Set<KartaDto> getKartaCollection() {
        return kartaCollection;
    }

    public void setKartaCollection(Set<KartaDto> kartaCollection) {
        this.kartaCollection = kartaCollection;
    }
}
