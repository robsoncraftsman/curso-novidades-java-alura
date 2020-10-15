package com.robsoncraftsman.alura.java.novidades.java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Exemplo usando Collection Factory Methods - Java 9
 */
public class CollectionFactoryMethods {

	// Java 9
	public static void main(final String[] args) {
		// Criação de uma lista tradicional e uma lista imutável
		final var nomes = new ArrayList<String>();
		nomes.add("Maria");
		nomes.add("João");
		nomes.add("Antônio");
		nomes.add("Pedro");
		nomes.add("Clara");
		final var nomesImutavel = Collections.unmodifiableList(nomes);
		System.out.println(nomesImutavel);

		// Criação de uma lista via fábrica - imutável
		final var nomesImutavelViaFabrica = List.of("Maria", "Pedro", "João");
		// nomesImutavelViaFabrica.add("Teste"); => Gera erro pois a coleção é imutável
		System.out.println(nomesImutavelViaFabrica);

		// Criação de um map via fábrica -imutável
		final var nomesMapImutavelViaFabrica = Map.of(1, "Maria", 2, "Pedro");
		System.out.println(nomesMapImutavelViaFabrica);

		// Criação de um set imutável
		final var nomesSetImutavelViaFabrica = Set.of("Maria", "Pedro");
		System.out.println(nomesSetImutavelViaFabrica);
	}

}
