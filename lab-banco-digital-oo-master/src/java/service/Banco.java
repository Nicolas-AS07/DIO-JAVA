package service;

import java.util.ArrayList;
import java.util.List;
import model.Conta;

public class Banco {
	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void adicionarConta(Conta conta) {
		if (conta != null) {
			contas.add(conta);
		}
	}

	public void removerConta(Conta conta) {
		contas.remove(conta);
	}

	public Conta buscarContaPorNumero(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public List<Conta> getContas() {
		return contas;
	}
}