/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoziloDto;
import com.marijapajkic.entiteti.Vozilo;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class VoziloMapper {

    public static VoziloDto toDto(Vozilo entity) {
        VoziloDto dto = new VoziloDto();
        dto.setVoziloId(Short.parseShort("" + entity.getVoziloId()));
        dto.setRegistracija(entity.getRegistracija());
        dto.setBrojsedista(Short.parseShort("" + entity.getBrojsedista()));
        dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
            return VoznjaMapper.toDto(voznjaEntity);
        }).collect(Collectors.toSet()));
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));

        return dto;
    }

    public static Vozilo toEntity(VoziloDto dto) {
        Vozilo entity = new Vozilo();
        entity.setVoziloId((int) dto.getVoziloId());
        entity.setRegistracija(dto.getRegistracija());
        entity.setBrojsedista((int) dto.getBrojsedista());
        entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
            return VoznjaMapper.toEntity(voznjaDto);
        }).collect(Collectors.toSet()));
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));

        return entity;
    }

}
