/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marijapajkic.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author marij
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.marijapajkic.service.DnevnaSmenaFacadeREST.class);
        resources.add(com.marijapajkic.service.KartaFacadeREST.class);
        resources.add(com.marijapajkic.service.KorisnickiNalogFacadeREST.class);
        resources.add(com.marijapajkic.service.MedjuStajalisteFacadeREST.class);
        resources.add(com.marijapajkic.service.PlacanjeFacadeREST.class);
        resources.add(com.marijapajkic.service.RelacijaFacadeREST.class);
        resources.add(com.marijapajkic.service.RezervacijaFacadeREST.class);
        resources.add(com.marijapajkic.service.SmenaFacadeREST.class);
        resources.add(com.marijapajkic.service.StajalisteFacadeREST.class);
        resources.add(com.marijapajkic.service.TipSaobracajaFacadeREST.class);
        resources.add(com.marijapajkic.service.VoziloFacadeREST.class);
        resources.add(com.marijapajkic.service.VoznjaFacadeREST.class);
        resources.add(com.marijapajkic.service.ZanimanjeFacadeREST.class);
        resources.add(com.marijapajkic.service.ZaposlenFacadeREST.class);
    }
    
}
