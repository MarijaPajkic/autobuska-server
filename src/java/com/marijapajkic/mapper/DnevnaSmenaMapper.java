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
        DnevnaSmenaDto dto = new DnevnaSmenaDto();
        dto.setDatumdnevnesmene(entity.getDatumdnevnesmene());
        dto.setDnevnasmenaId(Short.parseShort("" + entity.getDnevnasmenaId()));
        dto.setSmena(SmenaMapper.toDto(entity.getSmenaId()));
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));
        
        return dto;
    }
    
    public static DnevnaSmena toEntity(DnevnaSmenaDto dto) {
        DnevnaSmena entity = new DnevnaSmena();
        entity.setDatumdnevnesmene(dto.getDatumdnevnesmene());
        entity.setDnevnasmenaId((int)dto.getDnevnasmenaId());
        entity.setSmenaId(SmenaMapper.toEntity(dto.getSmena()));
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));
        
        return entity;
    }
}
