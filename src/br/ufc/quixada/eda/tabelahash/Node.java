package br.ufc.quixada.eda.tabelahash;

public class Node<T> {
	private Integer chave;
	private T valor;
	private Node next;
	
	public T getValor() {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public int getChave() {
		return chave;
	}
	
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}