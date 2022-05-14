package org.kuax;

import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.kuax.lib.http.client.RestClient;
import org.kuax.lib.http.server.RestServer;

public class HttpUtilsApp {

    public static void main(String[] args) throws Exception {
        RestServer restServer = new RestServer();

        RestClient restClient = new RestClient();

        String sampleJson = "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"You're OK to Joining\",\n" +
                "  \"person\": {\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"phone\": \"999-9999-9999\"\n" +
                "  }\n" +
                "}";
        ContentResponse contentResponse = restClient.callUrl("http://localhost:8080/sampleServlet", HttpMethod.GET, sampleJson);
        System.out.println(contentResponse.getContentAsString());

        Thread.sleep(2000);
        restClient.callUrl("http://localhost:8080/exit", HttpMethod.GET, "");
    }
}
