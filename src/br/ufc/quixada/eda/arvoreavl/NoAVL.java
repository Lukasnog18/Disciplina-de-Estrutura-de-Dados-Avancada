package br.ufc.quixada.eda.arvoreavl;

public class NoAVL<Chave, Info> {
	private NoAVL<Chave, Info> esq, dir;
	private int altura; 
	private Chave chave;
	private Info object;
	
	public NoAVL(Chave chave, Info object){
		esq = null;
		dir = null;
		altura = 1;
		this.chave = chave;
		this.object = object;
	}

	public Info getObject() {
		return object;
	}

	public void setObject(Info object) {
		this.object = object;
	}

	public NoAVL<Chave, Info> getEsq() {
		return esq;
	}

	public void setEsq(NoAVL<Chave, Info> esq) {
		this.esq = esq;
	}

	public NoAVL<Chave, Info> getDir() {
		return dir;
	}

	public void setDir(NoAVL<Chave, Info> dir) {
		this.dir = dir;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}
}