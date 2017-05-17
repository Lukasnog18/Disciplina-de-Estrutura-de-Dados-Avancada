package br.ufc.quixada.eda.tabelahash;

import br.ufc.quixada.eda.tabelahash.Hash;

public class EnderecamentoAbertoLinear<T> extends Hash<T>{
	Integer k = 0;
	Integer tabela[];
	
	protected EnderecamentoAbertoLinear(int tam) {
		super(tam);
		this.tabela = new Integer[tam];
	}
	
	protected Integer ffHash(Integer x){
		return (x + this.k) % m;
	}

	@Override
	protected void inserir(Integer x, T valor) {
		for (k = 0; k < m; k++){
			int ind = ffHash(x);
			if(tabela[ind] == null){
				tabela[ind] = x;
				return;
			}
		}
	}

	@Override
	protected T buscar(Integer chave) {
		for (k = 0; k < m; k++){
			int ind = ffHash(chave);
			if (tabela[ind] != null && tabela[ind] == chave){
				return (T) tabela[ind];
			}
			if (tabela[ind] == null){
				return null;
			}
		}
		return null;
	}

	@Override
	protected T remover(Integer x) {
		for (k = 0; k < m; k++){
			int ind = ffHash(x);
			if(tabela[ind] == null){
				T aux = (T) tabela[ind];
				tabela[ind] = null;
				return aux;
			}
		}
		return null;
	}
	

}