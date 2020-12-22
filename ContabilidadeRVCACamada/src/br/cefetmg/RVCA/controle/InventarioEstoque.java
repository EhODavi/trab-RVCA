package br.cefetmg.RVCA.controle;

import java.util.ArrayList;
import java.util.List;

public class InventarioEstoque {
	private List<Produto> produtos = new ArrayList<Produto>();

	// ----------------------------------------------
	public InventarioEstoque() {
		this.produtos = new ArrayList<Produto>();
	}

	public boolean adicionarProduto(Produto produto) {
		if (produto != null) {
			this.produtos.add(produto);
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public boolean alterarProduto(Produto produto) {
		if (produto != null) {
			for (int i = 0; i < this.produtos.size(); i++) {
				if (this.produtos.get(i).getCodigo() == produto.getCodigo()) {
					this.produtos.remove(i);
					this.produtos.add(i, produto);
					return true;
				}
			}
		}
		return false;
	}

	// ----------------------------------------------
	public boolean excluirProduto(int codigo) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (codigo == this.produtos.get(i).getCodigo()) {
				this.produtos.remove(i);
				return true;
			}
		}
		return false;
	}

	// ----------------------------------------------
	public Produto buscarProduto(int codigo) {
		Produto p;
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getCodigo() == codigo) {
				p = this.produtos.get(i);
				return p;
			}
		}
		return null;
	}

	// ----------------------------------------------
	public List<Produto> listarProduto() {
		return this.produtos;
	}
}
