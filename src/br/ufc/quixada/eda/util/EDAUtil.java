package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;

public class EDAUtil {
	/**
	 * Ler o arquivo que contém as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    
    public static void ordenarListAresta(List<Aresta> arestas){
    	Collections.sort(arestas, new Comparator<Aresta>(){
    		public int compare(Aresta o1, Aresta o2){
    			if(o1.getW() < o2.getW()) return -1;
    			else if(o1.getW() > o2.getW()) return 1;
    			else return 0;
    		}
    	});
    }
    
	public static void quicksortList(List<Aresta> arestas, int i, int j){
	if(i < j){
		int k = particionaList(arestas, i, j);
		quicksortList(arestas, i, k - 1);
		quicksortList(arestas, k + 1, j);
	}
}

	public static int particionaList(List<Aresta> arestas, int i, int j){
		int q = i - 1;
		for(int k = i; k < j; k++){
			if(arestas.get(k).getW() < arestas.get(j).getW()){
				q++;
				Aresta aux = arestas.get(k);
				arestas.set(k, arestas.get(q));
				arestas.set(q, aux);
			}
		}
		Collections.swap(arestas, q + 1, j);
		return q + 1;
}
    /**
     * Ler as operações que serão realizadas na lista de prioridades após a sua criação.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));
			
		scanner.close();
        return operacoes;
    }
    
    public static Grafo getGrafo(String path) throws IOException{
    	Grafo g = new Grafo();
    	List<Aresta> listAresta = new ArrayList<Aresta>();
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	
    	if(scanner.hasNext()){
    		g.setN(scanner.nextInt());
    		g.setM(scanner.nextInt());
    	}
    	
    	int i = 0;
    	while(scanner.hasNext()){
    		listAresta.add(new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
    	}
    	scanner.close();
    	g.setAresta(listAresta);
    	return g;
    	
//    	Grafo g = null;
//    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
//    	if(scanner.hasNext()){
//    		g = new Grafo();
//    		while(scanner.hasNext())
//    			g.getArestas().add(new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
//    	}
//    	
//    	scanner.close();
//    	return g;
    }
}