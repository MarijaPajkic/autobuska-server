/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.PlacanjeDto;
import com.marijapajkic.entiteti.Placanje;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class PlacanjeMapper {

    public static PlacanjeDto toDto(Placanje entity) {
        if (entity == null) {
            return null;
        }
        PlacanjeDto dto = new PlacanjeDto();
        dto.setPlacanjeId(Short.parseShort("" + entity.getPlacanjeId()));
        dto.setTipplacanja(entity.getTipplacanja());
        dto.setDatumplacanja(entity.getDatumplacanja());
        dto.setVremeplacanja(entity.getVremeplacanja());
        if (entity.getKartaId() != null) {
            entity.getKartaId().setPlacanjeCollection(null);
            entity.getKartaId().setPlacanjeId(null);
        }
        dto.setKarta(KartaMapper.toDto(entity.getKartaId()));
        if (entity.getKartaCollection() != null && !entity.getKartaCollection().isEmpty()) {
            dto.setKartaCollection(entity.getKartaCollection().stream().map((kartaEntity) -> {
                return KartaMapper.toDto(kartaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setKartaCollection(new HashSet<>());
        }

        return dto;
    }

    public static Placanje toEntity(PlacanjeDto dto) {
        if (dto == null) {
            return null;
        }
        Placanje entity = new Placanje();
        entity.setPlacanjeId((int) dto.getPlacanjeId());
        entity.setTipplacanja(dto.getTipplacanja());
        entity.setDatumplacanja(dto.getDatumplacanja());
        entity.setVremeplacanja(dto.getVremeplacanja());
        if (dto.getKarta() != null) {
            dto.getKarta().setPlacanje(null);
            dto.getKarta().setPlacanjeCollection(null);
        }
        entity.setKartaId(KartaMapper.toEntity(dto.getKarta()));
        if (dto.getKartaCollection() != null && !dto.getKartaCollection().isEmpty()) {
            entity.setKartaCollection(dto.getKartaCollection().stream().map((kartaDto) -> {
                return KartaMapper.toEntity(kartaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setKartaCollection(new HashSet<>());
        }

        return entity;
    }

}
