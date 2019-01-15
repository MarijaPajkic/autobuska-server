/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.ZaposlenDto;
import com.marijapajkic.entiteti.Zaposlen;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class ZaposlenMapper {

    public static ZaposlenDto toDto(Zaposlen entity) {
        if (entity == null) {
            return null;
        }
        ZaposlenDto dto = new ZaposlenDto();
        dto.setIme(entity.getIme());
        dto.setPrezime(entity.getPrezime());
        dto.setJmbg(entity.getJmbg());
        dto.setAdresaprebivalista(entity.getAdresaprebivalista());
        dto.setKontakttelefon(entity.getKontakttelefon());
        dto.setDatumzaposljavanja(entity.getDatumzaposljavanja());
        dto.setStatus(entity.getStatus());
        if (entity.getZanimanjeId() != null) {
            entity.getZanimanjeId().setZaposlenCollection(null);
        }
        dto.setZanimanje(ZanimanjeMapper.toDto(entity.getZanimanjeId()));
        if (entity.getVoziloCollection() != null && !entity.getVoziloCollection().isEmpty()) {
            dto.setVoziloCollection(entity.getVoziloCollection().stream().map((voziloEntity) -> {
                return VoziloMapper.toDto(voziloEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setVoziloCollection(new HashSet<>());
        }
        if (entity.getVoznjaCollection() != null && !entity.getVoznjaCollection().isEmpty()) {
            dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
                return VoznjaMapper.toDto(voznjaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setVoznjaCollection(new HashSet<>());
        }
        if (entity.getDnevnaSmenaCollection() != null && !entity.getDnevnaSmenaCollection().isEmpty()) {
            dto.setDnevnaSmenaCollection(entity.getDnevnaSmenaCollection().stream().map((dnevnasmenaEntity) -> {
                return DnevnaSmenaMapper.toDto(dnevnasmenaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setDnevnaSmenaCollection(new HashSet<>());
        }
        if (entity.getKorisnickiNalogCollection() != null && !entity.getKorisnickiNalogCollection().isEmpty()) {
            dto.setKorisnickiNalogCollection(entity.getKorisnickiNalogCollection().stream().map((korisnickinalogEntity) -> {
                return KorisnickiNalogMapper.toDto(korisnickinalogEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setKorisnickiNalogCollection(new HashSet<>());
        }
        dto.setZaposlenId(Short.parseShort("" + entity.getZaposlenId()));
        if (entity.getKorisnickinalogId() != null) {
            entity.getKorisnickinalogId().setZaposlenCollection(null);
            entity.getKorisnickinalogId().setZaposlenId(null);
        }
        dto.setKorisnickinalog(KorisnickiNalogMapper.toDto(entity.getKorisnickinalogId()));

        return dto;
    }

    public static Zaposlen toEntity(ZaposlenDto dto) {
        if (dto == null) {
            return null;
        }
        Zaposlen entity = new Zaposlen();
        entity.setIme(dto.getIme());
        entity.setPrezime(dto.getPrezime());
        entity.setJmbg(dto.getJmbg());
        entity.setAdresaprebivalista(dto.getAdresaprebivalista());
        entity.setKontakttelefon(dto.getKontakttelefon());
        entity.setDatumzaposljavanja(dto.getDatumzaposljavanja());
        entity.setStatus(dto.getStatus());
        if (dto.getZanimanje() != null) {
            dto.getZanimanje().setZaposlenCollection(null);
        }
        entity.setZanimanjeId(ZanimanjeMapper.toEntity(dto.getZanimanje()));
        if (dto.getVoziloCollection() != null && !dto.getVoziloCollection().isEmpty()) {
            entity.setVoziloCollection(dto.getVoziloCollection().stream().map((voziloDto) -> {
                return VoziloMapper.toEntity(voziloDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setVoziloCollection(new HashSet<>());
        }
        if (dto.getVoznjaCollection() != null && !dto.getVoznjaCollection().isEmpty()) {
            entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
                return VoznjaMapper.toEntity(voznjaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setVoznjaCollection(new HashSet<>());
        }
        if (dto.getDnevnaSmenaCollection() != null && !dto.getDnevnaSmenaCollection().isEmpty()) {
            entity.setDnevnaSmenaCollection(dto.getDnevnaSmenaCollection().stream().map((dnevnasmenaDto) -> {
                return DnevnaSmenaMapper.toEntity(dnevnasmenaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setDnevnaSmenaCollection(new HashSet<>());
        }
        if (dto.getKorisnickiNalogCollection() != null && !dto.getKorisnickiNalogCollection().isEmpty()) {
            entity.setKorisnickiNalogCollection(dto.getKorisnickiNalogCollection().stream().map((korisnickinalogDto) -> {
                return KorisnickiNalogMapper.toEntity(korisnickinalogDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setKorisnickiNalogCollection(new HashSet<>());
        }
        entity.setZaposlenId((int) dto.getZaposlenId());
        if (dto.getKorisnickinalog() != null) {
            dto.getKorisnickinalog().setZaposlen(null);
            dto.getKorisnickinalog().setZaposlenCollection(null);
        }
        entity.setKorisnickinalogId(KorisnickiNalogMapper.toEntity(dto.getKorisnickinalog()));

        return entity;
    }
}
