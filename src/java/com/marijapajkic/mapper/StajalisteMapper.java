/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.StajalisteDto;
import com.marijapajkic.entiteti.Stajaliste;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class StajalisteMapper {

    public static StajalisteDto toDto(Stajaliste entity) {
        StajalisteDto dto = new StajalisteDto();
        dto.setStajalisteId(Short.parseShort("" + entity.getStajalisteId()));
        dto.setNazivstajalista(entity.getNazivstajalista());
        dto.setRelacijaCollection1(entity.getRelacijaCollection1().stream().map((relacijaEntity1) -> {
            return RelacijaMapper.toDto(relacijaEntity1);
        }).collect(Collectors.toSet()));
        dto.setRelacijaCollection(entity.getRelacijaCollection().stream().map((relacijaEntity) -> {
            return RelacijaMapper.toDto(relacijaEntity);
        }).collect(Collectors.toSet()));
        dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
            return MedjuStajalisteMapper.toDto(medjuStajalisteEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static Stajaliste toEntity(StajalisteDto dto) {
        Stajaliste entity = new Stajaliste();
        entity.setStajalisteId((int) dto.getStajalisteId());
        entity.setNazivstajalista(dto.getNazivstajalista());
        entity.setRelacijaCollection1(dto.getRelacijaCollection1().stream().map((relacijaDto1) -> {
            return RelacijaMapper.toEntity(relacijaDto1);
        }).collect(Collectors.toSet()));
        entity.setRelacijaCollection(dto.getRelacijaCollection().stream().map((relacijaDto) -> {
            return RelacijaMapper.toEntity(relacijaDto);
        }).collect(Collectors.toSet()));
        entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
            return MedjuStajalisteMapper.toEntity(medjuStajalisteDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
