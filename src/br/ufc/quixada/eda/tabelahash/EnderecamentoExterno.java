package br.ufc.quixada.eda.tabelahash;

public class EnderecamentoExterno<T> extends Hash<T> {
	
	private ListaEncadeada<T> tabela [] = null;
	private int n = 0;
	
	
	protected EnderecamentoExterno(int tam) {
		super(tam);
		this.tabela = (ListaEncadeada<T>[]) new ListaEncadeada[tam];
		for (int i = 0; i < tam; i++) tabela[i] = new ListaEncadeada<T>();
	}

	@Override
	protected void inserir(Integer chave, T valor) {
		NoHash<T> nHash = new NoHash<T>(chave, valor);
		if(n == m) return;
		int posicao = fHash(chave);
		if(tabela[posicao] == null) tabela[posicao] = new ListaEncadeada<T>();
		tabela[posicao].InserirComeço(nHash);
		n++;
	}

	@Override
	protected T buscar(Integer chave) {
		int posicao = fHash(chave);
		return (T) tabela[posicao].search(chave);
	}

	@Override
	protected T remover(Integer chave) {
		int posicao = fHash(chave);
		n--;
		return (T) tabela[posicao].remove(chave);
	}

}