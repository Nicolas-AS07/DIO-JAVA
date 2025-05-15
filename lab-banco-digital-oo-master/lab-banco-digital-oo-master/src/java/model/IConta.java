// IConta.java
package model;

public interface IConta {
	void sacar(double valor) throws IllegalArgumentException;
	void depositar(double valor);
	void transferir(double valor, IConta contaDestino) throws IllegalArgumentException;
	void imprimirExtrato();
}