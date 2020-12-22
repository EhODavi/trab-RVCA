package br.cefetmg.RVCA.controle;

import java.util.List;

import br.cefetmg.RVCA.dados.RepoProduto;

public class ControleProduto {
	private RepoProduto repoProduto;

	public ControleProduto() { // Construtor
		repoProduto = new RepoProduto();
	}

	public boolean adicionarProduto(Produto produto) {
		return repoProduto.adicionarProduto(produto);
	}

	public boolean alterarProduto(Produto produto) {
		return repoProduto.alterarProduto(produto);
	}

	public boolean excluirProduto(int codigo) {
		return repoProduto.excluirProduto(codigo);
	}

	public List<Produto> listarProduto() {
		return repoProduto.listarProduto();
	}

	public Produto buscarProduto(int codigo) {
		return repoProduto.buscarProduto(codigo);
	}
}
