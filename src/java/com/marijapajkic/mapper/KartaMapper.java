/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.entiteti.Karta;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class KartaMapper {

    public static KartaDto toDto(Karta entity) {
        KartaDto dto = new KartaDto();
        dto.setKartaId(Short.parseShort("" + entity.getKartaId()));
        dto.setPrevoznik(entity.getPrevoznik());
        dto.setRelacija(entity.getRelacija());
        dto.setRezervacijaCollection(entity.getRezervacijaCollection().stream().map((rezervacijaEntity) -> {
            return RezervacijaMapper.toDto(rezervacijaEntity);
        }).collect(Collectors.toSet()));
        dto.setDatumpolaska(entity.getDatumpolaska());
        dto.setVremepolaska(entity.getVremepolaska());
        dto.setBrojsedista(Short.parseShort("" + entity.getBrojsedista()));
        dto.setPeron(Short.parseShort("" + entity.getPeron()));
        dto.setCena(Short.parseShort("" + entity.getCena()));
        dto.setPopust(entity.getPopust());
        dto.setStanicnausluga(Short.parseShort("" + entity.getStanicnausluga()));
        dto.setPlacanje(PlacanjeMapper.toDto(entity.getPlacanjeId()));
        dto.setPlacanjeCollection(entity.getPlacanjeCollection().stream().map((placanjeEntity) -> {
            return PlacanjeMapper.toDto(placanjeEntity);
        }).collect(Collectors.toSet()));
        dto.setVoznja(VoznjaMapper.toDto(entity.getVoznjaId()));

        return dto;

    }

    public static Karta toEntity(KartaDto dto) {
        Karta entity = new Karta();
        entity.setKartaId((int) dto.getKartaId());
        entity.setPrevoznik(dto.getPrevoznik());
        entity.setRelacija(dto.getRelacija());
        entity.setRezervacijaCollection(dto.getRezervacijaCollection().stream().map((rezervacijaDto) -> {
            return RezervacijaMapper.toEntity(rezervacijaDto);
        }).collect(Collectors.toSet()));
        entity.setDatumpolaska(dto.getDatumpolaska());
        entity.setVremepolaska(dto.getVremepolaska());
        entity.setBrojsedista((int) dto.getBrojsedista());
        entity.setPeron((int) dto.getPeron());
        entity.setCena(dto.getCena());
        entity.setPopust(dto.getPopust());
        entity.setStanicnausluga(dto.getStanicnausluga());
        entity.setPlacanjeId(PlacanjeMapper.toEntity(dto.getPlacanje()));
        entity.setPlacanjeCollection(dto.getPlacanjeCollection().stream().map((placanjeDto) -> {
            return PlacanjeMapper.toEntity(placanjeDto);
        }).collect(Collectors.toSet()));
        entity.setVoznjaId(VoznjaMapper.toEntity(dto.getVoznja()));

        return entity;
    }
}
