/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.PlacanjeDto;
import com.marijapajkic.entiteti.Placanje;
import com.marijapajkic.mapper.PlacanjeMapper;
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
@Path("placanje")
public class PlacanjeFacadeREST extends AbstractFacade<Placanje> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public PlacanjeFacadeREST() {
        super(Placanje.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PlacanjeDto dto) {
        super.create(PlacanjeMapper.toEntity(dto));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, PlacanjeDto dto) {
        super.edit(PlacanjeMapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PlacanjeDto find(@PathParam("id") Integer id) {
        return PlacanjeMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PlacanjeDto> findAllDtos() {;
        return super.findAll().stream().map((placanjeEntity) -> {
            return PlacanjeMapper.toDto(placanjeEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PlacanjeDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((placanjeEntity) -> {
            return PlacanjeMapper.toDto(placanjeEntity);
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
