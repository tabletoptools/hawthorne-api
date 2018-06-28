package io.tabletoptools.hawthorne;

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
