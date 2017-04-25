package br.ufc.quixada.eda.grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaAdjacencia implements Iterator<Aresta>{
	private List<Aresta> lista = null;
	private int posicao = 0;
	
	public ListaAdjacencia(){
		lista = new ArrayList<Aresta>();
	}
	
	public void add(Aresta a){
		lista.add(a);
	}

	public void inicializarIterator(){
		posicao = 0;
	}
	
	@Override
	public boolean hasNext(){
		return (posicao < lista.size());
	}

	@Override
	public Aresta next(){
		Aresta aa = lista.get(posicao);
		posicao++;
		return aa;
	}
}
