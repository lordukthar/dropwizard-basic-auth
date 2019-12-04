package org.aja.helloworld;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;

public class MyJerseyClient {

    private Client client;
    private WebResource webResource;

    @Before
    public void setup() {
        client = Client.create();
        webResource = client
                .resource("http://localhost:10000/protected/admin");
    }

    @Test
    public void testProtectedResourceAdmin_failure(){

        try {

            ClientResponse response = webResource
                .header("SDSD", "HKJHJKHJ")
                .get(ClientResponse.class);

            assert response.getStatus() == 401;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Base64 encoded chjef-wizard/secret Basic Y2hpZWYtd2l6YXJkOnNlY3JldA==
    @Test
    public void testProtectedResourceAdmin_success(){

        try {
            ClientResponse response = webResource//.
                    //header("Content-Type",
                    //      "application/json;charset=UTF-8")
                    .header("Authorization", "Basic Y2hpZWYtd2l6YXJkOnNlY3JldA==")
                    //.accept("application/json")
                    .get(ClientResponse.class);

            String entity = response.getEntity(String.class);
            System.out.println(entity);

            assert response.getStatus() == 200;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
