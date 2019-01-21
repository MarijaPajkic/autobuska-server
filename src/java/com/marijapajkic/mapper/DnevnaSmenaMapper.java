/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.DnevnaSmenaDto;
import com.marijapajkic.entiteti.DnevnaSmena;
import java.util.HashSet;

/**
 *
 * @author marij
 */
public class DnevnaSmenaMapper {

    public static DnevnaSmenaDto toDto(DnevnaSmena entity) {
        if (entity == null) {
            return null;
        }
        DnevnaSmenaDto dto = new DnevnaSmenaDto();
        dto.setDatumdnevnesmene(entity.getDatumdnevnesmene());
        dto.setDnevnasmenaId(Short.parseShort("" + entity.getDnevnasmenaId()));
        if (entity.getSmenaId() != null) {
            if (entity.getSmenaId().getDnevnaSmenaCollection() != null && !entity.getSmenaId().getDnevnaSmenaCollection().isEmpty()) {
                HashSet<DnevnaSmena> dnevneSmene = new HashSet<>();
                entity.getSmenaId().getDnevnaSmenaCollection().forEach((dnevnaSmena) -> {
                    dnevneSmene.add(new DnevnaSmena(dnevnaSmena.getDnevnasmenaId()));
                });
                entity.getSmenaId().setDnevnaSmenaCollection(dnevneSmene);
            } else {
                entity.getSmenaId().setDnevnaSmenaCollection(null);
            }
        }
        dto.setSmena(SmenaMapper.toDto(entity.getSmenaId()));
        if (entity.getZaposlenId() != null) {
            if (entity.getZaposlenId().getDnevnaSmenaCollection() != null && !entity.getZaposlenId().getDnevnaSmenaCollection().isEmpty()) {
                HashSet<DnevnaSmena> dnevneSmene = new HashSet<>();
                entity.getZaposlenId().getDnevnaSmenaCollection().forEach((dnevnaSmena) -> {
                    dnevneSmene.add(new DnevnaSmena(dnevnaSmena.getDnevnasmenaId()));
                });
                entity.getZaposlenId().setDnevnaSmenaCollection(dnevneSmene);
            } else {
                entity.getZaposlenId().setDnevnaSmenaCollection(null);
            }
        }
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));

        return dto;
    }

    public static DnevnaSmena toEntity(DnevnaSmenaDto dto) {
        if (dto == null) {
            return null;
        }
        DnevnaSmena entity = new DnevnaSmena();
        entity.setDatumdnevnesmene(dto.getDatumdnevnesmene());
        entity.setDnevnasmenaId((int) dto.getDnevnasmenaId());
        if (dto.getSmena() != null) {
            if (dto.getSmena().getDnevnaSmenaCollection() != null && !dto.getSmena().getDnevnaSmenaCollection().isEmpty()) {
                HashSet<DnevnaSmenaDto> dnevneSmene = new HashSet<>();
                dto.getSmena().getDnevnaSmenaCollection().forEach((dnevnaSmenaDto) -> {
                    dnevneSmene.add(new DnevnaSmenaDto(dnevnaSmenaDto.getDnevnasmenaId()));
                });
                dto.getSmena().setDnevnaSmenaCollection(dnevneSmene);
            } else {
                dto.getSmena().setDnevnaSmenaCollection(null);
            }
        }
        entity.setSmenaId(SmenaMapper.toEntity(dto.getSmena()));
        if (dto.getZaposlen() != null) {
            if (dto.getZaposlen().getDnevnaSmenaCollection() != null && !dto.getZaposlen().getDnevnaSmenaCollection().isEmpty()) {
                HashSet<DnevnaSmenaDto> dnevneSmene = new HashSet<>();
                dto.getZaposlen().getDnevnaSmenaCollection().forEach((dnevnaSmenaDto) -> {
                    dnevneSmene.add(new DnevnaSmenaDto(dnevnaSmenaDto.getDnevnasmenaId()));
                });
                dto.getZaposlen().setDnevnaSmenaCollection(dnevneSmene);
            } else {
                dto.getZaposlen().setDnevnaSmenaCollection(null);
            }
        }
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));

        return entity;
    }
}
