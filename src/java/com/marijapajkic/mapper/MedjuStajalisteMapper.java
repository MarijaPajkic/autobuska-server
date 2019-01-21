/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.MedjuStajalisteDto;
import com.marijapajkic.entiteti.MedjuStajaliste;
import com.marijapajkic.entiteti.Stajaliste;
import java.util.HashSet;

/**
 *
 * @author marij
 */
public class MedjuStajalisteMapper {

    public static MedjuStajalisteDto toDto(MedjuStajaliste entity) {
        if (entity == null) {
            return null;
        }
        MedjuStajalisteDto dto = new MedjuStajalisteDto();
        dto.setMedjustajalisteId(Short.parseShort("" + entity.getMedjustajalisteId()));
        dto.setVremedolaskanastajaliste(entity.getVremedolaskanastajaliste());
        if (entity.getRelacijaId() != null) {
            if (entity.getRelacijaId().getMedjuStajalisteCollection() != null && !entity.getRelacijaId().getMedjuStajalisteCollection().isEmpty()) {
                HashSet<MedjuStajaliste> medjuStajalista = new HashSet<>();
                entity.getRelacijaId().getMedjuStajalisteCollection().forEach((medjuStajaliste) -> {
                    medjuStajalista.add(new MedjuStajaliste(medjuStajaliste.getMedjustajalisteId()));
                });
                entity.getRelacijaId().setMedjuStajalisteCollection(medjuStajalista);
            } else {
                entity.getRelacijaId().setMedjuStajalisteCollection(null);
            }
            if (entity.getRelacijaId().getPolaznostajalisteId() != null) {
                entity.getRelacijaId().setPolaznostajalisteId(new Stajaliste(entity.getRelacijaId().getPolaznostajalisteId().getStajalisteId()));
            }
            if (entity.getRelacijaId().getKrajnjestajalisteId()!= null) {
                entity.getRelacijaId().setKrajnjestajalisteId(new Stajaliste(entity.getRelacijaId().getKrajnjestajalisteId().getStajalisteId()));
            }
        }
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        if (entity.getStajalisteId() != null) {
            if (entity.getStajalisteId().getMedjuStajalisteCollection() != null && !entity.getStajalisteId().getMedjuStajalisteCollection().isEmpty()) {
                HashSet<MedjuStajaliste> medjustajalista = new HashSet<>();
                entity.getStajalisteId().getMedjuStajalisteCollection().forEach((medjuStajaliste) -> {
                    medjustajalista.add(new MedjuStajaliste(medjuStajaliste.getMedjustajalisteId()));
                });
                entity.getStajalisteId().setMedjuStajalisteCollection(medjustajalista);
            } else {
                entity.getStajalisteId().setMedjuStajalisteCollection(null);
            }
        }
        dto.setStajaliste(StajalisteMapper.toDto(entity.getStajalisteId()));

        return dto;
    }

    public static MedjuStajaliste toEntity(MedjuStajalisteDto dto) {
        if (dto == null) {
            return null;
        }
        MedjuStajaliste entity = new MedjuStajaliste();
        entity.setMedjustajalisteId((int) dto.getMedjustajalisteId());
        entity.setVremedolaskanastajaliste(dto.getVremedolaskanastajaliste());
        if (dto.getRelacija() != null) {
            if (dto.getRelacija().getMedjuStajalisteCollection() != null && !dto.getRelacija().getMedjuStajalisteCollection().isEmpty()) {
                HashSet<MedjuStajalisteDto> medjustajalista = new HashSet<>();
                dto.getRelacija().getMedjuStajalisteCollection().forEach((medjuStajalisteDto) -> {
                    medjustajalista.add(new MedjuStajalisteDto(medjuStajalisteDto.getMedjustajalisteId()));
                });
                dto.getRelacija().setMedjuStajalisteCollection(medjustajalista);
            } else {
                dto.getRelacija().setMedjuStajalisteCollection(null);
            }
        }
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        if (dto.getStajaliste() != null) {
            if (dto.getStajaliste().getMedjuStajalisteCollection() != null && !dto.getStajaliste().getMedjuStajalisteCollection().isEmpty()) {
                HashSet<MedjuStajalisteDto> medjustajalista = new HashSet<>();
                dto.getStajaliste().getMedjuStajalisteCollection().forEach((medjuStajalisteDto) -> {
                    medjustajalista.add(new MedjuStajalisteDto(medjuStajalisteDto.getMedjustajalisteId()));
                });
                dto.getStajaliste().setMedjuStajalisteCollection(medjustajalista);
            } else {
                dto.getStajaliste().setMedjuStajalisteCollection(null);
            }
        }
        entity.setStajalisteId(StajalisteMapper.toEntity(dto.getStajaliste()));

        return entity;
    }

}
