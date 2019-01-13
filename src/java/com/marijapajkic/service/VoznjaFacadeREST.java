/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.entiteti.Voznja;
import com.marijapajkic.mapper.VoznjaMapper;
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
@Path("voznja")
public class VoznjaFacadeREST extends AbstractFacade<Voznja> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public VoznjaFacadeREST() {
        super(Voznja.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VoznjaDto dto) {
        super.create(VoznjaMapper.toEntity(dto));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, VoznjaDto dto) {
        super.edit(VoznjaMapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VoznjaDto find(@PathParam("id") String id) {
        return VoznjaMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VoznjaDto> findAllDtos() {
        return super.findAll().stream().map((voznjaEntity) -> {
            return VoznjaMapper.toDto(voznjaEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VoznjaDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((voznjaEntity) -> {
            return VoznjaMapper.toDto(voznjaEntity);
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
