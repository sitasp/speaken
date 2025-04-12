package com.raxati.resource;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/admin")
public class AdminResource {
    private static final Logger log = LoggerFactory.getLogger(UserResource.class);
    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        log.info("UserResource.getUser() called");
        String name = securityIdentity.getPrincipal().getName();
        log.info("User name: {}", name);
        return name;
    }
}
