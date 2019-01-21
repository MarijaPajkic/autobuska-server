/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.TipSaobracajaDto;
import com.marijapajkic.entiteti.TipSaobracaja;
import com.marijapajkic.mapper.TipSaobracajaMapper;
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
@Path("tipsaobracaja")
public class TipSaobracajaFacadeREST extends AbstractFacade<TipSaobracaja> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public TipSaobracajaFacadeREST() {
        super(TipSaobracaja.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TipSaobracajaDto dto) {
        int count = super.count() + 1;
        dto.setTipsaobracajaId(Short.parseShort("" + count));
        super.create(TipSaobracajaMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TipSaobracajaDto dto) {
        super.edit(TipSaobracajaMapper.toEntity(dto));
    }

    @POST
    @Path("delete/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TipSaobracajaDto find(@PathParam("id") Integer id) {
        return TipSaobracajaMapper.toDto(super.find(id));
    }

    @GET

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TipSaobracajaDto> findAllDtos() {
        return super.findAll().stream().map((tipsaobracajaEntity) -> {
            return TipSaobracajaMapper.toDto(tipsaobracajaEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TipSaobracajaDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((tipsaobracajaEntity) -> {
            return TipSaobracajaMapper.toDto(tipsaobracajaEntity);
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
