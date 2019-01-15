/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.entiteti.Voznja;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class VoznjaMapper {

    public static VoznjaDto toDto(Voznja entity) {
        if (entity == null) {
            return null;
        }
        VoznjaDto dto = new VoznjaDto();
        dto.setVoznjaId(entity.getVoznjaId());
        dto.setBrojkola(Short.parseShort("" + entity.getBrojkola()));
        dto.setDatumvoznje(entity.getDatumvoznje());
        if (entity.getRelacijaId() != null) {
            entity.getRelacijaId().setVoznjaCollection(null);
        }
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        if (entity.getVoziloId() != null) {
            entity.getVoziloId().setVoznjaCollection(null);
        }
        dto.setVozilo(VoziloMapper.toDto(entity.getVoziloId()));
        if (entity.getZaposlenId() != null) {
            entity.getZaposlenId().setVoznjaCollection(null);
        }
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));
        if (entity.getKartaCollection() != null && !entity.getKartaCollection().isEmpty()) {
            dto.setKartaCollection(entity.getKartaCollection().stream().map((kartaEntity) -> {
                return KartaMapper.toDto(kartaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setKartaCollection(new HashSet<>());
        }

        return dto;
    }

    public static Voznja toEntity(VoznjaDto dto) {
        if (dto == null) {
            return null;
        }
        Voznja entity = new Voznja();
        entity.setVoznjaId(dto.getVoznjaId());
        entity.setBrojkola((int) dto.getBrojkola());
        entity.setDatumvoznje(dto.getDatumvoznje());
        if (dto.getRelacija() != null) {
            dto.getRelacija().setVoznjaCollection(null);
        }
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        if (dto.getVozilo() != null) {
            dto.getVozilo().setVoznjaCollection(null);
        }
        entity.setVoziloId(VoziloMapper.toEntity(dto.getVozilo()));
        if (dto.getZaposlen() != null) {
            dto.getZaposlen().setVoznjaCollection(null);
        }
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));
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
