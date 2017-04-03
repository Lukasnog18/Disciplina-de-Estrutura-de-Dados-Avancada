package br.ufc.quixada.eda.conjuntosdisjuntos;

public class FlorestaDeConjuntosDisjuntos {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	
	public FlorestaDeConjuntosDisjuntos(int n){
		this.n = n;
		pai = new int[n];
		ordem = new int[n];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	
	public void make_set_all(){
		for(int i = 0; i < n; i++)
			make_set(i);
	}
	
	public int find_set1(int v){
//		Recursivamente
		
		if(v == pai[v]) return v;
		else return find_set(pai[v]);
	}
	
	public int find_set(int v){
		if(v == pai[v]) return v;
		else{
			int pai_v = find_set(pai[v]);
			pai[v] = pai_v;
			return pai_v;
		}
	}
	
	public void link_set1(int v, int u){
		pai[v] = u;
	}
	
	public void link_set(int v, int u){
		if(ordem[v] < ordem[u]) pai[v] = u;
		//else if(ordem[u] < ordem[v]) pai[u] = v;
		else{
			pai[u] = v;
			if(ordem[u] == ordem[v]) ordem[v]++;
		}
	}
	
	public void union(int v, int u){
		link_set(find_set(v), find_set(u));
	}	
}
