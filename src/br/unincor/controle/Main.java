package br.unincor.controle;

import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) throws PrecoZeradoException {
		
		Usuario view = new Usuario();
		CalculoPrecos calc = new CalculoPrecos();
		List<Produto> listP = new ArrayList<Produto>();
		
		Integer op = 0;
		while(op != -1 && op !=2){
			op = view.exibeMenuPrincipal();
			if(op ==0){
				//Sanduiche
				Sanduiche sanduiche = new Sanduiche("Sandubão", 0.0, false, true);
				calc.calculaPrecoFinal(sanduiche);
				listP.add(sanduiche);
			}
			
			else if(op == 1){
				//Sobremesa
				Sobremesa sobremesa = new Sobremesa("Docinho", 100.0, true);
				calc.calculaPrecoFinal(sobremesa);
				listP.add(sobremesa);
			}
			
			
		}
		Integer opPagto = view.exibeMenuPagamento();
		Double valorFinal = 0.0;
		if(opPagto == 1) {
			//cartão pos 1
			valorFinal = calc.pagtoCartao(listP);
		} else {
			//dinheiro pos 0
			valorFinal = calc.pagtoDinheiro(listP);
		}
		

		for (Produto p : listP) {
			view.exibeMsg("Resumo do Pedido \n" + p.verDados() + "\nValor final: R$ " + valorFinal);
		}
		view.exibeMsg("Valor final: " + valorFinal);
	}
		
}