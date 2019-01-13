/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.ZanimanjeDto;
import com.marijapajkic.entiteti.Zanimanje;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class ZanimanjeMapper {

    public static ZanimanjeDto toDto(Zanimanje entity) {
        ZanimanjeDto dto = new ZanimanjeDto();
        dto.setZanimanjeId(Short.parseShort("" + entity.getZanimanjeId()));
        dto.setNazivzanimanja(entity.getNazivzanimanja());
        dto.setZaposlenCollection(entity.getZaposlenCollection().stream().map((zaposlenEntity) -> {
            return ZaposlenMapper.toDto(zaposlenEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static Zanimanje toEntity(ZanimanjeDto dto) {
        Zanimanje entity = new Zanimanje();
        entity.setZanimanjeId((int) dto.getZanimanjeId());
        entity.setNazivzanimanja(dto.getNazivzanimanja());
        entity.setZaposlenCollection(dto.getZaposlenCollection().stream().map((zaposlenDto) -> {
            return ZaposlenMapper.toEntity(zaposlenDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
