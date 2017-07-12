package br.ufc.quixada.eda.arvoresplay;

public class NodeSplay<Chave, Info> {
	
	private NodeSplay<Chave, Info> dir, esq;
	private Chave chave;
	private Info object;
	
	public NodeSplay(Chave chave, Info object){
		esq = null;
		dir = null;
		this.chave = chave;
		this.object = object;
	}
	
	public NodeSplay<Chave, Info> getDir() {
		return dir;
	}
	public void setDir(NodeSplay<Chave, Info> direita) {
		this.dir = direita;
	}
	public NodeSplay<Chave, Info> getEsq() {
		return esq;
	}
	public void setEsq(NodeSplay<Chave, Info> esquerda) {
		this.esq = esquerda;
	}
	public Chave getChave() {
		return chave;
	}
	public void setChave(Chave chave) {
		this.chave = chave;
	}
	public Info getObject() {
		return object;
	}
	public void setObject(Info object) {
		this.object = object;
	}
}