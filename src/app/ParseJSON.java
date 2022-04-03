package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {

	public static String[] parseJsonFilmes(String response) {

		// retirar colchetes
		int tamanhoString = response.length();
		String jsonFilmes = response.substring(10, tamanhoString - 20);

		// separar as virgulas
		String reg = "\",\"|\\},\\{";
		String[] listaFilmes = jsonFilmes.split(reg);
		return listaFilmes;
	}

	public static List<String> parseItem(String[] lista, int n) {
		ArrayList<String> retorno = new ArrayList<>();
		String[] valor;
		String reg2 = "\"\\:\"";

		for (int i = n; i < lista.length; i += 9) {
			valor = lista[i].split(reg2);
			retorno.add(valor[1]);
		}

		return retorno;
	}

	public static List<Movie> listMovies(String[] moviesArray) {

		List<String> titles = ParseJSON.parseItem(moviesArray, 2);

		List<String> images = ParseJSON.parseItem(moviesArray, 5);

		List<String> ratings = ParseJSON.parseItem(moviesArray, 7);

		List<String> years = ParseJSON.parseItem(moviesArray, 4);

		List<Movie> movies = new ArrayList<>();

		for (int i = 0; i < titles.size(); i++) {
			Movie movie = new Movie();

			movie.setTitle(titles.get(i));
			movie.setUrlImage(images.get(i));
			movie.setRating(Float.parseFloat(ratings.get(i)));
			movie.setYear(Integer.parseInt(years.get(1)));

			movies.add(movie);
		}

		return movies;

	}

}
