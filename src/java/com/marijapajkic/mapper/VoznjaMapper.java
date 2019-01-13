/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.entiteti.Voznja;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class VoznjaMapper {

    public static VoznjaDto toDto(Voznja entity) {
        VoznjaDto dto = new VoznjaDto();
        dto.setVoznjaId(entity.getVoznjaId());
        dto.setBrojkola(Short.parseShort("" + entity.getBrojkola()));
        dto.setDatumvoznje(entity.getDatumvoznje());
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        dto.setVozilo(VoziloMapper.toDto(entity.getVoziloId()));
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));
        dto.setKartaCollection(entity.getKartaCollection().stream().map((kartaEntity) -> {
            return KartaMapper.toDto(kartaEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static Voznja toEntity(VoznjaDto dto) {
        Voznja entity = new Voznja();
        entity.setVoznjaId(dto.getVoznjaId());
        entity.setBrojkola((int) dto.getBrojkola());
        entity.setDatumvoznje(dto.getDatumvoznje());
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        entity.setVoziloId(VoziloMapper.toEntity(dto.getVozilo()));
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));
        entity.setKartaCollection(dto.getKartaCollection().stream().map((kartaDto) -> {
            return KartaMapper.toEntity(kartaDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
