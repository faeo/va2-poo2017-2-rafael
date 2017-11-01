package br.unincor.view;


import javax.swing.JOptionPane;

public class Usuario {

	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", JOptionPane.ERROR_MESSAGE);
	}


	public Integer exibeMenuPrincipal() {
		Object[] opcoes = { "Sanduiche", "Sobremesa", "Finalizar pedido" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Escolha o produto",
												"Menu Principal",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												2);

		return op;
	}

	public Integer exibeMenuPagamento() {
		Object[] opcoes = { "Dinheiro", "Cartão" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Forma de Pagamento",
												"Pagamento",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												0);

		return op;
	}

	public Integer recebeInteiro(String texto) {
		try{
			Integer resposta = Integer.parseInt(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e){
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
		
	}

	public Double recebeDouble(String texto) {
		try{
			Double resposta = Double.parseDouble(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e){
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public Boolean recebeBoolean(String texto) {
		Integer op = JOptionPane.showConfirmDialog(null, texto);

		if (op == 0)
			return true;
		return false;
	}

	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
}
