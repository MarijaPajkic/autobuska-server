/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.DnevnaSmenaDto;
import com.marijapajkic.entiteti.DnevnaSmena;

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
            entity.getSmenaId().setDnevnaSmenaCollection(null);
        }
        dto.setSmena(SmenaMapper.toDto(entity.getSmenaId()));
        if (entity.getZaposlenId() != null) {
            entity.getZaposlenId().setDnevnaSmenaCollection(null);
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
            dto.getSmena().setDnevnaSmenaCollection(null);
        }
        entity.setSmenaId(SmenaMapper.toEntity(dto.getSmena()));
        if (dto.getZaposlen() != null) {
            dto.getZaposlen().setDnevnaSmenaCollection(null);
        }
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));

        return entity;
    }
}
