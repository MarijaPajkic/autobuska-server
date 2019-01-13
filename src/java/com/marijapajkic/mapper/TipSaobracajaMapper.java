/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.TipSaobracajaDto;
import com.marijapajkic.entiteti.TipSaobracaja;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class TipSaobracajaMapper {

    public static TipSaobracajaDto toDto(TipSaobracaja entity) {
        TipSaobracajaDto dto = new TipSaobracajaDto();
        dto.setTipsaobracajaId(Short.parseShort(" " + entity.getTipsaobracajaNaziv()));
        dto.setTipsaobracajaNaziv(entity.getTipsaobracajaNaziv());
        dto.setRelacijaCollection(entity.getRelacijaCollection().stream().map((relacijaEntity) -> {
            return RelacijaMapper.toDto(relacijaEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static TipSaobracaja toEntity(TipSaobracajaDto dto) {
        TipSaobracaja entity = new TipSaobracaja();
        entity.setTipsaobracajaId((int) dto.getTipsaobracajaId());
        entity.setTipsaobracajaNaziv(dto.getTipsaobracajaNaziv());
        entity.setRelacijaCollection(dto.getRelacijaCollection().stream().map((relacijaDto) -> {
            return RelacijaMapper.toEntity(relacijaDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
