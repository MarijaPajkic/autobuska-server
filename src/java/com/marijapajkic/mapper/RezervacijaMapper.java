/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.dto.RezervacijaDto;
import com.marijapajkic.entiteti.Karta;
import com.marijapajkic.entiteti.Rezervacija;
import java.util.HashSet;

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
            if (entity.getKartaId().getRezervacijaCollection() != null && !entity.getKartaId().getRezervacijaCollection().isEmpty()) {
                HashSet<Rezervacija> rezervacije = new HashSet<>();
                entity.getKartaId().getRezervacijaCollection().forEach((rezervacija) -> {
                    if (rezervacija.getKartaId() != null) {
                        rezervacija.setKartaId(new Karta(rezervacija.getKartaId().getKartaId()));
                    } else {
                        rezervacija.setKartaId(null);
                    }
                    rezervacije.add(new Rezervacija(rezervacija.getRezervacijaId()));
                });
                entity.getKartaId().setRezervacijaCollection(rezervacije);
            } else {
                entity.getKartaId().setRezervacijaCollection(null);
            }
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
            if (dto.getKarta().getRezervacijaCollection() != null && !dto.getKarta().getRezervacijaCollection().isEmpty()) {
                HashSet<RezervacijaDto> rezervacije = new HashSet<>();
                dto.getKarta().getRezervacijaCollection().forEach((rezervacijaDto) -> {
                    if (rezervacijaDto.getKarta() != null) {
                        rezervacijaDto.setKarta(new KartaDto(rezervacijaDto.getKarta().getKartaId()));
                    } else {
                        rezervacijaDto.setKarta(null);
                    }
                    rezervacije.add(new RezervacijaDto(rezervacijaDto.getRezervacijaId()));
                });
                dto.getKarta().setRezervacijaCollection(rezervacije);
            } else {
                dto.getKarta().setRezervacijaCollection(null);
            }
        }
        entity.setKartaId(KartaMapper.toEntity(dto.getKarta()));

        return entity;
    }

}
