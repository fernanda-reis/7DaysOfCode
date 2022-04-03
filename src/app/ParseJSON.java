package app;

import java.util.ArrayList;
import java.util.List;

public class ParseJSON {



	 public static String[] parseJsonFilmes(String response) {
     	
     	//retirar colchetes
     	int tamanhoString = response.length();
     	String jsonFilmes = response.substring(10, tamanhoString-20);

     	
         //separar as virgulas
     	String reg  = "\",\"|\\},\\{";          	
     	String [] listaFilmes = jsonFilmes.split(reg);
     	return listaFilmes;
     }
     
	 
		public  static List<String> parseItem(String[] lista, int n) {
         ArrayList<String> retorno = new ArrayList<>();
         // " " e {
         String reg = "^\"|\\{"; 
         // ":"
         String reg2 = "\"\\:\"";
     	 
     	for (int i = n; i<lista.length; i+=9){
     			lista[i].split(reg);
     			lista[i] = lista[i].replaceAll(reg2,":");
     			retorno.add(lista[i]);
     			System.out.println(lista[i]);
     		}
     	
			return retorno;
     }

}
