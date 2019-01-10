package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class ZanimanjeDto implements Serializable {

    private short zanimanjeId;
    private String nazivzanimanja;
    private Set<ZaposlenDto> zaposlenCollection;

    public ZanimanjeDto() {
    }

    public ZanimanjeDto(short zanimanjeId, String nazivzanimanja, Set<ZaposlenDto> zaposlenCollection) {
        this.zanimanjeId = zanimanjeId;
        this.nazivzanimanja = nazivzanimanja;
        this.zaposlenCollection = zaposlenCollection;

    }

    public short getZanimanjeId() {
        return zanimanjeId;
    }

    public void setZanimanjeId(short zanimanjeId) {
        this.zanimanjeId = zanimanjeId;
    }

    public String getNazivzanimanja() {
        return nazivzanimanja;
    }

    public void setNazivzanimanja(String nazivzanimanja) {
        this.nazivzanimanja = nazivzanimanja;
    }

    public Set<ZaposlenDto> getZaposlenCollection() {
        return zaposlenCollection;
    }

    public void setZaposlenCollection(Set<ZaposlenDto> zaposlenCollection) {
        this.zaposlenCollection = zaposlenCollection;
    }
}
