/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.DnevnaSmenaDto;
import com.marijapajkic.entiteti.DnevnaSmena;
import com.marijapajkic.mapper.DnevnaSmenaMapper;
import java.util.List;
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
@Path("dnevnasmena")
public class DnevnaSmenaFacadeREST extends AbstractFacade<DnevnaSmena> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public DnevnaSmenaFacadeREST() {
        super(DnevnaSmena.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DnevnaSmenaDto dto) {
        super.create(DnevnaSmenaMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, DnevnaSmenaDto dto) {
        super.edit(DnevnaSmenaMapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DnevnaSmenaDto find(@PathParam("id") Integer id) {
        return DnevnaSmenaMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DnevnaSmenaDto> findAllDtos() {
        return super.findAll().stream().map((dnevnaSmenaEntity) -> {
            return DnevnaSmenaMapper.toDto(dnevnaSmenaEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DnevnaSmenaDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((dnevnaSmenaEntity) -> {
            return DnevnaSmenaMapper.toDto(dnevnaSmenaEntity);
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
