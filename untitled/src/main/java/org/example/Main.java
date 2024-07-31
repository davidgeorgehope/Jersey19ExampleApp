package org.example;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9090).build();
        PackagesResourceConfig resourceConfig = new PackagesResourceConfig("org.example");
        HttpServer server = GrizzlyServerFactory.createHttpServer(baseUri, resourceConfig);

        System.out.println("Server started. Visit http://localhost:9090/hello or http://localhost:9090/world");
        System.out.println("Press enter to stop the server...");
        System.in.read();
        server.stop();
    }
}