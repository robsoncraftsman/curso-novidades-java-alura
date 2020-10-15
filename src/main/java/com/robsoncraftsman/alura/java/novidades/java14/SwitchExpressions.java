package com.robsoncraftsman.alura.java.novidades.java14;

/**
 * Switch Expressions - Java 14
 */
public class SwitchExpressions {

	public static void main(final String[] args) {
		final var nome = "João";

		//Switch normal
		switch (nome) {
		case "Pedro": {
			System.out.println("Acertou " + nome);
			break;
		}
		case "João": {
			System.out.println("Acertou " + nome);
			break;
		}
		default: {
			System.out.println("Nenhum nome encontrado");
		}
		}

		//Switch com Lambda
		switch (nome) {
		case "Pedro" -> System.out.println("Acertou " + nome);
		case "João" -> System.out.println("Acertou " + nome);
		default -> System.out.println("Nenhum nome encontrado");
		}

	}
}