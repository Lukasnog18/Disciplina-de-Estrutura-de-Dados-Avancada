package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */

public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
        for(int i = 0; i < entrada.size(); i++){
            vetor[i] = entrada.get(i);
        }
        n = entrada.size();
        
        for(int i = (n / 2); i >= 0; i--){
            descer(i);
        }
	}
	
	private void subir(int i){
            int p = (i / 2);
            if(p >= 1){
                if(vetor[p] < vetor[i]){
                    int aux = vetor[i];
                    vetor[i] = vetor[p];
                    vetor[p] = aux;
                    subir(p);
                }
            }
	}
	
	private void descer(int i){
		int j = 2 * (i + 1);
		if(j <= n){
			j--;
			if(j + 1 < n && vetor[j] < vetor[j + 1]) j++;
			if(vetor[i] < vetor[j]){
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				descer(j);
			}
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[0];
	}
	
	public int remove(){
            if(n > 0){
                int aux = vetor[1];
                vetor[1] = vetor[n];
                n--;
                descer(1);
                return aux;
            }
		return 0;
	}	
	
	public void inserir(int prioridade){
            if(n < nMaximo){
                vetor[n + 1] = prioridade;
                n++;
                subir(n);
            }
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
            for(int i = 1; i <= n; i++){
                if(vetor[i] == prioridade){
                    vetor[i] = novaPrioridade;
                    if(novaPrioridade > prioridade){
                        subir(i);
                    } else{
                        descer(i);
                    }
                    return;
                }
            }
	}	
}
