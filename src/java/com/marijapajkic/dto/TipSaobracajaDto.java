package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.Set;

public class TipSaobracajaDto implements Serializable {

    private short tipsaobracajaId;
    private String tipsaobracajaNaziv;
    private Set<RelacijaDto> relacijaCollection;

    public TipSaobracajaDto() {
    }

    public TipSaobracajaDto(short tipsaobracajaId, String tipsaobracajaNaziv, Set<RelacijaDto> relacijaCollection) {
        this.tipsaobracajaId = tipsaobracajaId;
        this.tipsaobracajaNaziv = tipsaobracajaNaziv;
        this.relacijaCollection = relacijaCollection;

    }

    public short getTipsaobracajaId() {
        return tipsaobracajaId;
    }

    public void setTipsaobracajaId(short tipsaobracajaId) {
        this.tipsaobracajaId = tipsaobracajaId;
    }

    public String getTipsaobracajaNaziv() {
        return tipsaobracajaNaziv;
    }

    public void setTipsaobracajaNaziv(String tipsaobracajaNaziv) {
        this.tipsaobracajaNaziv = tipsaobracajaNaziv;
    }

    public Set<RelacijaDto> getRelacijaCollection() {
        return relacijaCollection;
    }

    public void setRelacijaCollection(Set<RelacijaDto> relacijaCollection) {
        this.relacijaCollection = relacijaCollection;
    }
}
