/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KorisnickiNalogDto;
import com.marijapajkic.entiteti.KorisnickiNalog;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class KorisnickiNalogMapper {

    public static KorisnickiNalogDto toDto(KorisnickiNalog entity) {
        if (entity == null) {
            return null;
        }
        KorisnickiNalogDto dto = new KorisnickiNalogDto();
        dto.setKorisnickinalogId(Short.parseShort("" + entity.getKorisnickinalogId()));
        dto.setKorisnickoime(entity.getKorisnickoime());
        dto.setKorisnckiemail(entity.getKorisnckiemail());
        dto.setKorisnickalozinka(entity.getKorisnickalozinka());
        if (entity.getZaposlenId() != null) {
            entity.getZaposlenId().setKorisnickiNalogCollection(null);
            entity.getZaposlenId().setKorisnickinalogId(null);
        }
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));
        if (entity.getZaposlenCollection() != null && !entity.getZaposlenCollection().isEmpty()) {
            dto.setZaposlenCollection(entity.getZaposlenCollection().stream().map((zaposlenEntity) -> {
                return ZaposlenMapper.toDto(zaposlenEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setZaposlenCollection(new HashSet<>());
        }

        return dto;
    }

    public static KorisnickiNalog toEntity(KorisnickiNalogDto dto) {
        if (dto == null) {
            return null;
        }
        KorisnickiNalog entity = new KorisnickiNalog();
        entity.setKorisnickinalogId((int) dto.getKorisnickinalogId());
        entity.setKorisnickoime(dto.getKorisnickoime());
        entity.setKorisnckiemail(dto.getKorisnckiemail());
        entity.setKorisnickalozinka(dto.getKorisnickalozinka());
        if (dto.getZaposlen() != null) {
            dto.getZaposlen().setKorisnickiNalogCollection(null);
            dto.getZaposlen().setKorisnickinalog(null);
        }
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));
        if (dto.getZaposlenCollection() != null && !dto.getZaposlenCollection().isEmpty()) {
            entity.setZaposlenCollection(dto.getZaposlenCollection().stream().map((zaposlenDto) -> {
                return ZaposlenMapper.toEntity(zaposlenDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setZaposlenCollection(new HashSet<>());
        }

        return entity;
    }

}
