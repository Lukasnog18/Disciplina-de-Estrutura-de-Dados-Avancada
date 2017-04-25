package br.ufc.quixada.eda.testes;

import java.io.IOException;

import br.ufc.quixada.eda.algoritimo.Dijkstra;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteDijkstra {

	public static void main(String[] args) {
		try{
			for(int tamanho : CriarInstancia.tamanhoInstancias){
				for(int i = 0; i < 4; i++){
					String path = EDAConstants.caminhoPasta + "tb8ch" + tamanho + "_" + i + ".txt";
					Grafo entrada = EDAUtil.getGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();	
					
					Dijkstra dj = new Dijkstra();
					dj.executar(entrada);
					
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					System.out.println("Tempo gasto por -> tb8ch" + tamanho + "_" + i + ": " + tempo);
					
				}
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
