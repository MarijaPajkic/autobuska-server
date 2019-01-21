/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.dto.RelacijaDto;
import com.marijapajkic.dto.StajalisteDto;
import com.marijapajkic.dto.VoziloDto;
import com.marijapajkic.dto.ZaposlenDto;
import com.marijapajkic.entiteti.Karta;
import com.marijapajkic.entiteti.Relacija;
import com.marijapajkic.entiteti.Stajaliste;
import com.marijapajkic.entiteti.Vozilo;
import com.marijapajkic.entiteti.Zaposlen;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author marij
 */
public class RelacijaMapper {

    public static RelacijaDto toDto(Relacija entity) {
        if (entity == null) {
            return null;
        }
        RelacijaDto dto = new RelacijaDto();
        dto.setRelacijaId(Short.parseShort("" + entity.getRelacijaId()));
        dto.setVremepolaska(entity.getVremepolaska());
        dto.setVremedolaska(entity.getVremedolaska());
        if (entity.getPolaznostajalisteId() != null) {
            if (entity.getPolaznostajalisteId().getRelacijaCollection() != null && !entity.getPolaznostajalisteId().getRelacijaCollection().isEmpty()) {
                HashSet<Relacija> relacije = new HashSet<>();
                entity.getPolaznostajalisteId().getRelacijaCollection().forEach((relacija) -> {
                    relacije.add(new Relacija(relacija.getRelacijaId()));
                });
                entity.getPolaznostajalisteId().setRelacijaCollection(relacije);
            } else {
                entity.getPolaznostajalisteId().setRelacijaCollection(null);
            }

            if (entity.getPolaznostajalisteId().getRelacijaCollection1() != null && !entity.getPolaznostajalisteId().getRelacijaCollection1().isEmpty()) {
                HashSet<Relacija> relacije = new HashSet<>();
                entity.getPolaznostajalisteId().getRelacijaCollection1().forEach((relacija) -> {
                    relacije.add(new Relacija(relacija.getRelacijaId()));
                });
                entity.getPolaznostajalisteId().setRelacijaCollection1(relacije);
            } else {
                entity.getPolaznostajalisteId().setRelacijaCollection1(null);
            }
        }
        dto.setPolaznostajaliste(StajalisteMapper.toDto(entity.getPolaznostajalisteId()));
        if (entity.getKrajnjestajalisteId() != null) {
            if (entity.getKrajnjestajalisteId().getRelacijaCollection() != null && !entity.getKrajnjestajalisteId().getRelacijaCollection().isEmpty()) {
                HashSet<Relacija> relacije = new HashSet<>();
                entity.getKrajnjestajalisteId().getRelacijaCollection().forEach((relacija) -> {
                    relacije.add(new Relacija(relacija.getRelacijaId()));
                });
                entity.getKrajnjestajalisteId().setRelacijaCollection(relacije);
            } else {
                entity.getKrajnjestajalisteId().setRelacijaCollection(null);
            }

            if (entity.getKrajnjestajalisteId().getRelacijaCollection1() != null && !entity.getKrajnjestajalisteId().getRelacijaCollection1().isEmpty()) {
                HashSet<Relacija> relacije = new HashSet<>();
                entity.getKrajnjestajalisteId().getRelacijaCollection1().forEach((relacija) -> {
                    relacije.add(new Relacija(relacija.getRelacijaId()));
                });
                entity.getKrajnjestajalisteId().setRelacijaCollection1(relacije);
            } else {
                entity.getKrajnjestajalisteId().setRelacijaCollection1(null);
            }
        }
        dto.setKrajnjestajaliste(StajalisteMapper.toDto(entity.getKrajnjestajalisteId()));
        if (entity.getMedjuStajalisteCollection() != null && !entity.getMedjuStajalisteCollection().isEmpty()) {
            dto.setMedjuStajalisteCollection(entity.getMedjuStajalisteCollection().stream().map((medjuStajalisteEntity) -> {
                if (medjuStajalisteEntity.getRelacijaId() != null) {
                    medjuStajalisteEntity.setRelacijaId(new Relacija(medjuStajalisteEntity.getRelacijaId().getRelacijaId()));
                } else {
                    medjuStajalisteEntity.setRelacijaId(null);
                }

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
        if (entity.getTipsaobracajaId() != null) {
            if (entity.getTipsaobracajaId().getRelacijaCollection() != null && !entity.getTipsaobracajaId().getRelacijaCollection().isEmpty()) {
                HashSet<Relacija> relacije = new HashSet<>();
                entity.getTipsaobracajaId().getRelacijaCollection().forEach((relacija) -> {
                    relacije.add(new Relacija(relacija.getRelacijaId()));
                });
                entity.getTipsaobracajaId().setRelacijaCollection(relacije);
            } else {
                entity.getTipsaobracajaId().setRelacijaCollection(null);
            }
        }
        dto.setTipsaobracaja(TipSaobracajaMapper.toDto(entity.getTipsaobracajaId()));
        if (entity.getVoznjaCollection() != null && !entity.getVoznjaCollection().isEmpty()) {
            dto.setVoznjaCollection(entity.getVoznjaCollection().stream().map((voznjaEntity) -> {
                if (voznjaEntity.getKartaCollection() != null && !voznjaEntity.getKartaCollection().isEmpty()) {
                    HashSet<Karta> karte = new HashSet<>();
                    voznjaEntity.getKartaCollection().forEach((karta) -> {
                        karte.add(new Karta(karta.getKartaId()));
                    });
                    voznjaEntity.setKartaCollection(karte);
                } else {
                    voznjaEntity.setKartaCollection(null);
                }
                if (voznjaEntity.getRelacijaId() != null) {
                    voznjaEntity.setRelacijaId(new Relacija(voznjaEntity.getRelacijaId().getRelacijaId()));
                } else {
                    voznjaEntity.setRelacijaId(null);
                }
                if (voznjaEntity.getVoziloId() != null) {
                    voznjaEntity.setVoziloId(new Vozilo(voznjaEntity.getVoziloId().getVoziloId()));
                } else {
                    voznjaEntity.setVoziloId(null);
                }
                if (voznjaEntity.getZaposlenId() != null) {
                    voznjaEntity.setZaposlenId(new Zaposlen(voznjaEntity.getZaposlenId().getZaposlenId()));
                } else {
                    voznjaEntity.setZaposlenId(null);
                }

                return VoznjaMapper.toDto(voznjaEntity);
            }).collect(Collectors.toSet()));
        } else {
            dto.setVoznjaCollection(new HashSet<>());
        }

        return dto;
    }

    public static Relacija toEntity(RelacijaDto dto) {
        if (dto == null) {
            return null;
        }
        Relacija entity = new Relacija();
        entity.setRelacijaId((int) dto.getRelacijaId());
        entity.setVremepolaska(dto.getVremepolaska());
        entity.setVremedolaska(dto.getVremedolaska());
        if (dto.getPolaznostajaliste() != null) {
            if (dto.getPolaznostajaliste().getRelacijaCollection() != null && !dto.getPolaznostajaliste().getRelacijaCollection().isEmpty()) {
                HashSet<RelacijaDto> relacije = new HashSet<>();
                dto.getPolaznostajaliste().getRelacijaCollection().forEach((relacijaDto) -> {
                    relacije.add(new RelacijaDto(relacijaDto.getRelacijaId()));
                });
                dto.getPolaznostajaliste().setRelacijaCollection(relacije);
            } else {
                dto.getPolaznostajaliste().setRelacijaCollection(null);
            }
            if (dto.getPolaznostajaliste().getRelacijaCollection1() != null && !dto.getPolaznostajaliste().getRelacijaCollection1().isEmpty()) {
                HashSet<RelacijaDto> relacije = new HashSet<>();
                dto.getPolaznostajaliste().getRelacijaCollection1().forEach((relacijaDto) -> {
                    relacije.add(new RelacijaDto(relacijaDto.getRelacijaId()));
                });
                dto.getPolaznostajaliste().setRelacijaCollection1(relacije);
            } else {
                dto.getPolaznostajaliste().setRelacijaCollection1(null);
            }
        }
        entity.setPolaznostajalisteId(StajalisteMapper.toEntity(dto.getPolaznostajaliste()));
        if (dto.getKrajnjestajaliste() != null) {
            if (dto.getKrajnjestajaliste().getRelacijaCollection() != null && !dto.getKrajnjestajaliste().getRelacijaCollection().isEmpty()) {
                HashSet<RelacijaDto> relacije = new HashSet<>();
                dto.getKrajnjestajaliste().getRelacijaCollection().forEach((relacijaDto) -> {
                    relacije.add(new RelacijaDto(relacijaDto.getRelacijaId()));
                });
                dto.getKrajnjestajaliste().setRelacijaCollection(relacije);
            } else {
                dto.getKrajnjestajaliste().setRelacijaCollection(null);
            }
            if (dto.getKrajnjestajaliste().getRelacijaCollection1() != null && !dto.getKrajnjestajaliste().getRelacijaCollection1().isEmpty()) {
                HashSet<RelacijaDto> relacije = new HashSet<>();
                dto.getKrajnjestajaliste().getRelacijaCollection1().forEach((relacijaDto) -> {
                    relacije.add(new RelacijaDto(relacijaDto.getRelacijaId()));
                });
                dto.getKrajnjestajaliste().setRelacijaCollection1(relacije);
            } else {
                dto.getKrajnjestajaliste().setRelacijaCollection1(null);
            }
        }
        entity.setKrajnjestajalisteId(StajalisteMapper.toEntity(dto.getKrajnjestajaliste()));
        if (dto.getMedjuStajalisteCollection() != null && !dto.getMedjuStajalisteCollection().isEmpty()) {
            entity.setMedjuStajalisteCollection(dto.getMedjuStajalisteCollection().stream().map((medjuStajalisteDto) -> {
                if (medjuStajalisteDto.getRelacija() != null) {
                    medjuStajalisteDto.setRelacija(new RelacijaDto(medjuStajalisteDto.getRelacija().getRelacijaId()));
                } else {
                    medjuStajalisteDto.setRelacija(null);
                }

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
        if (dto.getTipsaobracaja() != null) {
            if (dto.getTipsaobracaja().getRelacijaCollection() != null && !dto.getTipsaobracaja().getRelacijaCollection().isEmpty()) {
                HashSet<RelacijaDto> relacije = new HashSet<>();
                dto.getTipsaobracaja().getRelacijaCollection().forEach((relacijaDto) -> {
                    relacije.add(new RelacijaDto(relacijaDto.getRelacijaId()));
                });
                dto.getTipsaobracaja().setRelacijaCollection(relacije);
            } else {
                dto.getTipsaobracaja().setRelacijaCollection(null);
            }
        }
        entity.setTipsaobracajaId(TipSaobracajaMapper.toEntity(dto.getTipsaobracaja()));
        if (dto.getVoznjaCollection() != null && !dto.getVoznjaCollection().isEmpty()) {
            entity.setVoznjaCollection(dto.getVoznjaCollection().stream().map((voznjaDto) -> {
                if (voznjaDto.getKartaCollection() != null && !voznjaDto.getKartaCollection().isEmpty()) {
                    HashSet<KartaDto> karte = new HashSet<>();
                    voznjaDto.getKartaCollection().forEach((kartaDto) -> {
                        karte.add(new KartaDto(kartaDto.getKartaId()));
                    });
                    voznjaDto.setKartaCollection(karte);
                } else {
                    voznjaDto.setKartaCollection(null);
                }
                if (voznjaDto.getRelacija() != null) {
                    voznjaDto.setRelacija(new RelacijaDto(voznjaDto.getRelacija().getRelacijaId()));
                } else {
                    voznjaDto.setRelacija(null);
                }
                if (voznjaDto.getVozilo() != null) {
                    voznjaDto.setVozilo(new VoziloDto(voznjaDto.getVozilo().getVoziloId()));
                } else {
                    voznjaDto.setVozilo(null);
                }
                if (voznjaDto.getZaposlen() != null) {
                    voznjaDto.setZaposlen(new ZaposlenDto(voznjaDto.getZaposlen().getZaposlenId()));
                } else {
                    voznjaDto.setZaposlen(null);
                }

                return VoznjaMapper.toEntity(voznjaDto);
            }).collect(Collectors.toSet()));
        } else {
            entity.setVoznjaCollection(new HashSet<>());
        }

        return entity;
    }

}
