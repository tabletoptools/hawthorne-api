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
