package br.ufc.quixada.eda.algoritimo;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int ant[] = null;
	private int d[] = null;
	
	public Dijkstra (){}
	
	public void executar(Grafo g){
		inicializacao(g.getM(), (int) g.getArestas().get(0).getW());
		HeapMinimo Q = new HeapMinimo(g.getN());
		Q.contruir(this.d);
		
		while(!Q.vazia()){
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta a = adj.next();
				int v = (a.getV() == u ? a.getU() : a.getV());
				
				relaxamento(u, v, a.getW());
			}
		}
	}
	
	public void relaxamento (int u, int v, double peso){
		if (d[v] > peso + d[u]){
			ant[v] = u;
			d[v] = (int) peso + d[u];
		}
	}
	
	public void inicializacao (int tamanho, int origem){
		this.d = new int [tamanho + 1];
		this.ant = new int [tamanho + 1];
		
		for (int i = 1; i < tamanho + 1; i++){
			d[i] = Integer.MAX_VALUE;
			ant[i] = -1;
		}
		d[origem] = 0;
		ant[origem] = origem;
	}
}
