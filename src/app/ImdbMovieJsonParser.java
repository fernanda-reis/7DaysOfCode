package app;

import java.util.ArrayList;
import java.util.List;

import interfaces.JsonParser;
import model.Movie;

public class ImdbMovieJsonParser implements JsonParser{

	private static String json;
	
	
	public 	ImdbMovieJsonParser(String js) {
		ImdbMovieJsonParser.json = js;
	}
	
	public List<Movie> parse() {
		
		// retirar colchetes
		int tamanhoString = json.length();
		String jsonFilmes = json.substring(10, tamanhoString - 20);

		// separar as virgulas
		String reg = "\",\"|\\},\\{";
		String[] moviesArray = jsonFilmes.split(reg);
		

		// parse atributos
		List<String> titles = ImdbMovieJsonParser.parseItem(moviesArray, 2);

		List<String> images = ImdbMovieJsonParser.parseItem(moviesArray, 5);

		List<String> ratings = ImdbMovieJsonParser.parseItem(moviesArray, 7);

		List<String> years = ImdbMovieJsonParser.parseItem(moviesArray, 4);

		List<Movie> movies = new ArrayList<>();

		for (int i = 0; i < titles.size(); i++) {
			Movie movie = new Movie();

			movie.setTitle(titles.get(i));
			movie.setUrlImage(images.get(i));
			movie.setRating(ratings.get(i));
			movie.setYear(years.get(1));

			movies.add(movie);
		}

		return movies;

	}
	
	
	
	private static List<String> parseItem(String[] lista, int n) {
		
		ArrayList<String> retorno = new ArrayList<>();
		String[] valor;
		String reg2 = "\"\\:\"";

		for (int i = n; i < lista.length; i += 9) {
			valor = lista[i].split(reg2);
			retorno.add(valor[1]);
		}

		return retorno;
	}

}
