/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.AuthRequestDto;
import com.marijapajkic.dto.AuthResponseDto;
import com.marijapajkic.dto.KorisnickiNalogDto;
import com.marijapajkic.entiteti.KorisnickiNalog;
import com.marijapajkic.entiteti.Zaposlen;
import com.marijapajkic.mapper.KorisnickiNalogMapper;
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
@Path("korisnickinalog")
public class KorisnickiNalogFacadeREST extends AbstractFacade<KorisnickiNalog> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    public KorisnickiNalogFacadeREST() {
        super(KorisnickiNalog.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(KorisnickiNalogDto dto) {
        super.create(KorisnickiNalogMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, KorisnickiNalogDto dto) {
        super.edit(KorisnickiNalogMapper.toEntity(dto));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public KorisnickiNalogDto find(@PathParam("id") Integer id) {
        return KorisnickiNalogMapper.toDto(super.find(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<KorisnickiNalogDto> findAllDtos() {
        return super.findAll().stream().map((korisnickinalogEntity) -> {
            return KorisnickiNalogMapper.toDto(korisnickinalogEntity);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<KorisnickiNalogDto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}).stream().map((korisnickinalogEntity) -> {
            return KorisnickiNalogMapper.toDto(korisnickinalogEntity);
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

    @POST
    @Path("auth")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AuthResponseDto checkAuthentication(AuthRequestDto request) {
        System.out.println("CheckAuthentication");
        List<KorisnickiNalog> resultList
                = (List<KorisnickiNalog>) em.createNamedQuery("KorisnickiNalog.findByKorisnickoimeAndKorisnickalozinka")
                        .setParameter("korisnickoime", request.getUsername())
                        .setParameter("korisnickalozinka", request.getPassword()).getResultList();
        if (resultList == null || resultList.isEmpty()) {
            System.out.println("Ne postoji takav korisnik. " + request.getUsername() + " : " + request.getPassword());
            return new AuthResponseDto("anonymous", "");
        }
        AuthResponseDto response = new AuthResponseDto();
        KorisnickiNalog nalog = resultList.get(0);
        Zaposlen zaposlen = null;
        if (nalog.getZaposlenId() != null) {
            zaposlen = nalog.getZaposlenId();
        } else {
            if (!nalog.getZaposlenCollection().isEmpty()) {
                zaposlen = (Zaposlen) nalog.getZaposlenCollection().toArray()[0];
            } else {
                System.out.println("Nije zaposlen, nema collection.");
                return new AuthResponseDto("anonymous", "");
            }
        }
        if (zaposlen == null) {
            System.out.println("Nije zaposlen.");
            return new AuthResponseDto("anonymous", "");
        }
        if (zaposlen.getZanimanjeId() != null) {
            return new AuthResponseDto(nalog.getKorisnickoime(), zaposlen.getZanimanjeId().getNazivzanimanja());
        }
        System.out.println("Nema zanimanje.");
        return new AuthResponseDto("anonymous", "");
    }
}
