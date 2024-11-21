package org.piecs;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {

        // Registering resources and filters
        final ResourceConfig rc = new ResourceConfig()
                .packages("org.piecs.resources") // Register resources in this package
                .register(org.piecs.InfraEstrutura.CorsFilter.class); // Ensure CorsFilter exists and is accessible

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        try {
            System.out.println(String.format("Jersey app started with endpoints available at %s%nPress Enter to stop it...", BASE_URI));
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error while starting the server: " + e.getMessage());
        } finally {
            server.shutdownNow();
            System.out.println("Server stopped.");
        }
    }
}
