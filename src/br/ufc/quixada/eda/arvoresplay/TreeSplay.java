package br.ufc.quixada.eda.arvoresplay;

import java.util.Date;

import br.ufc.quixada.eda.trabalhofinal.Pessoa;

public class TreeSplay<Chave extends Comparable<Chave>, Info> {

	private NodeSplay<Chave, Info> raiz;
	
	
	private NodeSplay<Chave, Info> rightRotation(NodeSplay<Chave, Info> no){
		NodeSplay<Chave, Info> novoNo = no.getEsq();
		no.setEsq(novoNo.getDir());
		novoNo.setDir(no);
		return novoNo;
	}
	private NodeSplay<Chave, Info> leftRotation(NodeSplay<Chave, Info> no){
		NodeSplay<Chave, Info> novoNo = no.getDir();
		no.setDir(novoNo.getEsq());
		novoNo.setEsq(no);
		return novoNo;
	}
	
	private NodeSplay<Chave, Info> sPlay(NodeSplay<Chave, Info> raiz, Chave chave ){
		if(raiz == null) return null;
		if(raiz.getChave() == chave) return raiz;
		
		if(chave.compareTo(raiz.getChave()) < 0){
			if(raiz.getEsq() != null){
				raiz.setEsq(sPlay(raiz.getEsq(), chave));
				raiz = rightRotation(raiz);
			}
		}else {
			if(raiz.getDir() != null){
				raiz.setDir(sPlay(raiz.getDir(), chave));
				raiz = leftRotation(raiz);
			}
		}
		
		return raiz;
	}
	
	public void inserir(Chave chave, Info object){
		raiz = inserir(raiz, chave, object);
	}
	
	private NodeSplay<Chave, Info> inserir(NodeSplay<Chave, Info> raiz, Chave chave, Info object){
		if(raiz == null)
			return new NodeSplay<Chave, Info>(chave, object);
		else if(0 > chave.compareTo(raiz.getChave())){
			raiz.setEsq(inserir(raiz.getEsq(), chave, object));
		}else if(0 < chave.compareTo(raiz.getChave())){
			raiz.setDir(inserir(raiz.getDir(), chave, object));
		}
		raiz = sPlay(raiz, chave);
		return raiz;
	}

	public NodeSplay<Chave, Info> busca(Chave chave){
		raiz = sPlay(raiz, chave);
		if(0 == chave.compareTo(raiz.getChave()))
			return raiz;
		else
			return null;
	} 
	
	public void remover(Chave chave){
		this.raiz = sPlay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NodeSplay<Chave, Info> aux = sPlay(this.raiz.getEsq(), chave);
		if(raiz.getDir() != null && aux != null) aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	private void mostraArvore(NodeSplay<Chave, Info> n, String s) {
		if(n != null && (n.getEsq() != null || n.getDir() != null))
			mostraArvore(n.getDir(), s + "r");
		int tam = s.length();
		for(int i = 0; i < tam - 1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				System.out.print("| "+"  ");
			}else {
				System.out.print("  "+"  ");
			}
		}
		if(s != "") {
			if(s.endsWith("r") == true)
				System.out.print("┌───");
			else
				System.out.print("└───");
		}
		if(n == null) {
			System.out.println("#");
			return;
		}
		System.out.println(n.getChave());
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			mostraArvore(n.getEsq(), s + "l");
		}
	}
	
	public void mostraArvore() {
		mostraArvore(this.raiz, "");
		System.out.println("\n\n");
	}

}
