/*
 * $Id: EntityManagerResponseFilter.java 4058 2017-08-09 12:17:14Z cfi $
 * Created on 21.06.2017, 12:14:38
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
package io.tabletoptools.hawthorne.persistence;

import javax.persistence.EntityManager;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *
 * @author cfi
 */
@Provider
public class EntityManagerResponseFilter implements ContainerResponseFilter {
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        if (requestContext.getProperty("EntityManager") != null 
                && ((EntityManager)requestContext.getProperty("EntityManager")).isOpen()) {
            
            ((EntityManager) requestContext.getProperty("EntityManager")).close();
        }
    }

}
