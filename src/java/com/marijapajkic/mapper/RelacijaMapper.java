/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.RelacijaDto;
import com.marijapajkic.entiteti.Relacija;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class RelacijaMapper {

    public static RelacijaDto toDto(Relacija entity) {
        RelacijaDto dto = new RelacijaDto();
        dto.setRelacijaId(Short.parseShort("" + entity.getRelacijaId()));
        dto.setVemepolaska(entity.getVemepolaska());
        dto.setVremedolaska(entity.getVremedolaska());
        dto.setPolaznostajaliste(StajalisteMapper.toDto(entity.getPolaznostajalisteId()));
        dto.setKrajnjestajaliste(StajalisteMapper.toDto(entity.getKrajnjestajalisteId()));
        dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
            return MedjuStajalisteMapper.toDto(medjuStajalisteEntity);
        }).collect(Collectors.toSet()));
        dto.setTipsaobracaja(TipSaobracajaMapper.toDto(entity.getTipsaobracajaId()));
        dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
            return VoznjaMapper.toDto(voznjaEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static Relacija toEntity(RelacijaDto dto) {
        Relacija entity = new Relacija();
        entity.setRelacijaId((int) dto.getRelacijaId());
        entity.setVemepolaska(dto.getVemepolaska());
        entity.setVremedolaska(dto.getVremedolaska());
        entity.setPolaznostajalisteId(StajalisteMapper.toEntity(dto.getPolaznostajaliste()));
        entity.setKrajnjestajalisteId(StajalisteMapper.toEntity(dto.getKrajnjestajaliste()));
        entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
            return MedjuStajalisteMapper.toEntity(medjuStajalisteDto);
        }).collect(Collectors.toSet()));
        entity.setTipsaobracajaId(TipSaobracajaMapper.toEntity(dto.getTipsaobracaja()));
        entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
            return VoznjaMapper.toEntity(voznjaDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
