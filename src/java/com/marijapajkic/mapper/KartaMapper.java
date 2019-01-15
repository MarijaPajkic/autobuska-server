/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.entiteti.Karta;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class KartaMapper {

    public static KartaDto toDto(Karta entity) {
        if (entity == null) {
            return null;
        }
        KartaDto dto = new KartaDto();
        dto.setKartaId(Short.parseShort("" + entity.getKartaId()));
        dto.setPrevoznik(entity.getPrevoznik());
        dto.setRelacija(entity.getRelacija());
        if (entity.getRezervacijaCollection() != null && !entity.getRezervacijaCollection().isEmpty()) {
            dto.setRezervacijaCollection(entity.getRezervacijaCollection().stream().map((rezervacijaEntity) -> {
//                rezervacijaEntity.setKartaId(null);
                return RezervacijaMapper.toDto(rezervacijaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRezervacijaCollection(new HashSet<>());
        }
        dto.setDatumpolaska(entity.getDatumpolaska());
        dto.setVremepolaska(entity.getVremepolaska());
        dto.setBrojsedista(Short.parseShort("" + entity.getBrojsedista()));
        dto.setPeron(Short.parseShort("" + entity.getPeron()));
        dto.setCena(Short.parseShort("" + entity.getCena()));
        dto.setPopust(entity.getPopust());
        dto.setStanicnausluga(Short.parseShort("" + entity.getStanicnausluga()));
        if (entity.getPlacanjeId() != null) {
            entity.getPlacanjeId().setKartaCollection(null);
            entity.getPlacanjeId().setKartaId(null);
        }
        dto.setPlacanje(PlacanjeMapper.toDto(entity.getPlacanjeId()));
        if (entity.getPlacanjeCollection() != null && !entity.getPlacanjeCollection().isEmpty()) {
            dto.setPlacanjeCollection(entity.getPlacanjeCollection().stream().map((placanjeEntity) -> {
                return PlacanjeMapper.toDto(placanjeEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setPlacanjeCollection(new HashSet<>());
        }
        if (entity.getVoznjaId() != null) {
            entity.getVoznjaId().setKartaCollection(null);
        }
        dto.setVoznja(VoznjaMapper.toDto(entity.getVoznjaId()));

        return dto;

    }

    public static Karta toEntity(KartaDto dto) {
        if (dto == null) {
            return null;
        }
        Karta entity = new Karta();
        entity.setKartaId((int) dto.getKartaId());
        entity.setPrevoznik(dto.getPrevoznik());
        entity.setRelacija(dto.getRelacija());
        if (dto.getRezervacijaCollection() != null && !dto.getRezervacijaCollection().isEmpty()) {
            entity.setRezervacijaCollection(dto.getRezervacijaCollection().stream().map((rezervacijaDto) -> {
                return RezervacijaMapper.toEntity(rezervacijaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRezervacijaCollection(new HashSet<>());
        }
        entity.setDatumpolaska(dto.getDatumpolaska());
        entity.setVremepolaska(dto.getVremepolaska());
        entity.setBrojsedista((int) dto.getBrojsedista());
        entity.setPeron((int) dto.getPeron());
        entity.setCena(dto.getCena());
        entity.setPopust(dto.getPopust());
        entity.setStanicnausluga(dto.getStanicnausluga());
        if (dto.getPlacanje() != null) {
            dto.getPlacanje().setKarta(null);
            dto.getPlacanje().setKartaCollection(null);
        }
        entity.setPlacanjeId(PlacanjeMapper.toEntity(dto.getPlacanje()));
        if (dto.getPlacanjeCollection() != null && !dto.getPlacanjeCollection().isEmpty()) {
            entity.setPlacanjeCollection(dto.getPlacanjeCollection().stream().map((placanjeDto) -> {
                return PlacanjeMapper.toEntity(placanjeDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setPlacanjeCollection(new HashSet<>());
        }
        if (dto.getVoznja() != null) {
            dto.getVoznja().setKartaCollection(null);
        }
        entity.setVoznjaId(VoznjaMapper.toEntity(dto.getVoznja()));

        return entity;
    }
}
