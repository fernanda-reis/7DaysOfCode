package app;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		String[] moviesArray = ParseJSON.parseJsonFilmes(API.api());

		List<Movie> movies = ParseJSON.listMovies(moviesArray);
        
		for(int i = 0; i<movies.size();i++) {
        	System.out.println(movies.get(i).getTitle());
        }

	}
       	

}
