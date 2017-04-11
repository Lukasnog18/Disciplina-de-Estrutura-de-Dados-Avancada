package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.algoritimo.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.listaprioridades.HeapMaximo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteConjuntosDisjuntos {
	public static void main(String args[]){		
		try {
			for(int tamanho : CriarInstancia.tamanhoInstancias){
				for(int i = 0; i < 4; i++){
					String arquivo = "tb8ch" + tamanho + "_" + i + ".txt";
					String path = EDAConstants.caminhoPasta + arquivo;
					
					Grafo g = EDAUtil.getGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();
					ArvoreGeradoraMinima arvore = new ArvoreGeradoraMinima();
					
					int somaArestas = 0;
					//System.out.println(arvore.Kruskal(g).size());
					for(Aresta a : arvore.Kruskal(g)){
						somaArestas += a.getW();
					}
					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println(arquivo + " " + somaArestas + " " + tempo);
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
