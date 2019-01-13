/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoziloDto;
import com.marijapajkic.dto.ZaposlenDto;
import com.marijapajkic.entiteti.Zaposlen;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class ZaposlenMapper {

    public static ZaposlenDto toDto(Zaposlen entity) {
        ZaposlenDto dto = new ZaposlenDto();
        dto.setIme(entity.getIme());
        dto.setPrezime(entity.getPrezime());
        dto.setJmbg(Short.parseShort("" + entity.getJmbg()));
        dto.setAdresaprebivalista(entity.getAdresaprebivalista());
        dto.setKontakttelefon(Short.parseShort("" + entity.getKontakttelefon()));
        dto.setDatumzaposljavanja(entity.getDatumzaposljavanja());
        dto.setStatus(entity.getStatus());
        dto.setZanimanje(ZanimanjeMapper.toDto(entity.getZanimanjeId()));
        dto.setVoziloCollection(entity.getVoziloCollection().stream().map((voziloEntity) -> {
            return VoziloMapper.toDto(voziloEntity);
        }).collect(Collectors.toSet()));
        dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
            return VoznjaMapper.toDto(voznjaEntity);
        }).collect(Collectors.toSet()));
        dto.setDnevnaSmenaCollection(entity.getDnevnaSmenaCollection().stream().map((dnevnasmenaEntity) -> {
            return DnevnaSmenaMapper.toDto(dnevnasmenaEntity);
        }).collect(Collectors.toSet()));
        dto.setKorisnickiNalogCollection(entity.getKorisnickiNalogCollection().stream().map((korisnickinalogEntity) -> {
            return KorisnickiNalogMapper.toDto(korisnickinalogEntity);
        }).collect(Collectors.toSet()));
        dto.setZaposlenId(Short.parseShort("" + entity.getZaposlenId()));
        dto.setKorisnickinalog(KorisnickiNalogMapper.toDto(entity.getKorisnickinalogId()));

        return dto;
    }

    public static Zaposlen toEntity(ZaposlenDto dto) {
        Zaposlen entity = new Zaposlen();
        entity.setIme(dto.getIme());
        entity.setPrezime(dto.getPrezime());
        entity.setJmbg((int) dto.getJmbg());
        entity.setAdresaprebivalista(dto.getAdresaprebivalista());
        entity.setKontakttelefon((int) dto.getKontakttelefon());
        entity.setDatumzaposljavanja(dto.getDatumzaposljavanja());
        entity.setStatus(dto.getStatus());
        entity.setZanimanjeId(ZanimanjeMapper.toEntity(dto.getZanimanje()));
        entity.setVoziloCollection(dto.getVoziloCollection().stream().map((voziloDto) -> {
            return VoziloMapper.toEntity(voziloDto);
        }).collect(Collectors.toSet()));
        entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
            return VoznjaMapper.toEntity(voznjaDto);
        }).collect(Collectors.toSet()));
        entity.setDnevnaSmenaCollection(dto.getDnevnaSmenaCollection().stream().map((dnevnasmenaDto) -> {
            return DnevnaSmenaMapper.toEntity(dnevnasmenaDto);
        }).collect(Collectors.toSet()));
        entity.setKorisnickiNalogCollection(dto.getKorisnickiNalogCollection().stream().map((korisnickinalogDto) -> {
            return KorisnickiNalogMapper.toEntity(korisnickinalogDto);
        }).collect(Collectors.toSet()));
        entity.setZaposlenId((int) dto.getZaposlenId());
        entity.setKorisnickinalogId(KorisnickiNalogMapper.toEntity(dto.getKorisnickinalog()));

        return entity;
    }
}
