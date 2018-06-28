package io.tabletoptools.hawthorne;/*
 * $Id: HttpFilter 3988 2017-06-21 13:47:09Z cfi $
 * Created on 26.12.17 11:49
 * 
 * Copyright (c) 2017 by bluesky IT-Solutions AG,
 * Kaspar-Pfeiffer-Strasse 4, 4142 Muenchenstein, Switzerland.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of bluesky IT-Solutions AG ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with bluesky IT-Solutions AG.
 */

import io.tabletoptools.hawthorne.persistence.EntityManagerRequestFilter;
import io.tabletoptools.hawthorne.persistence.EntityManagerResponseFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>(3);

        resources.add(RolesAllowedDynamicFeature.class);

        resources.add(EntityManagerRequestFilter.class);
        resources.add(EntityManagerResponseFilter.class);

        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();

        /*if (Configuration.getConfig().getCors()) {
            Loggers.APPLICATIONLOGGER.info("Enabling CORS requests.");

            CorsFilter corsFilter = new CorsFilter();
            corsFilter.getAllowedOrigins().add("*");
            corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
            singletons.add(corsFilter);
        }*/

        return singletons;
    }



}
