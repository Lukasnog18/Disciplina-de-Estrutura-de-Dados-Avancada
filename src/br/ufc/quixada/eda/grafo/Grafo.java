package br.ufc.quixada.eda.grafo;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
		
public class Grafo {
	private int n;
	private int m;
//	private Aresta arestas[] = null;
	private List<Aresta> Arestas = new ArrayList<Aresta>();
	private ListaAdjacencia adj[];
	
//	public static void quicksortVet(Aresta[] arestas, int i, int j){
//		if(i < j){
//			int k = particionaVet(arestas, i, j);
//			quicksortVet(arestas, i, k - 1);
//			quicksortVet(arestas, k + 1, j);
//		}
//	}
//	
//	private static int particionaVet(Aresta[] arestas, int i, int j){
//		int pivo = j;
//		int q = i - 1;
//		for(int k = i; k < j; j++){
//			if(arestas[k].getW() < arestas[pivo].getW()){
//				q++;
//				Aresta aux = arestas[k];
//				arestas[k] = arestas[q];
//				arestas[q] = aux;
//			}
//		}
//		troca(q + 1, j);
//	}
	
	
//	public void quickSort(int ini, int fim){
//	    if (ini < fim) {
//	        int posicaoPivo = particiona(ini, fim);
//	        quickSort(ini, posicaoPivo - 1);
//	        quickSort(posicaoPivo + 1, fim);
//	    }
//	}
//	
//	private int particiona(int p, int r){
//		Aresta pivo = Arestas.get(p);
//		int i = p + 1;
//		int f = r;
//		while(i <= f){
//			if(Arestas.get(i).getW() <= pivo.getW())
//				i++;
//			else if (pivo.getW() < Arestas.get(f).getW())
//				f--;
//			else{
//				Collections.swap(Arestas, i, f);
//				i++;
//				f--;
//			}
//		}
//		
//		Collections.swap(Arestas, p, f);
//		Arestas.remove(f);
//		Arestas.add(f, pivo);
//		return f;
//	}
		
	public int getN() {
		return n;
	}
		
	public void setN(int n) {
		this.n = n;
	}
		
	public int getM() {
		return m;
	}
	
	public void setM(int m) {
		this.m = m;
	}
	
//		public Aresta[] getArestas() {
//			return arestas;
//		}
//	
//		public void setArestas(Aresta[] arestas) {
//			this.arestas = arestas;
//		}
		
	
	public List<Aresta> getArestas() {
		return Arestas;
	}
	
	public ListaAdjacencia[] getAdj() {
		return adj;
	}

	public void setAdj(ListaAdjacencia[] adj) {
		this.adj = adj;
	}

	public void setAresta(List<Aresta> aresta) {
		this.Arestas = aresta;
	}
		 
}