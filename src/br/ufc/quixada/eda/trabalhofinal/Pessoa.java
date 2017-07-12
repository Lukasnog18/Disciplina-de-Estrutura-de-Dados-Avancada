package br.ufc.quixada.eda.trabalhofinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private String email;
	private String senhaEmail;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String celular;
//	private HashMap<Date, String> pessoas = new HashMap<Date, String>();
	
	public Pessoa(String nome, String cpf, String rg, Date dataNascimento, String email, String senhaEmail, String cep,
				String rua, String numero, String bairro, String cidade, String estado, String telefone, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senhaEmail = senhaEmail;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
	}
	
	public int compareTo(Pessoa pessoa) {
		if(this.dataNascimento.compareTo(pessoa.getDataNascimento()) < 0) return -1;
		else if(this.dataNascimento.compareTo(pessoa.getDataNascimento()) > 0) return 1;
		else return 0;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", senhaEmail=" + senhaEmail + ", cep=" + cep + ", rua=" + rua + ", numero="
				+ numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone
				+ ", celular=" + celular + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenhaEmail() {
		return senhaEmail;
	}

	public void setSenhaEmail(String senhaEmail) {
		this.senhaEmail = senhaEmail;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
