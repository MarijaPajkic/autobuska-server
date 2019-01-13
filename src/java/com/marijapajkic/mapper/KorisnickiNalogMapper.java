/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KorisnickiNalogDto;
import com.marijapajkic.entiteti.KorisnickiNalog;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class KorisnickiNalogMapper {

    public static KorisnickiNalogDto toDto(KorisnickiNalog entity) {
        KorisnickiNalogDto dto = new KorisnickiNalogDto();
        dto.setKorisnickinalogId(Short.parseShort("" + entity.getKorisnickinalogId()));
        dto.setKorisnickoime(entity.getKorisnickoime());
        dto.setKorisnckiemail(entity.getKorisnckiemail());
        dto.setKorisnickalozinka(entity.getKorisnickalozinka());
        dto.setZaposlen(ZaposlenMapper.toDto(entity.getZaposlenId()));
        dto.setZaposlenCollection(entity.getZaposlenCollection().stream().map((zaposlenEntity) -> {
            return ZaposlenMapper.toDto(zaposlenEntity);
        }).collect(Collectors.toSet()));

        return dto;
    }

    public static KorisnickiNalog toEntity(KorisnickiNalogDto dto) {
        KorisnickiNalog entity = new KorisnickiNalog();
        entity.setKorisnickinalogId((int) dto.getKorisnickinalogId());
        entity.setKorisnickoime(dto.getKorisnickoime());
        entity.setKorisnckiemail(dto.getKorisnckiemail());
        entity.setKorisnickalozinka(dto.getKorisnickalozinka());
        entity.setZaposlenId(ZaposlenMapper.toEntity(dto.getZaposlen()));
        entity.setZaposlenCollection(dto.getZaposlenCollection().stream().map((zaposlenDto) -> {
            return ZaposlenMapper.toEntity(zaposlenDto);
        }).collect(Collectors.toSet()));

        return entity;
    }

}
