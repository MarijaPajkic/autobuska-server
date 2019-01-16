/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.RelacijaDto;
import com.marijapajkic.entiteti.Relacija;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class RelacijaMapper {

    public static RelacijaDto toDto(Relacija entity) {
        if (entity == null) {
            return null;
        }
        RelacijaDto dto = new RelacijaDto();
        dto.setRelacijaId(Short.parseShort("" + entity.getRelacijaId()));
        dto.setVemepolaska(entity.getVemepolaska());
        dto.setVremedolaska(entity.getVremedolaska());
        if (entity.getPolaznostajalisteId() != null) {
            entity.getPolaznostajalisteId().setRelacijaCollection(null);
            entity.getPolaznostajalisteId().setRelacijaCollection1(null);
        }
        dto.setPolaznostajaliste(StajalisteMapper.toDto(entity.getPolaznostajalisteId()));
        if (entity.getKrajnjestajalisteId() != null) {
            entity.getKrajnjestajalisteId().setRelacijaCollection(null);
            entity.getKrajnjestajalisteId().setRelacijaCollection1(null);
        }
        dto.setKrajnjestajaliste(StajalisteMapper.toDto(entity.getKrajnjestajalisteId()));
        if (entity.getMedjuStajalisteCollection() != null && !entity.getMedjuStajalisteCollection().isEmpty()) {
            dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
                medjuStajalisteEntity.setRelacijaId(null);
//                medjuStajalisteEntity.setStajalisteId(null);
                return MedjuStajalisteMapper.toDto(medjuStajalisteEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setMedjuStajalisteCollection(new HashSet<>());
        }
        if (entity.getTipsaobracajaId() != null) {
            entity.getTipsaobracajaId().setRelacijaCollection(null);
        }
        dto.setTipsaobracaja(TipSaobracajaMapper.toDto(entity.getTipsaobracajaId()));
        if (entity.getVoznjaCollection() != null && !entity.getVoznjaCollection().isEmpty()) {
            dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
                return VoznjaMapper.toDto(voznjaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setVoznjaCollection(new HashSet<>());
        }

        return dto;
    }

    public static Relacija toEntity(RelacijaDto dto) {
        if (dto == null) {
            return null;
        }
        Relacija entity = new Relacija();
        entity.setRelacijaId((int) dto.getRelacijaId());
        entity.setVemepolaska(dto.getVemepolaska());
        entity.setVremedolaska(dto.getVremedolaska());
        if (dto.getPolaznostajaliste() != null) {
            dto.getPolaznostajaliste().setRelacijaCollection(null);
            dto.getPolaznostajaliste().setRelacijaCollection1(null);
        }
        entity.setPolaznostajalisteId(StajalisteMapper.toEntity(dto.getPolaznostajaliste()));
        entity.setKrajnjestajalisteId(StajalisteMapper.toEntity(dto.getKrajnjestajaliste()));
        if (dto.getMedjuStajalisteCollection() != null && !dto.getMedjuStajalisteCollection().isEmpty()) {
            entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
                return MedjuStajalisteMapper.toEntity(medjuStajalisteDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setMedjuStajalisteCollection(new HashSet<>());
        }
        if (dto.getTipsaobracaja() != null) {
            dto.getTipsaobracaja().setRelacijaCollection(null);
        }
        entity.setTipsaobracajaId(TipSaobracajaMapper.toEntity(dto.getTipsaobracaja()));
        if (dto.getVoznjaCollection() != null && !dto.getVoznjaCollection().isEmpty()) {
            entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
                return VoznjaMapper.toEntity(voznjaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setVoznjaCollection(new HashSet<>());
        }

        return entity;
    }

}
