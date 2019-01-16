/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.MedjuStajalisteDto;
import com.marijapajkic.entiteti.MedjuStajaliste;
import com.marijapajkic.mapper.MedjuStajalisteMapper;
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
@Path("medjustajaliste")
public class MedjuStajalisteFacadeREST extends AbstractFacade<MedjuStajaliste> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public MedjuStajalisteFacadeREST() {
        super(MedjuStajaliste.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(MedjuStajalisteDto dto) {
        super.create(MedjuStajalisteMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, MedjuStajalisteDto dto) {
        super.edit(MedjuStajalisteMapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public MedjuStajalisteDto find(@PathParam("id") Integer id) {
        return MedjuStajalisteMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MedjuStajalisteDto> findAllDtos() {
        return super.findAll().stream().map((medjustajalisteEntity) -> {
            return MedjuStajalisteMapper.toDto(medjustajalisteEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MedjuStajalisteDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((medjustajalisteEntity) -> {
            return MedjuStajalisteMapper.toDto(medjustajalisteEntity);
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
