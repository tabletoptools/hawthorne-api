/*
 * $Id: EntityManagerRequestFilter.java 4110 2017-08-28 15:15:13Z cfi $
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

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *
 * @author cfi
 */
@PreMatching
@Provider
@Priority(500)
public class EntityManagerRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        requestContext.setProperty("EntityManager", EntityManagerFilter.getEntityManagerFactory().createEntityManager());
        
    }

    //Called by ContextListener on Servlet Destruction ( shutdown )
    public static void closeEMF() {
        EntityManagerFilter.getEntityManagerFactory().close();
    }

}
