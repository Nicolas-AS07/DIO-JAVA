// Conta.java
package model;

public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0.0;
	}

	@Override
	public void sacar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor de saque deve ser positivo.");
		}
		if (saldo < valor) {
			throw new IllegalArgumentException("Saldo insuficiente para saque.");
		}
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
		}
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (contaDestino == null) {
			throw new IllegalArgumentException("Conta destino inválida.");
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	protected void imprimirInfosComuns() {
		System.out.println("Titular: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Agência: " + agencia);
		System.out.println("Número: " + numero);
		System.out.printf("Saldo: R$ %.2f%n", saldo);
	}
}