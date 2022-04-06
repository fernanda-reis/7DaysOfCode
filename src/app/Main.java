package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import apiClient.ImdbApiClient;
import apiClient.MarvelApiClient;
import model.Movie;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		String apiKey = Key.keyImdb;
		
		String json = new ImdbApiClient(apiKey).getBody();
		String ajson = new MarvelApiClient(Key.keyMarvelPublic, Key.keyMarvelPrivate).getBody();
		
		List<Movie> movies = new ImdbMovieJsonParser(json).parse();
		
		PrintWriter writer = new PrintWriter("content.html");
		new HTMLGenerator(writer).generate(movies);
		writer.close();
		
		
		
//		for(int i = 0; i<movies.size();i++) {
//        	System.out.println(movies.get(i).getTitle());
//        }

	}
       	

}
