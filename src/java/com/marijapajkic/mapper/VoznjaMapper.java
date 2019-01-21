/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.mapper;

import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.dto.ZaposlenDto;
import com.marijapajkic.entiteti.Voznja;
import com.marijapajkic.entiteti.Zaposlen;
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
        if (entity.getBrojkola() != null) {
            dto.setBrojkola(Short.parseShort("" + entity.getBrojkola()));
        }
        dto.setDatumvoznje(entity.getDatumvoznje());
        if (entity.getRelacijaId() != null) {
            if (entity.getRelacijaId().getVoznjaCollection() != null && !entity.getRelacijaId().getVoznjaCollection().isEmpty()) {
                HashSet<Voznja> voznje = new HashSet<>();
                entity.getRelacijaId().getVoznjaCollection().forEach((voznja) -> {
                    voznje.add(new Voznja(voznja.getVoznjaId()));
                });
                entity.getRelacijaId().setVoznjaCollection(voznje);
            } else {
                entity.getRelacijaId().setVoznjaCollection(null);
            }
        }
        dto.setRelacija(RelacijaMapper.toDto(entity.getRelacijaId()));
        if (entity.getVoziloId() != null) {
            if (entity.getVoziloId().getVoznjaCollection() != null && !entity.getVoziloId().getVoznjaCollection().isEmpty()) {
                HashSet<Voznja> voznje = new HashSet<>();
                entity.getVoziloId().getVoznjaCollection().forEach((voznja) -> {
                    voznje.add(new Voznja(voznja.getVoznjaId()));
                });
                entity.getVoziloId().setVoznjaCollection(voznje);

                if (entity.getVoziloId().getZaposlenId() != null) {
                    entity.getVoziloId().setZaposlenId(new Zaposlen(entity.getVoziloId().getZaposlenId().getZaposlenId()));
                } else {
                    entity.getVoziloId().setZaposlenId(null);
                }
            } else {
                entity.getVoziloId().setVoznjaCollection(null);
            }
        }
        dto.setVozilo(VoziloMapper.toDto(entity.getVoziloId()));
        if (entity.getZaposlenId() != null) {
            if (entity.getZaposlenId().getVoznjaCollection() != null && !entity.getZaposlenId().getVoznjaCollection().isEmpty()) {
                HashSet<Voznja> voznje = new HashSet<>();
                entity.getZaposlenId().getVoznjaCollection().forEach((voznja) -> {
                    voznje.add(new Voznja(voznja.getVoznjaId()));
                });
                entity.getZaposlenId().setVoznjaCollection(voznje);
            } else {
                entity.getZaposlenId().setVoznjaCollection(null);
            }
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
            if (dto.getRelacija().getVoznjaCollection() != null && !dto.getRelacija().getVoznjaCollection().isEmpty()) {
                HashSet<VoznjaDto> voznje = new HashSet<>();
                dto.getRelacija().getVoznjaCollection().forEach((voznjaDto) -> {
                    voznje.add(new VoznjaDto(voznjaDto.getVoznjaId()));
                });
                dto.getRelacija().setVoznjaCollection(voznje);
            } else {
                dto.getRelacija().setVoznjaCollection(null);
            }
        }
        entity.setRelacijaId(RelacijaMapper.toEntity(dto.getRelacija()));
        if (dto.getVozilo() != null) {
            if (dto.getVozilo().getVoznjaCollection() != null && !dto.getVozilo().getVoznjaCollection().isEmpty()) {
                HashSet<VoznjaDto> voznje = new HashSet<>();
                dto.getVozilo().getVoznjaCollection().forEach((voznjaDto) -> {
                    voznje.add(new VoznjaDto(voznjaDto.getVoznjaId()));
                });
                dto.getVozilo().setVoznjaCollection(voznje);

                if (dto.getVozilo().getZaposlen() != null) {
                    dto.getVozilo().setZaposlen(new ZaposlenDto(dto.getVozilo().getZaposlen().getZaposlenId()));
                } else {
                    dto.getVozilo().setZaposlen(null);
                }
            } else {
                dto.getVozilo().setVoznjaCollection(null);
            }
        }
        entity.setVoziloId(VoziloMapper.toEntity(dto.getVozilo()));
        if (dto.getZaposlen() != null) {
            if (dto.getZaposlen().getVoznjaCollection() != null && !dto.getZaposlen().getVoznjaCollection().isEmpty()) {
                HashSet<VoznjaDto> voznje = new HashSet<>();
                dto.getZaposlen().getVoznjaCollection().forEach((voznjaDto) -> {
                    voznje.add(new VoznjaDto(voznjaDto.getVoznjaId()));
                });
                dto.getZaposlen().setVoznjaCollection(voznje);
            } else {
                dto.getZaposlen().setVoznjaCollection(null);
            }
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
