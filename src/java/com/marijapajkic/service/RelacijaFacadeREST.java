/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.RelacijaDto;
import com.marijapajkic.dto.RelacijaSaMedjustajalistimaDto;
import com.marijapajkic.entiteti.Relacija;
import com.marijapajkic.mapper.RelacijaMapper;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marij
 */
@Stateless
@Path("relacija")
public class RelacijaFacadeREST extends AbstractFacade<Relacija> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public RelacijaFacadeREST() {
        super(Relacija.class);
    }
    
//    @POST
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void kreirajSaMedjustajalistima(RelacijaSaMedjustajalistimaDto relacijaSaMedjustajalistimaDto) {
//        int count = super.count() + 1;
//        relacijaSaMedjustajalistimaDto.getRelacija().setRelacijaId(Short.parseShort("" + count));
//        super.create(RelacijaMapper.toEntity(relacijaSaMedjustajalistimaDto.getRelacija())); 
//        
//        relacijaSaMedjustajalistimaDto.getMedjustajalista().forEach((medjustajalisteDto) -> {
//            
//        });
//    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RelacijaDto dto) {
        int count = super.count() + 1;
        dto.setRelacijaId(Short.parseShort("" + count));
        super.create(RelacijaMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, RelacijaDto dto) {
        super.edit(RelacijaMapper.toEntity(dto));
    }

    @POST
    @Path("delete/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RelacijaDto find(@PathParam("id") Integer id) {
        return RelacijaMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RelacijaDto> findAllDtos() {;
        return super.findAll().stream().map((relacijaEntity) -> {
            return RelacijaMapper.toDto(relacijaEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RelacijaDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((relacijaEntity) -> {
            return RelacijaMapper.toDto(relacijaEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
