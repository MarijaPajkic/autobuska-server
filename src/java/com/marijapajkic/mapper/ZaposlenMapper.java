/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoziloDto;
import com.marijapajkic.dto.ZaposlenDto;
import com.marijapajkic.entiteti.Vozilo;
import com.marijapajkic.entiteti.Zanimanje;
import com.marijapajkic.entiteti.Zaposlen;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
            if (entity.getZanimanjeId().getZaposlenCollection() != null && !entity.getZanimanjeId().getZaposlenCollection().isEmpty()) {
                HashSet<Zaposlen> zaposleni = new HashSet<>();
                entity.getZanimanjeId().getZaposlenCollection().forEach((zaposlen) -> {
                    zaposleni.add(new Zaposlen(zaposlen.getZaposlenId()));
                });
                entity.getZanimanjeId().setZaposlenCollection(zaposleni);
            } else {
                entity.getZanimanjeId().setZaposlenCollection(null);
            }
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
                if (voznjaEntity.getZaposlenId() != null) {
                    voznjaEntity.setZaposlenId(new Zaposlen(voznjaEntity.getZaposlenId().getZaposlenId()));
                } else {
                    voznjaEntity.setZaposlenId(null);
                }
                if (voznjaEntity.getVoziloId() != null) {
                    voznjaEntity.setVoziloId(new Vozilo(voznjaEntity.getVoziloId().getVoziloId()));
                } else {
                    voznjaEntity.setVoziloId(null);
                }
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
            if (entity.getKorisnickinalogId().getZaposlenCollection() != null && !entity.getKorisnickinalogId().getZaposlenCollection().isEmpty()) {
                HashSet<Zaposlen> zaposleni = new HashSet<>();
                entity.getKorisnickinalogId().getZaposlenCollection().forEach((zaposlen) -> {
                    zaposleni.add(new Zaposlen(zaposlen.getZaposlenId()));
                });
                entity.getKorisnickinalogId().setZaposlenCollection(zaposleni);
            } else {
                entity.getKorisnickinalogId().setZaposlenCollection(null);
            }
            if (entity.getKorisnickinalogId().getZaposlenId() != null) {
                entity.getKorisnickinalogId().setZaposlenId(new Zaposlen(entity.getKorisnickinalogId().getZaposlenId().getZaposlenId()));
            } else {
                entity.getKorisnickinalogId().setZaposlenId(null);
            }
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
            if (dto.getZanimanje().getZaposlenCollection() != null && !dto.getZanimanje().getZaposlenCollection().isEmpty()) {
                HashSet<ZaposlenDto> zaposleni = new HashSet<>();
                dto.getZanimanje().getZaposlenCollection().forEach((zaposlen) -> {
                    zaposleni.add(new ZaposlenDto(zaposlen.getZaposlenId()));
                });
                dto.getZanimanje().setZaposlenCollection(zaposleni);
            } else {
                dto.getZanimanje().setZaposlenCollection(null);
            }
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
                if (voznjaDto.getZaposlen() != null) {
                    voznjaDto.setZaposlen(new ZaposlenDto(voznjaDto.getZaposlen().getZaposlenId()));
                } else {
                    voznjaDto.setZaposlen(null);
                }
                if (voznjaDto.getVozilo() != null) {
                    voznjaDto.setVozilo(new VoziloDto(voznjaDto.getVozilo().getVoziloId()));
                } else {
                    voznjaDto.setVozilo(null);
                }
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
            if (dto.getKorisnickinalog().getZaposlenCollection() != null && !dto.getKorisnickinalog().getZaposlenCollection().isEmpty()) {
                HashSet<ZaposlenDto> zaposleni = new HashSet<>();
                dto.getKorisnickinalog().getZaposlenCollection().forEach((zaposlenDto) -> {
                    zaposleni.add(new ZaposlenDto(zaposlenDto.getZaposlenId()));
                });
                dto.getKorisnickinalog().setZaposlenCollection(zaposleni);
            } else {
                dto.getKorisnickinalog().setZaposlenCollection(null);
            }
            if (dto.getKorisnickinalog().getZaposlen() != null) {
                dto.getKorisnickinalog().setZaposlen(new ZaposlenDto(dto.getKorisnickinalog().getZaposlen().getZaposlenId()));
            } else {
                dto.getKorisnickinalog().setZaposlen(null);
            }
        }
        entity.setKorisnickinalogId(KorisnickiNalogMapper.toEntity(dto.getKorisnickinalog()));

        return entity;
    }
}
