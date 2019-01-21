/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoziloDto;
import com.marijapajkic.entiteti.Vozilo;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class VoziloMapper {

    public static VoziloDto toDto(Vozilo entity) {
        if (entity == null) {
            return null;
        }
        VoziloDto dto = new VoziloDto();
        dto.setVoziloId(Short.parseShort("" + entity.getVoziloId()));
        dto.setRegistracija(entity.getRegistracija());
        if (entity.getBrojsedista() != null) {
            dto.setBrojsedista(Short.parseShort("" + entity.getBrojsedista()));
        }
        if (entity.getVoznjaCollection() != null && !entity.getVoznjaCollection().isEmpty()) {
            dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
                return VoznjaMapper.toDto(voznjaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setVoznjaCollection(new HashSet<>());
        }
        if (entity.getZaposlenId() != null) {
            if (entity.getZaposlenId().getVoziloCollection() != null && !entity.getZaposlenId().getVoziloCollection().isEmpty()) {
                HashSet<Vozilo> vozila = new HashSet<>();
                entity.getZaposlenId().getVoziloCollection().forEach((vozilo) -> {
                    vozila.add(new Vozilo(vozilo.getVoziloId()));
                });
                entity.getZaposlenId().setVoziloCollection(vozila);
            } else {
                entity.getZaposlenId().setVoziloCollection(null);
            }
            if (entity.getZaposlenId().getVoziloCollection() != null && !entity.getZaposlenId().getVoziloCollection().isEmpty()) {
                HashSet<Vozilo> vozila = new HashSet<>();
                entity.getZaposlenId().getVoziloCollection().forEach((vozilo) -> {
                    vozila.add(new Vozilo(vozilo.getVoziloId()));
                });
                entity.getZaposlenId().setVoziloCollection(vozila);
            } else {
                entity.getZaposlenId().setVoziloCollection(null);
            }
        }
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));

        return dto;
    }

    public static Vozilo toEntity(VoziloDto dto) {
        if (dto == null) {
            return null;
        }
        Vozilo entity = new Vozilo();
        entity.setVoziloId((int) dto.getVoziloId());
        entity.setRegistracija(dto.getRegistracija());
        entity.setBrojsedista((int) dto.getBrojsedista());
        if (dto.getVoznjaCollection() != null && !dto.getVoznjaCollection().isEmpty()) {
            entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
                return VoznjaMapper.toEntity(voznjaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setVoznjaCollection(new HashSet<>());
        }
        if (dto.getZaposlen() != null) {
            if (dto.getZaposlen().getVoziloCollection() != null && !dto.getZaposlen().getVoziloCollection().isEmpty()) {
                HashSet<VoziloDto> vozila = new HashSet<>();
                dto.getZaposlen().getVoziloCollection().forEach((voziloDto) -> {
                    vozila.add(new VoziloDto(voziloDto.getVoziloId()));
                });
                dto.getZaposlen().setVoziloCollection(vozila);
            } else {
                dto.getZaposlen().setVoziloCollection(null);
            }
            if (dto.getZaposlen().getVoziloCollection() != null && !dto.getZaposlen().getVoziloCollection().isEmpty()) {
                HashSet<VoziloDto> vozila = new HashSet<>();
                dto.getZaposlen().getVoziloCollection().forEach((voziloDto) -> {
                    vozila.add(new VoziloDto(voziloDto.getVoziloId()));
                });
                dto.getZaposlen().setVoziloCollection(vozila);
            } else {
                dto.getZaposlen().setVoziloCollection(null);
            }
        }
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));

        return entity;
    }

}
