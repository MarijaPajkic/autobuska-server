/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.RezervacijaDto;
import com.marijapajkic.entiteti.Rezervacija;

/**
 *
 * @author marij
 */
public class RezervacijaMapper {

    public static RezervacijaDto toDto(Rezervacija entity) {
        if (entity == null) {
            return null;
        }
        RezervacijaDto dto = new RezervacijaDto();
        dto.setRezervacijaId(Short.parseShort("" + entity.getRezervacijaId()));
        dto.setDatumrezervacije(entity.getDatumrezervacije());
        dto.setVremerezervacije(entity.getVremerezervacije());
        dto.setTiprezervisanja(entity.getTiprezervisanja());
        if (entity.getKartaId() != null) {
            entity.getKartaId().setRezervacijaCollection(null);
        }
        dto.setKarta(KartaMapper.toDto(entity.getKartaId()));

        return dto;

    }

    public static Rezervacija toEntity(RezervacijaDto dto) {
        if (dto == null) {
            return null;
        }
        Rezervacija entity = new Rezervacija();
        entity.setRezervacijaId((int) dto.getRezervacijaId());
        entity.setDatumrezervacije(dto.getDatumrezervacije());
        entity.setVremerezervacije(dto.getVremerezervacije());
        entity.setTiprezervisanja(dto.getTiprezervisanja());
        if (dto.getKarta() != null) {
            dto.getKarta().setRezervacijaCollection(null);
        }
        entity.setKartaId(KartaMapper.toEntity(dto.getKarta()));

        return entity;
    }

}
