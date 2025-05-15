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
			System.out.println("Valor de saque deve ser positivo.");
			return;
		}
		if (saldo < valor) {
			System.out.println("Saldo insuficiente para saque.");
			return;
		}
		saldo -= valor;
		System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("Valor de depósito deve ser positivo.");
			return;
		}
		saldo += valor;
		System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (contaDestino == null) {
			System.out.println("Conta destino inválida.");
			return;
		}
		if (valor <= 0) {
			System.out.println("Valor de transferência deve ser positivo.");
			return;
		}
		if (saldo < valor) {
			System.out.println("Saldo insuficiente para transferência.");
			return;
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
	}

	public int getNumero() { return numero; }
	public double getSaldo() { return saldo; }
	public Cliente getCliente() { return cliente; }

	protected void imprimirInfosComuns() {
		System.out.println("Titular: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Agência: " + agencia);
		System.out.println("Número: " + numero);
		System.out.printf("Saldo: R$ %.2f%n", saldo);
	}
}