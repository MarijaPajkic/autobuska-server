/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marij
 */
public class RelacijaSaMedjustajalistimaDto implements Serializable {
    private RelacijaDto relacija;
    private List<MedjuStajalisteDto> medjustajalista;

    public RelacijaSaMedjustajalistimaDto() {
    }

    public RelacijaSaMedjustajalistimaDto(RelacijaDto relacija, List<MedjuStajalisteDto> medjustajalista) {
        this.relacija = relacija;
        this.medjustajalista = medjustajalista;
    }

    public RelacijaDto getRelacija() {
        return relacija;
    }

    public void setRelacija(RelacijaDto relacija) {
        this.relacija = relacija;
    }

    public List<MedjuStajalisteDto> getMedjustajalista() {
        return medjustajalista;
    }

    public void setMedjustajalista(List<MedjuStajalisteDto> medjustajalista) {
        this.medjustajalista = medjustajalista;
    }
}
