/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.SmenaDto;
import com.marijapajkic.entiteti.Smena;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class SmenaMapper {

    public static SmenaDto toDto(Smena entity) {
        if (entity == null) {
            return null;
        }
        SmenaDto dto = new SmenaDto();
        if (entity.getDnevnaSmenaCollection() != null && !entity.getDnevnaSmenaCollection().isEmpty()) {
            dto.setDnevnaSmenaCollection(entity.getDnevnaSmenaCollection().stream().map((dnevnaSmenaEntity) -> {
                return DnevnaSmenaMapper.toDto(dnevnaSmenaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setDnevnaSmenaCollection(new HashSet<>());
        }
        dto.setKrajsmene(entity.getKrajsmene());
        dto.setNazivsmene(entity.getNazivsmene());
        dto.setSmenaId(Short.parseShort("" + entity.getSmenaId()));

        return dto;
    }

    public static Smena toEntity(SmenaDto dto) {
        if (dto == null) {
            return null;
        }
        Smena entity = new Smena();
        if (dto.getDnevnaSmenaCollection() != null && !dto.getDnevnaSmenaCollection().isEmpty()) {
            entity.setDnevnaSmenaCollection(dto.getDnevnaSmenaCollection().stream().map((dnevnaSmenaDto) -> {
                return DnevnaSmenaMapper.toEntity(dnevnaSmenaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setDnevnaSmenaCollection(new HashSet<>());
        }
        entity.setKrajsmene(dto.getKrajsmene());
        entity.setNazivsmene(dto.getNazivsmene());
        entity.setSmenaId((int) dto.getSmenaId());

        return entity;
    }
}
