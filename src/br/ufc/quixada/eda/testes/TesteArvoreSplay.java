package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.arvoresplay.TreeSplay;
import br.ufc.quixada.eda.trabalhofinal.Pessoa;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteArvoreSplay {
	public static void main(String args[]){		
		System.out.println("Árvore Splay");
		try{
			String arquivoOperacao = "pessoasC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Pessoa> pessoas = EDAUtil.Operacoes(path);
			TreeSplay<Date, Pessoa> splay = new TreeSplay<>();
			 
			long tempoInicial = System.currentTimeMillis();
			for(int i = 0; i < pessoas.size(); i++){
				splay.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			long tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para inserir: " + tempo + " milesegundos");

			Collections.shuffle(pessoas);
			
			tempoInicial = System.currentTimeMillis();
			for(int i = 4000; i < 7000; i++){
				splay.busca(pessoas.get(i).getDataNascimento());
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para buscar 30%: " + tempo + " milesegundos");

			tempoInicial = System.currentTimeMillis();
			for(int i = 7000; i < 10000; i++){
				splay.remover(pessoas.get(i).getDataNascimento());
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para remover 30%: " + tempo + " milesegundos");
			
			
//			Misturado			
			tempoInicial = System.currentTimeMillis();
			TreeSplay<Date, Pessoa> splay2 = new TreeSplay<>();
			
			for(int i = 0; i < 1999; i++){
				splay2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			
			//busca 600 e remove 200
			for(int i = 1000; i < 1600; i++){
				splay2.busca(pessoas.get(i).getDataNascimento());
			}

			for(int i = 100; i < 300; i++){
				splay2.remover(pessoas.get(i).getDataNascimento());
			}
			
			//+20%
			for(int i = 2000; i < 3999; i++){
				splay2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			
			//busca 600 e remove 200
			for(int i = 400; i < 1600; i++){
				splay2.busca(pessoas.get(i).getDataNascimento());
			}

			for(int i = 400; i < 800; i++){
				splay2.remover(pessoas.get(i).getDataNascimento());
			}
			
			//+20%
			for(int i = 4000; i < 5999; i++){
				splay2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			
			//busca 600 e remove 200
			for(int i = 900; i < 2700; i++){
				splay2.busca(pessoas.get(i).getDataNascimento());
			}

			for(int i = 900; i < 1500; i++){
				splay2.remover(pessoas.get(i).getDataNascimento());
			}
			
			//+20%
			for(int i = 6000; i < 7999; i++){
				splay2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			
			//busca 600 e remove 200
			for(int i = 1600; i < 4000; i++){
				splay2.busca(pessoas.get(i).getDataNascimento());
			}

			for(int i = 1600; i < 2400; i++){
				splay2.remover(pessoas.get(i).getDataNascimento());
			}
			
			//+20%
			for(int i = 8000; i < 9999; i++){
				splay2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			
			//busca 600 e remove 200
			for(int i = 2500; i < 5500; i++){
				splay2.busca(pessoas.get(i).getDataNascimento());
			}

			for(int i = 2600; i < 3600; i++){
				splay2.remover(pessoas.get(i).getDataNascimento());
			}
			
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para realizar operações mistas: " + tempo + " milesegundos");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
