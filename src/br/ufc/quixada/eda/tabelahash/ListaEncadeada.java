package br.ufc.quixada.eda.tabelahash;

public class ListaEncadeada<T> {
	private Node node;
	
	public void CriarLista(){
		node = null;
	}
	
	public void InserirComeço(NoHash hash){
		Node novo = new Node();
		novo.setChave(hash.getChave());
		novo.setValor(hash.getValor());
		novo.setNext(node);
	}
	
	public boolean isEmpty(){
		if (node == null){
			return true;
		}else{
			return false;
		}
	}
	
	public Node search(int value){
		for (Node n = node; n != null; n = n.getNext()){
			if(n.getChave() == value){
				return n;
			}
		}
		return null;
	}
	
	public Node remove(int chave){
		if(search(chave) != null){
			for (Node n = node; n != null; n = n.getNext()){
				if(n.getNext().getChave() == chave){
					Node aux = n.getNext();
					n.setNext(aux.getNext());
					return aux;
				}
			}
		}
		return null;
	}
}