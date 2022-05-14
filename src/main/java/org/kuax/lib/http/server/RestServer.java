package org.kuax.lib.http.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.kuax.lib.http.server.servlet.SampleServlet;

public class RestServer {

    public Server server;

    public RestServer() throws Exception {
        this.server = new Server();

        ServerConnector httpConnector = new ServerConnector(server);
        httpConnector.setHost("127.0.0.1");
        httpConnector.setPort(8080);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(SampleServlet.class, "/*");

        server.addConnector(httpConnector);
        server.setHandler(servletHandler);

        server.start();
    }
}
