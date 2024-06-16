package org.example.literalura2.apiConnection;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ClientApi {


    private String ApiConnect(String URL) {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String body = response.body();
        return body;


    }

    public String buscarLibro(String title) {
        return this.ApiConnect("https://gutendex.com/books/?search=" + title.replaceAll(" ", "%20"));

    }

}
