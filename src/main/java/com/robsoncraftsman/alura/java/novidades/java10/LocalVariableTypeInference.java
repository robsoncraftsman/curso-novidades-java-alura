package com.robsoncraftsman.alura.java.novidades.java10;

import java.util.ArrayList;
import java.util.List;

/**
 * Local Variable Type Inference - Java 10
 */
public class LocalVariableTypeInference {

	public static void main(final String[] args) {
		// Declarar uma variável do jeito antigo
		final List<String> lista = new ArrayList<>();
		lista.add("Variável normal");
		System.out.println(lista);

		// Declarar uma variável da forma nova
		final var listaComTipoInferido = new ArrayList<String>();
		listaComTipoInferido.add("Variável com tipo inferido");
		System.out.println(listaComTipoInferido);
	}

}
