package br.ufc.quixada.eda.tabelahash;

public abstract class Hash<T> {
	protected Integer m = 0;
	
	protected Hash(int tam){
		m = tam;
	}
	
	protected Integer fHash(Integer chave){
		return (chave % m);
	}
	
	protected abstract void inserir (Integer chave, T valor);
	protected abstract T buscar (Integer chave);
	protected abstract T remover (Integer chave);
	
}