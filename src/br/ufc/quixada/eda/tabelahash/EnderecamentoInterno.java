package br.ufc.quixada.eda.tabelahash;

public class EnderecamentoInterno<T> extends Hash<T>{
	private Integer p = 0;
	private NoHash<T> tabela[] = null;
	
	public EnderecamentoInterno (Integer tam){
		super(tam);
		tabela = new NoHash[tam];
		this.p = (int) (0.7 * m);
	}
	
	public Integer fHash(Integer chave){
		return (chave % p);
	}

	@Override
	public void inserir(Integer chave, T valor) {
		NoHash<T> hash = new NoHash<T>(chave, valor);
		Integer newChave = fHash(chave);
		if (tabela[newChave] == null){
			tabela[newChave] = hash;
		}else if (tabela[newChave].getChave() == chave){ return; }
		else {
			for (int i = this.p; i < tabela.length; i++){
				if (tabela[i] == null){
					//tabela[newChave].setNext(i);
					tabela[i] = hash;
					return;
				}
			}
		}
	}

	@Override
	public T buscar(Integer chave) {
		Integer newChave = fHash(chave);
		if (tabela[newChave].getChave() == chave){
			return (T) tabela[newChave].getValor();
		}else{
			for (int i = p; i < tabela.length; i++){
				if (tabela[i].getChave() == chave){
					return (T) tabela[i].getValor();
				}
			}
		}
		return null;
	}

	@Override
	public T remover(Integer chave) {
		Integer newChave = fHash(chave);
		if (buscar(chave) != null){
			if (tabela[newChave].getChave() == chave){
				NoHash aux = tabela[newChave];
				tabela[newChave] = null;
				return (T) aux.getValor();
			}else{
				for (int i = p; i < tabela.length; i++){
					if (tabela[i].getChave() == chave){
						NoHash aux = tabela[i];
						tabela[i] = null;
						return (T) aux.getValor();
					}
				}
			}
		}
		return null;
	}
}