/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.TipSaobracajaDto;
import com.marijapajkic.entiteti.TipSaobracaja;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class TipSaobracajaMapper {

    public static TipSaobracajaDto toDto(TipSaobracaja entity) {
        if (entity == null) {
            return null;
        }
        TipSaobracajaDto dto = new TipSaobracajaDto();
        dto.setTipsaobracajaId(Short.parseShort(" " + entity.getTipsaobracajaNaziv()));
        dto.setTipsaobracajaNaziv(entity.getTipsaobracajaNaziv());
        if (entity.getRelacijaCollection() != null && !entity.getRelacijaCollection().isEmpty()) {
            dto.setRelacijaCollection(entity.getRelacijaCollection().stream().map((relacijaEntity) -> {
                return RelacijaMapper.toDto(relacijaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRelacijaCollection(new HashSet<>());
        }

        return dto;
    }

    public static TipSaobracaja toEntity(TipSaobracajaDto dto) {
        if (dto == null) {
            return null;
        }
        TipSaobracaja entity = new TipSaobracaja();
        entity.setTipsaobracajaId((int) dto.getTipsaobracajaId());
        entity.setTipsaobracajaNaziv(dto.getTipsaobracajaNaziv());
        if (dto.getRelacijaCollection() != null && !dto.getRelacijaCollection().isEmpty()) {
            entity.setRelacijaCollection(dto.getRelacijaCollection().stream().map((relacijaDto) -> {
                return RelacijaMapper.toEntity(relacijaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRelacijaCollection(new HashSet<>());
        }

        return entity;
    }

}
