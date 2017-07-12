package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.arvorerubronegra.ArvoreRubroNegra;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.trabalhofinal.Pessoa;

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
	
	public static List<Pessoa> Operacoes(String path) throws IOException {
//		List<Pessoa> pessoas = new ArrayList<Pessoa>();
//		Scanner scan = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
//
//		while(scan.hasNext()){
//			pessoas.add(new Pessoa(scan.next().substring(5), scan.next().substring(4), scan.next().substring(3), scan.next().substring(15), scan.next().substring(6), scan.next().substring(11), scan.next().substring(4), scan.next().substring(4), scan.next().substring(7), scan.next().substring(7), scan.next().substring(7), scan.next().substring(7), scan.next().substring(9), scan.next().substring(8)));	
//		}
//		scan.close();
//		return pessoas;
        List<Pessoa> operacoes = new ArrayList<Pessoa>();
        Scanner s = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
        
        int k = 0;
		while (s.hasNext()){
			try{
				k++;
				try{
				Date data = new Date();
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				operacoes.add(new Pessoa(s.next().substring(5), s.next().substring(4), s.next().substring(3),
						data = sdf.parse(s.next().substring(15)), s.next().substring(6), s.next().substring(11),
						s.next().substring(4), s.next().substring(4), s.next().substring(7), s.next().substring(7),
						s.next().substring(7), s.next().substring(7), s.next().substring(9), s.next().substring(8)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}catch(Exception e){
				e.printStackTrace();
			    System.out.println(k);
			}
		}
		s.close();
        return operacoes;
	}
    
    public static Grafo getGrafo(String path) throws IOException{
    	Grafo g = new Grafo();
    	List<Aresta> listAresta = new ArrayList<Aresta>();
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
    	
    	if(scanner.hasNext()){
    		g.setN(scanner.nextInt());
    		g.setM(scanner.nextInt());
    	}
    	
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