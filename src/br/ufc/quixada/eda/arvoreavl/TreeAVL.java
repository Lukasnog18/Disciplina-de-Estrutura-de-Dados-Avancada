package br.ufc.quixada.eda.arvoreavl;

public class TreeAVL<Chave extends Comparable<Chave>, Info>{
	private NoAVL<Chave, Info> raiz = null;
	
	public void inserir(Chave chave, Info object){
		this.raiz = inserir(this.raiz, chave, object);
	}
	
	private NoAVL<Chave, Info> inserir(NoAVL<Chave, Info> raiz, Chave chave, Info object){
		if(raiz == null){
			raiz = new NoAVL<Chave, Info>(chave, object);
		}else if(raiz.getChave().compareTo(chave) > 0){
			raiz.setEsq(inserir(raiz.getEsq(), chave, object));
		}else if(raiz.getChave().compareTo(chave) < 0){
			raiz.setDir(inserir(raiz.getDir(),chave, object));
		}
		raiz = vBalance(raiz);
		return raiz;
	}
	
	private int max(int dir, int esq){
		return dir > esq ? dir : esq;
	}

	private int altura(NoAVL<Chave, Info> raiz){
		return raiz == null ? -1 : raiz.getAltura();
	}
	
	private NoAVL<Chave, Info> busca(NoAVL<Chave, Info> raiz, Chave chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.getChave());
		if(cmp > 0){
			return busca(raiz.getDir(), chave);
		}else if(cmp < 0){
			return busca(raiz.getEsq(), chave);
		}
		return raiz;
	}
	
	public NoAVL<Chave, Info> busca(Chave chave){
		return busca(raiz, chave);
	}

	private NoAVL<Chave, Info> rotEsq(NoAVL<Chave, Info> raiz) {
		NoAVL<Chave, Info> aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getDir()), raiz.getAltura()) + 1);
		return aux;
	}
	

	private NoAVL<Chave, Info> rotDir(NoAVL<Chave, Info> raiz) {
		NoAVL<Chave, Info> aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getEsq()), raiz.getAltura()) + 1);
		return aux;
	}

	private NoAVL<Chave, Info> rotDEsq(NoAVL<Chave, Info> raiz){
		raiz.setDir(rotDir(raiz.getDir()));
		return rotEsq(raiz);
	}

	private NoAVL<Chave, Info> rotDDir(NoAVL<Chave, Info> raiz){
		raiz.setEsq(rotEsq(raiz.getEsq()));
		return rotDir(raiz);
	}

	private int comp(NoAVL<Chave, Info> raiz){
		return altura(raiz.getEsq()) - altura(raiz.getDir());
	}
	
	private NoAVL<Chave, Info> vBalance(NoAVL<Chave, Info> raiz){
		if(comp(raiz) == 2){
			if(comp(raiz.getEsq()) > 0){
				raiz = rotDir(raiz);
			}else{
				raiz = rotDDir(raiz);
			}
		}else if (comp(raiz) == -2){
			if(comp(raiz.getDir()) < 0){
				raiz = rotEsq(raiz);
			}else{
				raiz = rotDEsq(raiz);
			}
		}else{
			
		}
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		return raiz;
	}
	
	public void remover(Chave chave){
		raiz = remover(raiz, chave);
	}
	
	public NoAVL<Chave, Info> remover(NoAVL<Chave, Info> no, Chave chave){
		if(no == null)
			return null;
		int cmp = chave.compareTo(no.getChave());
		if(cmp == 1){
			no.setDir(remover(no.getDir(), chave));
			if((altura(no.getEsq()) - altura(no.getDir())) == 2){
				if(altura(no.getEsq().getEsq()) > altura(no.getEsq().getDir())){
					no = rotDDir(no);
				}else{
					no = rotDDir(no);
				}
			}
		}else if(cmp == -1){
			no.setEsq(remover(no.getEsq(), chave));
			if((altura(no.getDir()) - altura(no.getEsq())) == 2){
				if(altura(no.getDir().getDir()) > altura(no.getDir().getEsq())){
					no = rotEsq(no);
				}else{
					no = rotDEsq(no);
				}
			}
		}else{
			if(no.getDir() == null || no.getEsq() == null){
				if(no.getDir() == null && no.getDir() == null)
					return null;
				if(no.getDir() == null){
					no = no.getEsq();
				}else{
					no = no.getDir();
				}
			}else{
				NoAVL<Chave, Info> aux = elemMinimo(no.getDir());
				no.setChave(aux.getChave());
				no.setDir(remover(no.getDir(), aux.getChave()));
			}
		}
		no.setAltura(((altura(no.getDir()) > altura(no.getEsq())) ? altura(no.getDir()) : (altura(no.getEsq()))) + 1);
		return no;
	}
	
	NoAVL<Chave, Info> elemMinimo(NoAVL<Chave, Info> no){
		NoAVL<Chave, Info> aux = no;
		while(aux.getEsq() != null)
			aux = aux.getEsq();
		return aux;
	}
	
	private void mostraArvore(NoAVL<Chave, Info> n, String s) {
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
		System.out.println(n.getChave() +"(" + n.getAltura()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			mostraArvore(n.getEsq(), s + "l");
		}
	}
	
	public void mostraArvore() {
		mostraArvore(this.raiz, "");
		System.out.println("\n\n");
	}

	public NoAVL<Chave, Info> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoAVL<Chave, Info> raiz) {
		this.raiz = raiz;
	}
}
