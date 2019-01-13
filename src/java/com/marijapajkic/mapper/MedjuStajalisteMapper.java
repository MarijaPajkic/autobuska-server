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
        MedjuStajalisteDto dto = new MedjuStajalisteDto();
        dto.setMedjustajalisteId(Short.parseShort("" + entity.getMedjustajalisteId()));
        dto.setVremedolaskanastajaliste(entity.getVremedolaskanastajaliste());
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        dto.setStajaliste(StajalisteMapper.toDto(entity.getStajalisteId()));
        
        return dto;
    }
    
    public static MedjuStajaliste toEntity(MedjuStajalisteDto dto) {
        MedjuStajaliste entity = new MedjuStajaliste();
        entity.setMedjustajalisteId((int)dto.getMedjustajalisteId());
        entity.setVremedolaskanastajaliste(dto.getVremedolaskanastajaliste());
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        entity.setStajalisteId(StajalisteMapper.toEntity(dto.getStajaliste()));
        
        return entity; 
    }
    
}
