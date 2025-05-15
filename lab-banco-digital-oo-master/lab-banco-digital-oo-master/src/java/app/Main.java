package app;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.Banco;

public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco("Banco Digital");

		Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
		Conta cc = new ContaCorrente(cliente1);
		banco.adicionarConta(cc);

		Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00");
		Conta cp = new ContaPoupanca(cliente2);
		banco.adicionarConta(cp);

		cc.depositar(1000);
		cc.transferir(200, cp);

		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}
}