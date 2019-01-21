/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.ZanimanjeDto;
import com.marijapajkic.entiteti.Zanimanje;
import com.marijapajkic.mapper.ZanimanjeMapper;
import java.util.ArrayList;
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
@Path("zanimanje")
public class ZanimanjeFacadeREST extends AbstractFacade<Zanimanje> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public ZanimanjeFacadeREST() {
        super(Zanimanje.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createDto(ZanimanjeDto dto) {
        int count = super.count() + 1;
        dto.setZanimanjeId(Short.parseShort("" + count));
        super.create(ZanimanjeMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ZanimanjeDto dto) {
        super.edit(ZanimanjeMapper.toEntity(dto));
    }

    @POST
    @Path("delete/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ZanimanjeDto find(@PathParam("id") Integer id) {
        return ZanimanjeMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ZanimanjeDto> findAllDtos() {
        return super.findAll().stream().map((zanimanjeEntity) -> {
            return ZanimanjeMapper.toDto(zanimanjeEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ZanimanjeDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((zanimanjeEntity) -> {
            return ZanimanjeMapper.toDto(zanimanjeEntity);
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
