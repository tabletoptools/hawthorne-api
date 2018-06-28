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
