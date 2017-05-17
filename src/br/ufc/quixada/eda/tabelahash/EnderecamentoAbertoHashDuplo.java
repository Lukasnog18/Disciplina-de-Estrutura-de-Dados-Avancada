package br.ufc.quixada.eda.tabelahash;

import br.ufc.quixada.eda.tabelahash.Hash;

public class EnderecamentoAbertoHashDuplo<T> extends Hash<T>{
	Integer tabela[];
	Integer k = 0;
	
	protected EnderecamentoAbertoHashDuplo(int tam) {
		super(tam);
		tabela = new Integer[tam];
	}
	
	protected Integer ffHash (Integer chave){
		return 1 + (chave % m);
	}
	
	@Override
	protected void inserir(Integer chave, T valor) {
		int ind = fHash(chave);
		if (tabela[ind] == null){
			tabela[ind] = chave;
		}else{
			
		}
		
	}
	@Override
	protected T buscar(Integer chave) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected T remover(Integer chave) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
