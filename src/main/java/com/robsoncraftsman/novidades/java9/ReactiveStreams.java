package com.robsoncraftsman.novidades.java9;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;

/**
 * Reactive Streams - Java 9
 */
public class ReactiveStreams {

	public static void main(final String[] args) throws InterruptedException {
		final var pedidoUm = new Pedido(1, "João");
		final var pedidoDois = new Pedido(2, "Maria");
		final var pedidoTres = new Pedido(3, "Pedro");

		final var publicadorPedidos = new SubmissionPublisher<Pedido>();
		try {
			final var consumidorPedidos = new PedidoSubscriber();
			publicadorPedidos.consume(new PedidoConsumer());
			publicadorPedidos.subscribe(consumidorPedidos);
			publicadorPedidos.submit(pedidoUm);
			publicadorPedidos.submit(pedidoDois);
			publicadorPedidos.submit(pedidoTres);
			Thread.sleep(2000);
		} finally {
			publicadorPedidos.close();
		}
	}

}

class PedidoConsumer implements Consumer<Pedido> {

	@Override
	public void accept(final Pedido pedido) {
		System.out.println("Pedido (Consumer): " + pedido.getId() + " -> " + Thread.currentThread().getName());
	}

}

class PedidoSubscriber implements Subscriber<Pedido> {

	private Subscription subscription;
	public List<Pedido> pedidosProcessados = new LinkedList<>();

	@Override
	public void onSubscribe(final Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(final Pedido pedido) {
		this.pedidosProcessados.add(pedido);
		System.out.println("Pedido (Subscriber): " + pedido.getId() + " -> " + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		this.subscription.request(1);
	}

	@Override
	public void onError(final Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Todos pedidos processados");
	}

	public List<Pedido> getPedidosProcessados() {
		return this.pedidosProcessados;
	}

}

class Pedido {

	private final Integer id;
	private final String cliente;

	public Pedido(final Integer id, final String cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}

	public Integer getId() {
		return this.id;
	}

	public String getCliente() {
		return this.cliente;
	}

}
