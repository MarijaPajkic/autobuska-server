/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.SmenaDto;
import com.marijapajkic.entiteti.Smena;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class SmenaMapper {

    public static SmenaDto toDto(Smena entity) {
        SmenaDto dto = new SmenaDto();
        dto.setDnevnaSmenaCollection(entity.getDnevnaSmenaCollection().stream().map((dnevnaSmenaEntity) -> {
            return DnevnaSmenaMapper.toDto(dnevnaSmenaEntity);
        }).collect(Collectors.toSet()));
        dto.setKrajsmene(entity.getKrajsmene());
        dto.setNazivsmene(entity.getNazivsmene());
        dto.setSmenaId(Short.parseShort("" + entity.getSmenaId()));

        return dto;
    }

    public static Smena toEntity(SmenaDto dto) {
        Smena entity = new Smena();
        entity.setDnevnaSmenaCollection(dto.getDnevnaSmenaCollection().stream().map((dnevnaSmenaDto) -> {
            return DnevnaSmenaMapper.toEntity(dnevnaSmenaDto);
        }).collect(Collectors.toSet()));
        entity.setKrajsmene(dto.getKrajsmene());
        entity.setNazivsmene(dto.getNazivsmene());
        entity.setSmenaId((int) dto.getSmenaId());

        return entity;
    }
}
