package com.octopus.products.application.http;

import com.github.jasminb.jsonapi.exceptions.DocumentSerializationException;
import com.octopus.Constants;
import com.octopus.products.application.Paths;
import com.octopus.products.domain.handlers.HealthHandler;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/** A resource to respond to health check requests. */
@Path(Paths.HEALTH_ENDPOINT)
@RequestScoped
public class HealthRootResourceGetAll {

  @Inject HealthHandler healthHandler;

  /**
   * The health check.
   *
   * @return a HTTP response object.
   * @throws DocumentSerializationException Thrown if the entity could not be converted to a JSONAPI
   *     resource.
   */
  @GET
  @Path("GET")
  @Produces({Constants.JsonApi.JSONAPI_CONTENT_TYPE, MediaType.APPLICATION_JSON})
  @Transactional
  public Response healthCollectionGet() throws DocumentSerializationException {
    return Response
        .ok(healthHandler.getHealth(Paths.HEALTH_ENDPOINT, "GET"))
        .build();
  }
}
