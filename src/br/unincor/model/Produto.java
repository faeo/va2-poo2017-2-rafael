package br.unincor.model;

import java.text.DecimalFormat;

public class Produto {
	
	private String nome;
	private Double preco; 
	
	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		if (preco >= 0D)
			this.preco = preco;
		else
			this.preco = null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		if (preco >= 0D)
			this.preco = preco;
		else
			this.preco = null;
	}
	
	public String verDados() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "Nome: " + this.nome + 
			   "\nPreço: R$ " + df.format(this.preco); 
	}
}
