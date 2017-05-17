package br.ufc.quixada.eda.tabelahash;

public class NoHash<T> {
	
	private Integer chave = 0;
	private Integer next = -1;
	private T valor;
	
	public NoHash (Integer chave, T valor){
		this.setChave(chave);
		this.setValor(valor);
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
}