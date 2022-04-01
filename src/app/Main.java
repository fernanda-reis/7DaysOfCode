package app;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

        String[] moviesArray = ParseJSON.parseJsonFilmes(API.api());
        
           
        List<String> titles = ParseJSON.parseItem(moviesArray, 2);
        titles.forEach(System.out::println);

        List<String> images = ParseJSON.parseItem(moviesArray, 5);
        images.forEach(System.out::println);
        
        List<String> ratings = ParseJSON.parseItem(moviesArray, 7);
        ratings.forEach(System.out::println);
        
        List<String> years = ParseJSON.parseItem(moviesArray, 4);
        years.forEach(System.out::println);
;
	}
       	

}
