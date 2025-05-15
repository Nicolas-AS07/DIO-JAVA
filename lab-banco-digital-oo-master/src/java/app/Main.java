package app;

import java.util.Scanner;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.Banco;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banco banco = new Banco("Banco Digital");

		// Cliente 1
		System.out.println("Digite o nome do cliente 1:");
		String nome1 = scanner.nextLine();
		System.out.println("Digite o CPF do cliente 1:");
		String cpf1 = scanner.nextLine();

		Cliente cliente1 = new Cliente(nome1, cpf1);

		System.out.println("Escolha o tipo de conta para cliente 1 (1 - Corrente, 2 - Poupança):");
		int tipoConta1 = scanner.nextInt();
		scanner.nextLine(); // consumir \n

		Conta conta1;
		if (tipoConta1 == 1) {
			conta1 = new ContaCorrente(cliente1);
		} else {
			conta1 = new ContaPoupanca(cliente1);
		}
		banco.adicionarConta(conta1);

		// Cliente 2
		System.out.println("Digite o nome do cliente 2:");
		String nome2 = scanner.nextLine();
		System.out.println("Digite o CPF do cliente 2:");
		String cpf2 = scanner.nextLine();

		Cliente cliente2 = new Cliente(nome2, cpf2);

		System.out.println("Escolha o tipo de conta para cliente 2 (1 - Corrente, 2 - Poupança):");
		int tipoConta2 = scanner.nextInt();
		scanner.nextLine(); // consumir \n

		Conta conta2;
		if (tipoConta2 == 1) {
			conta2 = new ContaCorrente(cliente2);
		} else {
			conta2 = new ContaPoupanca(cliente2);
		}
		banco.adicionarConta(conta2);

		// Operações conta 1
		System.out.println("Digite o valor para depósito na conta 1:");
		double deposito1 = scanner.nextDouble();
		conta1.depositar(deposito1);

		System.out.println("Digite o valor para saque na conta 1:");
		double saque1 = scanner.nextDouble();
		conta1.sacar(saque1);

		// Transferência da conta 1 para conta 2
		System.out.println("Digite o valor para transferir da conta 1 para a conta 2:");
		double transferencia = scanner.nextDouble();
		conta1.transferir(transferencia, conta2);

		// Imprimir extratos
		System.out.println();
		conta1.imprimirExtrato();
		System.out.println();
		conta2.imprimirExtrato();

		scanner.close();
	}
}