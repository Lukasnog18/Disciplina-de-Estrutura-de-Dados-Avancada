package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

public class HeapTernarioMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernarioMaximo(int Nmaximo) {
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int k = (i + 1) / 3; 
		
		if(k >= 1){ 
			if(vetor[k] < vetor[i]){ 
				int aux = vetor[i];  
				vetor[i] = vetor[k];
				vetor[k] = aux;
				subir(k);  
			}
		}
	}
	
	private void descer(int i){
		int j = 3 * i;
		if(j <= n){
			if((j + 1) <= n){
				if(vetor[j] < vetor[j - 1]){
					j = j - 1;
					if(vetor[j] < vetor[j + 2]){
						j = j + 2;
					}
				}
				if(vetor[j] < vetor[j + 1]){
					j = j + 1;
				}
			}else{
				if(vetor[j] < vetor[j - 1]){
					j = j - 1;
				}
			}
			if(vetor[i] < vetor[j]){
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				descer(j);
			}
		}
	}
	
	public void construir(List<Integer> entrada){
		for(int i = 1; i <= entrada.size(); i++){
			vetor[i] = entrada.get(i - 1);
			n++;
		}
		int p = ((n + 1) /3);
		for(int i = p ; i > 0; i--){
			descer(i);
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[1];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			descer(1);
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n <= nMaximo){
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
					return;
				}else if(novaPrioridade < prioridade){
					descer(i);
					return;
				}
			}
		}		
	}	
	
	public void imprimir(){
		for(int i = 1; i <= n; i++){
			System.out.print(vetor[i] + ", ");
		}
		System.out.println("\n");
	}
}