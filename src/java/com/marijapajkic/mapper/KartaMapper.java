/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.entiteti.Karta;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class KartaMapper {

    public static KartaDto toDto(Karta entity) {
        if (entity == null) {
            return null;
        }
        KartaDto dto = new KartaDto();
        dto.setKartaId(Short.parseShort("" + entity.getKartaId()));
        dto.setPrevoznik(entity.getPrevoznik());
        dto.setRelacija(entity.getRelacija());
        if (entity.getRezervacijaCollection() != null && !entity.getRezervacijaCollection().isEmpty()) {
            dto.setRezervacijaCollection(entity.getRezervacijaCollection().stream().map((rezervacijaEntity) -> {
                if (rezervacijaEntity.getKartaId() != null) {
                    rezervacijaEntity.setKartaId(new Karta(rezervacijaEntity.getKartaId().getKartaId()));
                } else {
                    rezervacijaEntity.setKartaId(null);
                }
                return RezervacijaMapper.toDto(rezervacijaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setRezervacijaCollection(new HashSet<>());
        }
        dto.setDatumpolaska(entity.getDatumpolaska());
        dto.setVremepolaska(entity.getVremepolaska());
        if (entity.getBrojsedista() == null) {
            dto.setBrojsedista((short) 0);
        } else {
            dto.setBrojsedista(Short.parseShort("" + entity.getBrojsedista()));
        }
        if (entity.getPeron() == null) {
            dto.setPeron((short) 0);
        } else {
            dto.setPeron(Short.parseShort("" + entity.getPeron()));
        }

        if (entity.getCena() == null) {
            dto.setCena((short) 0);
        } else {
            dto.setCena(Short.parseShort("" + entity.getCena()));
        }

        dto.setPopust(entity.getPopust());

        if (entity.getStanicnausluga() == null) {
            dto.setStanicnausluga((short) 0);
        } else {
            dto.setStanicnausluga(Short.parseShort("" + entity.getStanicnausluga()));
        }

        if (entity.getPlacanjeId() != null) {
            if (entity.getPlacanjeId().getKartaCollection() != null && !entity.getPlacanjeId().getKartaCollection().isEmpty()) {
                HashSet<Karta> karte = new HashSet<>();
                entity.getPlacanjeId().getKartaCollection().forEach((karta) -> {
                    karte.add(new Karta(karta.getKartaId()));
                });
                entity.getPlacanjeId().setKartaCollection(karte);
            } else {
                entity.getPlacanjeId().setKartaCollection(null);
            }
            if (entity.getPlacanjeId().getKartaId() != null) {
                entity.getPlacanjeId().setKartaId(new Karta(entity.getPlacanjeId().getKartaId().getKartaId()));
            } else {
                entity.getPlacanjeId().setKartaId(null);
            }
        }
        dto.setPlacanje(PlacanjeMapper.toDto(entity.getPlacanjeId()));
        if (entity.getPlacanjeCollection() != null && !entity.getPlacanjeCollection().isEmpty()) {
            dto.setPlacanjeCollection(entity.getPlacanjeCollection().stream().map((placanjeEntity) -> {
                return PlacanjeMapper.toDto(placanjeEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setPlacanjeCollection(new HashSet<>());
        }
        if (entity.getVoznjaId() != null) {
            if (entity.getVoznjaId().getKartaCollection() != null && !entity.getVoznjaId().getKartaCollection().isEmpty()) {
                HashSet<Karta> karte = new HashSet<>();
                entity.getVoznjaId().getKartaCollection().forEach((karta) -> {
                    karte.add(new Karta(karta.getKartaId()));
                });
                entity.getVoznjaId().setKartaCollection(karte);
            } else {
                entity.getVoznjaId().setKartaCollection(null);
            }
        }
        dto.setVoznja(VoznjaMapper.toDto(entity.getVoznjaId()));

        return dto;

    }

    public static Karta toEntity(KartaDto dto) {
        if (dto == null) {
            return null;
        }
        Karta entity = new Karta();
        entity.setKartaId((int) dto.getKartaId());
        entity.setPrevoznik(dto.getPrevoznik());
        entity.setRelacija(dto.getRelacija());
        if (dto.getRezervacijaCollection() != null && !dto.getRezervacijaCollection().isEmpty()) {
            entity.setRezervacijaCollection(dto.getRezervacijaCollection().stream().map((rezervacijaDto) -> {
                if (rezervacijaDto.getKarta() != null) {
                    rezervacijaDto.setKarta(new KartaDto(rezervacijaDto.getKarta().getKartaId()));
                } else {
                    rezervacijaDto.setKarta(null);
                }
                return RezervacijaMapper.toEntity(rezervacijaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setRezervacijaCollection(new HashSet<>());
        }
        entity.setDatumpolaska(dto.getDatumpolaska());
        entity.setVremepolaska(dto.getVremepolaska());
        entity.setBrojsedista((int) dto.getBrojsedista());
        entity.setPeron((int) dto.getPeron());
        entity.setCena(dto.getCena());
        entity.setPopust(dto.getPopust());
        entity.setStanicnausluga(dto.getStanicnausluga());
        if (dto.getPlacanje() != null) {
            if (dto.getPlacanje().getKartaCollection() != null && !dto.getPlacanje().getKartaCollection().isEmpty()) {
                HashSet<KartaDto> karte = new HashSet<>();
                dto.getPlacanje().getKartaCollection().forEach((kartaDto) -> {
                    karte.add(new KartaDto(kartaDto.getKartaId()));
                });
                dto.getPlacanje().setKartaCollection(karte);
            } else {
                dto.getPlacanje().setKartaCollection(null);
            }
            if (dto.getPlacanje().getKarta() != null) {
                dto.getPlacanje().setKarta(new KartaDto(dto.getPlacanje().getKarta().getKartaId()));
            } else {
                dto.getPlacanje().setKarta(null);
            }
        }
        entity.setPlacanjeId(PlacanjeMapper.toEntity(dto.getPlacanje()));
        if (dto.getPlacanjeCollection() != null && !dto.getPlacanjeCollection().isEmpty()) {
            entity.setPlacanjeCollection(dto.getPlacanjeCollection().stream().map((placanjeDto) -> {
                return PlacanjeMapper.toEntity(placanjeDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setPlacanjeCollection(new HashSet<>());
        }
        if (dto.getVoznja() != null) {
            if (dto.getVoznja().getKartaCollection() != null && !dto.getVoznja().getKartaCollection().isEmpty()) {
                HashSet<KartaDto> karte = new HashSet<>();
                dto.getVoznja().getKartaCollection().forEach((kartaDto) -> {
                    karte.add(new KartaDto(kartaDto.getKartaId()));
                });
                dto.getVoznja().setKartaCollection(karte);
            } else {
                dto.getVoznja().setKartaCollection(null);
            }
        }
        entity.setVoznjaId(VoznjaMapper.toEntity(dto.getVoznja()));

        return entity;
    }
}
