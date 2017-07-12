package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.ufc.quixada.eda.arvorerubronegra.ArvoreRubroNegra;
import br.ufc.quixada.eda.trabalhofinal.Pessoa;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteÁrvoreRubroNegra {
	public static void main(String[] args) {
		System.out.println("Árvore Rubro Negra");
		try{
			String arquivoOperacao = "pessoasC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Pessoa> pessoas = EDAUtil.Operacoes(path);
			ArvoreRubroNegra<Date, Pessoa> arn = new ArvoreRubroNegra<>();
	
			long tempoInicial = System.currentTimeMillis();
			for(int i = 0; i < pessoas.size(); i++){
				arn.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			long tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para inserir: " + tempo + " milesegundos");
			
			Collections.shuffle(pessoas);

			tempoInicial = System.currentTimeMillis();
			for(int i = 4000; i < 7000; i++){
				arn.busca(pessoas.get(i).getDataNascimento());
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para buscar 30%: " + tempo + " milesegundos");

			tempoInicial = System.currentTimeMillis();
			for(int i = 7000; i < 10000; i++){
				arn.remover(pessoas.get(i).getDataNascimento());				
			}
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para remover 30%: " + tempo + " milesegundos");

//			Misturado
			tempoInicial = System.currentTimeMillis();
			ArvoreRubroNegra<Date, Pessoa> arn2 = new ArvoreRubroNegra<Date, Pessoa>();
			for(int i = 0; i < 1999; i++){
				arn2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			System.out.println("Primeira Inserção");
			
			//busca 600 e remove 200
			for(int i = 100; i < 700; i++){
				arn2.busca(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Primeira Busca");

			for(int i = 100; i < 300; i++){
				arn2.remover(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Primeira Remoção");

			//+20%
			for(int i = 2000; i < 3999; i++){
				arn2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			System.out.println("Segunda Inserção");
			
			//busca 600 e remove 200
			for(int i = 800; i < 2000; i++){
				arn2.busca(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Segunda Busca");

			for(int i = 400; i < 800; i++){
				arn2.remover(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Segunda Remoção");
			
			//+20%
			for(int i = 4000; i < 5999; i++){
				arn2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			System.out.println("Terceira Inserção");
			
			//busca 600 e remove 200
			for(int i = 900; i < 2700; i++){
				arn2.busca(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Terceira Busca");

			for(int i = 900; i < 1500; i++){
				arn2.remover(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Terceira Remoçao");
			
			//+20%
			for(int i = 6000; i < 7999; i++){
				arn2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			System.out.println("Quarta Inserçao");
			
			//busca 600 e remove 200
			for(int i = 1600; i < 4000; i++){
				arn2.busca(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Quarta Busca");


			for(int i = 1600; i < 2400; i++){
				arn2.remover(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Quarta Remoção");

			//+20%
			for(int i = 8000; i < 9999; i++){
				arn2.inserir(pessoas.get(i).getDataNascimento(), pessoas.get(i));
			}
			System.out.println("Quinta Inserção");
			
			//busca 600 e remove 200
			for(int i = 2500; i < 5500; i++){
				arn2.busca(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Quinta Busca");


			for(int i = 2600; i < 3600; i++){
				arn2.remover(pessoas.get(i).getDataNascimento());
			}
			System.out.println("Quinta Busca");
			
			tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo para realizar operações mistas: " + tempo + " milesegundos");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
