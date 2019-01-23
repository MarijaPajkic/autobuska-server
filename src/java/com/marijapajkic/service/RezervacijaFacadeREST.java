/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import com.marijapajkic.dto.KartaDto;
import com.marijapajkic.dto.PlacanjeDto;
import com.marijapajkic.dto.RezervacijaCompleteDto;
import com.marijapajkic.dto.RezervacijaDto;
import com.marijapajkic.dto.VoznjaDto;
import com.marijapajkic.entiteti.Rezervacija;
import com.marijapajkic.mapper.RezervacijaMapper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("rezervacija")
public class RezervacijaFacadeREST extends AbstractFacade<Rezervacija> {

    @PersistenceContext(unitName = "AutobuskaWebServicePU")
    private EntityManager em;

    @Inject
    private PlacanjeFacadeREST placanjeFacadeREST;

    @Inject
    private KartaFacadeREST kartaFacadeREST;

    @Inject
    private VoznjaFacadeREST voznjaFacadeREST;

    public RezervacijaFacadeREST() {
        super(Rezervacija.class);
    }

    @POST
//    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RezervacijaDto dto) {
        int count = super.count() + 1;
        dto.setRezervacijaId(Short.parseShort("" + count));
        super.create(RezervacijaMapper.toEntity(dto));
    }

    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Rezervacija entity) {
        super.edit(entity);
    }

    @POST
    @Path("delete/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RezervacijaDto find(@PathParam("id") Integer id) {
        return RezervacijaMapper.toDto(super.find(id));
    }

    @GET
//    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RezervacijaDto> findAllDtos() {
        return super.findAll().stream().map((rezervacija) -> {
            return RezervacijaMapper.toDto(rezervacija);
        }).collect(Collectors.toList());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Rezervacija> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
    @Path("createcomplete")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createComplete(RezervacijaCompleteDto rezervacijaCompleteDto) {
        Date datum = Date.from(Instant.now()); // trenutni datum
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        String vreme = localDateTime.getHour() + ":" + localDateTime.getMinute();
        VoznjaDto voznjaDto = this.voznjaFacadeREST.find(rezervacijaCompleteDto.getVoznjaId());

        PlacanjeDto placanjeDto = new PlacanjeDto(Short.parseShort("0"), rezervacijaCompleteDto.getTipplacanja(), datum, vreme, null, null);
        this.placanjeFacadeREST.create(placanjeDto);

        // kreiraj Karta
        KartaDto karta = new KartaDto(Short.parseShort("0"), rezervacijaCompleteDto.getPrevoznik(),
                rezervacijaCompleteDto.getRelacija(), rezervacijaCompleteDto.getDatumpolaska(),
                voznjaDto.getRelacija() != null ? voznjaDto.getRelacija().getVremepolaska() : "00:00",
                rezervacijaCompleteDto.getBrojsedista(), rezervacijaCompleteDto.getPeron(), rezervacijaCompleteDto.getCena(),
                rezervacijaCompleteDto.getPopust(), rezervacijaCompleteDto.getStanicnausluga(), null, null, null, null);

        PlacanjeDto poslednjePlacanje = this.placanjeFacadeREST.find(this.placanjeFacadeREST.count());
        karta.setPlacanje(poslednjePlacanje);
        Set<PlacanjeDto> placanjeCollection = new HashSet<>();
        placanjeCollection.add(poslednjePlacanje);
        karta.setPlacanjeCollection(placanjeCollection);
        karta.setVoznja(voznjaDto);
        this.kartaFacadeREST.create(karta);

        // Edit Placanje sa podatkom o Karta
        poslednjePlacanje = this.placanjeFacadeREST.find(this.placanjeFacadeREST.count());
        poslednjePlacanje.setKarta(this.kartaFacadeREST.find(this.kartaFacadeREST.count()));
        Set<KartaDto> kartaCollection = new HashSet<>();
        kartaCollection.add(poslednjePlacanje.getKarta());
        poslednjePlacanje.setKartaCollection(kartaCollection);
        this.placanjeFacadeREST.edit(this.placanjeFacadeREST.count(), poslednjePlacanje);

        // kreiraj Rezervacija
        RezervacijaDto rezervacijaDto = new RezervacijaDto(Short.parseShort("0"), datum, vreme,
                rezervacijaCompleteDto.getTiprezervisanja(), poslednjePlacanje.getKarta());
        this.create(rezervacijaDto);

        // Karta .setRezervacijaCollection
        karta = this.kartaFacadeREST.find(this.kartaFacadeREST.count());
        Set<RezervacijaDto> rezervacijaCollection = new HashSet<>();
        rezervacijaCollection.add(this.find(this.count()));
        karta.setRezervacijaCollection(rezervacijaCollection);
        this.kartaFacadeREST.edit(this.kartaFacadeREST.count(), karta);
    }

}
