package com.robsoncraftsman.novidades.java13;

/**
 * Exemplo usando TextBlocks - Java 13
 **/
public class TextBlocks {

	public static void main(final String[] args) {
		final var blocoTexto = """
				Bloco de texto
				com várias linhas
				que deve ser impresso
				da mesma forma.
				""";
		System.out.println(blocoTexto);
	}

}
