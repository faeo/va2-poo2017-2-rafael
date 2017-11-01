package br.unincor.exception;

import br.unincor.model.Produto;

public class PrecoZeradoException extends Exception {

	private Produto produto;

	public PrecoZeradoException(Produto produto) {
		super();
		this.produto = produto;
	}
	
	@Override
	public String getMessage() {
		return "O produto " + this.produto.getNome() + " está com o preço zerado!";
	}

}


