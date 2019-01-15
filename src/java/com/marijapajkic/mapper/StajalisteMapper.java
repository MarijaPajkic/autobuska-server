/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.StajalisteDto;
import com.marijapajkic.entiteti.Stajaliste;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class StajalisteMapper {

    public static StajalisteDto toDto(Stajaliste entity) {
        if (entity == null) {
            return null;
        }
        StajalisteDto dto = new StajalisteDto();
        dto.setStajalisteId(Short.parseShort("" + entity.getStajalisteId()));
        dto.setNazivstajalista(entity.getNazivstajalista());
        if (entity.getRelacijaCollection1() != null && !entity.getRelacijaCollection1().isEmpty()) {
            dto.setRelacijaCollection1(entity.getRelacijaCollection1().stream().map((relacijaEntity1) -> {
                return RelacijaMapper.toDto(relacijaEntity1);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRelacijaCollection1(new HashSet<>());
        }
        if (entity.getRelacijaCollection() != null && !entity.getRelacijaCollection().isEmpty()) {
            dto.setRelacijaCollection(entity.getRelacijaCollection().stream().map((relacijaEntity) -> {
                return RelacijaMapper.toDto(relacijaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRelacijaCollection(new HashSet<>());
        }
        if (entity.getMedjuStajalisteCollection() != null && !entity.getMedjuStajalisteCollection().isEmpty()) {
            dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
                return MedjuStajalisteMapper.toDto(medjuStajalisteEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setMedjuStajalisteCollection(new HashSet<>());
        }

        return dto;
    }

    public static Stajaliste toEntity(StajalisteDto dto) {
        if (dto == null) {
            return null;
        }
        Stajaliste entity = new Stajaliste();
        entity.setStajalisteId((int) dto.getStajalisteId());
        entity.setNazivstajalista(dto.getNazivstajalista());
        if (dto.getRelacijaCollection1() != null && !dto.getRelacijaCollection1().isEmpty()) {
            entity.setRelacijaCollection1(dto.getRelacijaCollection1().stream().map((relacijaDto1) -> {
                return RelacijaMapper.toEntity(relacijaDto1);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRelacijaCollection1(new HashSet<>());
        }
        if (dto.getRelacijaCollection() != null && !dto.getRelacijaCollection().isEmpty()) {
            entity.setRelacijaCollection(dto.getRelacijaCollection().stream().map((relacijaDto) -> {
                return RelacijaMapper.toEntity(relacijaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRelacijaCollection(new HashSet<>());
        }
        if (dto.getMedjuStajalisteCollection() != null && !dto.getMedjuStajalisteCollection().isEmpty()) {
            entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
                return MedjuStajalisteMapper.toEntity(medjuStajalisteDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setMedjuStajalisteCollection(new HashSet<>());
        }

        return entity;
    }

}
