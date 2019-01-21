/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.StajalisteDto;
import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.entiteti.MedjuStajaliste;
import com.marijapajkic.entiteti.Stajaliste;
import com.marijapajkic.entiteti.Voznja;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class StajalisteMapper {

    public static StajalisteDto toDto(Stajaliste entity) {
        if (entity == null) {
            return null;
        }
        StajalisteDto dto = new StajalisteDto();
        dto.setStajalisteId(Short.parseShort("" + entity.getStajalisteId()));
        dto.setNazivstajalista(entity.getNazivstajalista());
        if (entity.getRelacijaCollection1() != null && !entity.getRelacijaCollection1().isEmpty()) {
            dto.setRelacijaCollection1(entity.getRelacijaCollection1().stream().map((relacijaEntity1) -> {
                if (relacijaEntity1.getPolaznostajalisteId() != null) {
                    relacijaEntity1.setPolaznostajalisteId(new Stajaliste(relacijaEntity1.getPolaznostajalisteId().getStajalisteId()));
                } else {
                    relacijaEntity1.setPolaznostajalisteId(null);
                }
                if (relacijaEntity1.getKrajnjestajalisteId() != null) {
                    relacijaEntity1.setKrajnjestajalisteId(new Stajaliste(relacijaEntity1.getKrajnjestajalisteId().getStajalisteId()));
                } else {
                    relacijaEntity1.setKrajnjestajalisteId(null);
                }
                if (relacijaEntity1.getMedjuStajalisteCollection() != null && !relacijaEntity1.getMedjuStajalisteCollection().isEmpty()) {
                    HashSet<MedjuStajaliste> medjustajalista = new HashSet<>();
                    relacijaEntity1.getMedjuStajalisteCollection().forEach((medjuStajaliste) -> {
                        medjustajalista.add(new MedjuStajaliste(medjuStajaliste.getMedjustajalisteId()));
                    });
                    relacijaEntity1.setMedjuStajalisteCollection(medjustajalista);
                } else {
                    relacijaEntity1.setMedjuStajalisteCollection(null);
                }
                if (relacijaEntity1.getVoznjaCollection() != null && !relacijaEntity1.getVoznjaCollection().isEmpty()) {
                    HashSet<Voznja> voznje = new HashSet<>();
                    relacijaEntity1.getVoznjaCollection().forEach((voznja) -> {
                        voznje.add(new Voznja(voznja.getVoznjaId()));
                    });
                    relacijaEntity1.setVoznjaCollection(voznje);
                } else {
                    relacijaEntity1.setVoznjaCollection(null);
                }
                return RelacijaMapper.toDto(relacijaEntity1);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRelacijaCollection1(new HashSet<>());
        }
        if (entity.getRelacijaCollection() != null && !entity.getRelacijaCollection().isEmpty()) {
            dto.setRelacijaCollection(entity.getRelacijaCollection().stream().map((relacijaEntity) -> {
                if (relacijaEntity.getPolaznostajalisteId() != null) {
                    relacijaEntity.setPolaznostajalisteId(new Stajaliste(relacijaEntity.getPolaznostajalisteId().getStajalisteId()));
                } else {
                    relacijaEntity.setPolaznostajalisteId(null);
                }
                if (relacijaEntity.getKrajnjestajalisteId() != null) {
                    relacijaEntity.setKrajnjestajalisteId(new Stajaliste(relacijaEntity.getKrajnjestajalisteId().getStajalisteId()));
                } else {
                    relacijaEntity.setKrajnjestajalisteId(null);
                }
                if (relacijaEntity.getMedjuStajalisteCollection() != null && !relacijaEntity.getMedjuStajalisteCollection().isEmpty()) {
                    HashSet<MedjuStajaliste> medjustajalista = new HashSet<>();
                    relacijaEntity.getMedjuStajalisteCollection().forEach((medjuStajaliste) -> {
                        medjustajalista.add(new MedjuStajaliste(medjuStajaliste.getMedjustajalisteId()));
                    });
                    relacijaEntity.setMedjuStajalisteCollection(medjustajalista);
                } else {
                    relacijaEntity.setMedjuStajalisteCollection(null);
                }
                if (relacijaEntity.getVoznjaCollection() != null && !relacijaEntity.getVoznjaCollection().isEmpty()) {
                    HashSet<Voznja> voznje = new HashSet<>();
                    relacijaEntity.getVoznjaCollection().forEach((voznja) -> {
                        voznje.add(new Voznja(voznja.getVoznjaId()));
                    });
                    relacijaEntity.setVoznjaCollection(voznje);
                } else {
                    relacijaEntity.setVoznjaCollection(null);
                }
                return RelacijaMapper.toDto(relacijaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRelacijaCollection(new HashSet<>());
        }
        if (entity.getMedjuStajalisteCollection() != null && !entity.getMedjuStajalisteCollection().isEmpty()) {
            dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
                if (medjuStajalisteEntity.getStajalisteId() != null) {
                    medjuStajalisteEntity.setStajalisteId(new Stajaliste(medjuStajalisteEntity.getStajalisteId().getStajalisteId()));
                } else {
                    medjuStajalisteEntity.setStajalisteId(null);
                }
                return MedjuStajalisteMapper.toDto(medjuStajalisteEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setMedjuStajalisteCollection(new HashSet<>());
        }

        return dto;
    }

    public static Stajaliste toEntity(StajalisteDto dto) {
        if (dto == null) {
            return null;
        }
        Stajaliste entity = new Stajaliste();
        entity.setStajalisteId((int) dto.getStajalisteId());
        entity.setNazivstajalista(dto.getNazivstajalista());
        if (dto.getRelacijaCollection1() != null && !dto.getRelacijaCollection1().isEmpty()) {
            entity.setRelacijaCollection1(dto.getRelacijaCollection1().stream().map((relacijaDto1) -> {
                if (relacijaDto1.getPolaznostajaliste() != null) {
                    relacijaDto1.setPolaznostajaliste(new StajalisteDto(relacijaDto1.getPolaznostajaliste().getStajalisteId()));
                } else {
                    relacijaDto1.setPolaznostajaliste(null);
                }

                if (relacijaDto1.getKrajnjestajaliste() != null) {
                    relacijaDto1.setKrajnjestajaliste(new StajalisteDto(relacijaDto1.getKrajnjestajaliste().getStajalisteId()));
                } else {
                    relacijaDto1.setKrajnjestajaliste(null);
                }
                if (relacijaDto1.getVoznjaCollection() != null && !relacijaDto1.getVoznjaCollection().isEmpty()) {
                    HashSet<VoznjaDto> voznje = new HashSet<>();
                    relacijaDto1.getVoznjaCollection().forEach((voznja) -> {
                        voznje.add(new VoznjaDto(voznja.getVoznjaId()));
                    });
                    relacijaDto1.setVoznjaCollection(voznje);
                } else {
                    relacijaDto1.setVoznjaCollection(null);
                }
                return RelacijaMapper.toEntity(relacijaDto1);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRelacijaCollection1(new HashSet<>());
        }
        if (dto.getRelacijaCollection() != null && !dto.getRelacijaCollection().isEmpty()) {
            entity.setRelacijaCollection(dto.getRelacijaCollection().stream().map((relacijaDto) -> {
                if (relacijaDto.getPolaznostajaliste() != null) {
                    relacijaDto.setPolaznostajaliste(new StajalisteDto(relacijaDto.getPolaznostajaliste().getStajalisteId()));
                } else {
                    relacijaDto.setPolaznostajaliste(null);
                }

                if (relacijaDto.getKrajnjestajaliste() != null) {
                    relacijaDto.setKrajnjestajaliste(new StajalisteDto(relacijaDto.getKrajnjestajaliste().getStajalisteId()));
                } else {
                    relacijaDto.setKrajnjestajaliste(null);
                }
                if (relacijaDto.getVoznjaCollection() != null && !relacijaDto.getVoznjaCollection().isEmpty()) {
                    HashSet<VoznjaDto> voznje = new HashSet<>();
                    relacijaDto.getVoznjaCollection().forEach((voznja) -> {
                        voznje.add(new VoznjaDto(voznja.getVoznjaId()));
                    });
                    relacijaDto.setVoznjaCollection(voznje);
                } else {
                    relacijaDto.setVoznjaCollection(null);
                }
                return RelacijaMapper.toEntity(relacijaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRelacijaCollection(new HashSet<>());
        }
        if (dto.getMedjuStajalisteCollection() != null && !dto.getMedjuStajalisteCollection().isEmpty()) {
            entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
                if (medjuStajalisteDto.getStajaliste() != null) {
                    medjuStajalisteDto.setStajaliste(new StajalisteDto(medjuStajalisteDto.getStajaliste().getStajalisteId()));
                } else {
                    medjuStajalisteDto.setStajaliste(null);
                }
                return MedjuStajalisteMapper.toEntity(medjuStajalisteDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setMedjuStajalisteCollection(new HashSet<>());
        }

        return entity;
    }

}
