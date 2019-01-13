/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.PlacanjeDto;
import com.marijapajkic.entiteti.Placanje;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class PlacanjeMapper {

    public static PlacanjeDto toDto(Placanje entity) {
        PlacanjeDto dto = new PlacanjeDto();
        dto.setPlacanjeId(Short.parseShort("" + entity.getPlacanjeId()));
        dto.setTipplacanja(entity.getTipplacanja());
        dto.setDatumplacanja(entity.getDatumplacanja());
        dto.setVremeplacanja(entity.getVremeplacanja());
        dto.setKarta(KartaMapper.toDto(entity.getKartaId()));
        dto.setKartaCollection(entity.getKartaCollection().stream().map((kartaEntity) -> {
            return KartaMapper.toDto(kartaEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static Placanje toEntity(PlacanjeDto dto) {
        Placanje entity = new Placanje();
        entity.setPlacanjeId((int) dto.getPlacanjeId());
        entity.setTipplacanja(dto.getTipplacanja());
        entity.setDatumplacanja(dto.getDatumplacanja());
        entity.setVremeplacanja(dto.getVremeplacanja());
        entity.setKartaId(KartaMapper.toEntity(dto.getKarta()));
        entity.setKartaCollection(dto.getKartaCollection().stream().map((kartaDto) -> {
            return KartaMapper.toEntity(kartaDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
