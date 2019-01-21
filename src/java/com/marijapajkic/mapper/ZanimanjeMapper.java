/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.ZanimanjeDto;
import com.marijapajkic.entiteti.Zanimanje;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class ZanimanjeMapper {

    public static ZanimanjeDto toDto(Zanimanje entity) {
        if (entity == null) {
            return null;
        }
        ZanimanjeDto dto = new ZanimanjeDto();
        dto.setZanimanjeId(Short.parseShort("" + entity.getZanimanjeId()));
        dto.setNazivzanimanja(entity.getNazivzanimanja());
        if (entity.getZaposlenCollection() != null && !entity.getZaposlenCollection().isEmpty()) {
            dto.setZaposlenCollection(entity.getZaposlenCollection().stream().map((zaposlenEntity) -> {
                if (zaposlenEntity.getZanimanjeId() != null) {
                    zaposlenEntity.setZanimanjeId(new Zanimanje(zaposlenEntity.getZanimanjeId().getZanimanjeId()));
                }
                return ZaposlenMapper.toDto(zaposlenEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setZaposlenCollection(new HashSet<>());
        }

        return dto;
    }

    public static Zanimanje toEntity(ZanimanjeDto dto) {
        if (dto == null) {
            return null;
        }
        Zanimanje entity = new Zanimanje();
        entity.setZanimanjeId((int) dto.getZanimanjeId());
        entity.setNazivzanimanja(dto.getNazivzanimanja());
        if (dto.getZaposlenCollection() != null && !dto.getZaposlenCollection().isEmpty()) {
            entity.setZaposlenCollection(dto.getZaposlenCollection().stream().map((zaposlenDto) -> {
                if (zaposlenDto.getZanimanje() != null) {
                    zaposlenDto.setZanimanje(new ZanimanjeDto(zaposlenDto.getZanimanje().getZanimanjeId()));
                }
                return ZaposlenMapper.toEntity(zaposlenDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setZaposlenCollection(new HashSet<>());
        }

        return entity;
    }

}
