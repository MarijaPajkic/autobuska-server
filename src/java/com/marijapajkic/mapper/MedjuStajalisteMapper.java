/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.MedjuStajalisteDto;
import com.marijapajkic.entiteti.MedjuStajaliste;

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
            entity.getRelacijaId().setMedjuStajalisteCollection(null);
        }
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        if (entity.getStajalisteId() != null) {
            entity.getStajalisteId().setMedjuStajalisteCollection(null);
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
            dto.getRelacija().setMedjuStajalisteCollection(null);
        }
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        if (dto.getStajaliste() != null) {
            dto.getStajaliste().setMedjuStajalisteCollection(null);
        }
        entity.setStajalisteId(StajalisteMapper.toEntity(dto.getStajaliste()));

        return entity;
    }

}
