package app;

import java.io.PrintWriter;
import java.util.List;

import interfaces.Content;

public class HTMLGenerator {
	
	private static PrintWriter writer;
	
	public HTMLGenerator(PrintWriter w) {
		HTMLGenerator.writer = w;
	}

	public void generate(List<? extends Content> list) {
		String head = 
				"""
				<html lang=\"pt-br\">
					<head>
						<meta charset=\"utf-8\">
						<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
						<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
							+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
					</head>
					<body>
					<div class=\"d-flex flex-wrap justify-content-center bg-dark\">
				""";
		
		writer.println(head);


		String divTemplate = 
				"""
						
				<div class=\"card text-white m-3\" style=\"width: 12rem; background-color:#060917;\">
					<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img img-fluid\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					</div>
				</div>
				""";
		

		// usando o template com os dados do filme
		for(int i = 0; i < list.size(); i++) {
		writer.println(String.format(divTemplate, list.get(i).title(), list.get(i).urlImage(), list.get(i).title(), list.get(i).rating(),
				list.get(i).year()));
		}
		
		
		String fim = 
				"""
				</div>
				</body>
				</html>
				""";
		
		writer.println(fim);
		
		writer.flush();
	}
}
