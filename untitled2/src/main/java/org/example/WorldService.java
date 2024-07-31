package org.example;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/world")
public class WorldService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayWorld() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:9090/hello");
        String helloResponse = webResource.get(String.class);
        return helloResponse + " World from WorldService!";
    }
}