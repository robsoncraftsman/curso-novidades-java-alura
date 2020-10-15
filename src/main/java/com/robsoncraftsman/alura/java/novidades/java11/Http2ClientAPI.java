package com.robsoncraftsman.alura.java.novidades.java11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;

/**
 * HTTP/2 Client API - Java 11
 */
public class Http2ClientAPI {

	public static void main(final String[] args)
			throws URISyntaxException, IOException, InterruptedException, ExecutionException {

		final var httpRequest = HttpRequest.newBuilder(new URI("https://postman-echo.com/get")).build();
		final var httpClient = HttpClient.newHttpClient();

		// Requisição síncrona
		final var httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.version());
		System.out.println(httpResponse.body());


		// Requisição assíncrona usando o callback whenComplete
		httpClient.sendAsync(httpRequest, BodyHandlers.ofString())
		.whenComplete((response, error) -> {
			if (response != null) {
				System.out.println(response.body());
			}
			if (error != null) {
				error.printStackTrace();
			}
		})
		.join();

		// Requisição fazendo transformações
		httpClient.sendAsync(httpRequest, BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenAccept(System.out::println)
		.join();

		// Requisição assíncrona pegado o resultado de forma síncrona
		final var responseAsync = httpClient.sendAsync(httpRequest, BodyHandlers.ofString()).get();
		System.out.println(responseAsync.statusCode());
		System.out.println(responseAsync.version());
		System.out.println(responseAsync.body());

	}

}
