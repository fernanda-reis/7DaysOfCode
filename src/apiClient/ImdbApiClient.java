package apiClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import interfaces.APIClient;

public class ImdbApiClient implements APIClient {
	
	String type = "Movie";
	static String apiKey = "<sua chave>";
	
	public ImdbApiClient(String key) {
		ImdbApiClient.apiKey = key;
	};

	public String getBody() throws IOException, InterruptedException {
	String url = "https://imdb-api.com/en/API/Top250Movies/";

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + apiKey))
            .GET()
            .build();
    
    HttpResponse<String> response =	HttpClient.newHttpClient()
    		.send(request, HttpResponse.BodyHandlers.ofString());
	return response.body();
	}


	@Override
	public String type() {
		// TODO Auto-generated method stub
		return type;
	}
}
