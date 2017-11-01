package br.unincor.controle;

import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;

public class CalculoPrecos {

	public void calculaPrecoFinal(Produto p) throws PrecoZeradoException {
		
		if(p.getPreco() != null && p.getPreco() != 0){
			if(p instanceof Sanduiche){
				Sanduiche sanduiche = (Sanduiche)p;
				
				if(sanduiche.getTrio() && sanduiche.getDobroRecheio()){
					sanduiche.setPreco(sanduiche.getPreco() + 15D);
					sanduiche.setPreco(sanduiche.getPreco()*1.3);
				}
				
				else if(sanduiche.getTrio()){
					sanduiche.setPreco(sanduiche.getPreco() + 15D);
				}
				else if(sanduiche.getDobroRecheio()){
					sanduiche.setPreco(sanduiche.getPreco()*1.3);
				}
				
			}
			
			else if(p instanceof Sobremesa){
				Sobremesa sobremesa = (Sobremesa)p;
				
				if(sobremesa.getAdicionais()){
					sobremesa.setPreco(sobremesa.getPreco()*1.35);
				}
				
			}
		}
		else{
			throw new PrecoZeradoException(p);
		}
		
	}
	
	public Double pagtoDinheiro(List<Produto> listP) {
		Double somaPreco = 0.0;
		for (Produto p : listP){
			somaPreco += p.getPreco();
		}
		
		return somaPreco*0.9;

	}
	public Double pagtoCartao(List<Produto> listP){
		Double somaPreco = 0.0;
		for (Produto p : listP){
			somaPreco += p.getPreco();
		}
		
		return somaPreco * 1.05;

	}

}
