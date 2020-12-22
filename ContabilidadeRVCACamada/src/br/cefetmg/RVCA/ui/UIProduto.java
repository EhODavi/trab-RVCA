package br.cefetmg.RVCA.ui;

import java.util.List;
import java.util.Scanner;

import br.cefetmg.RVCA.controle.EmpresaCliente;
import br.cefetmg.RVCA.controle.Produto;
import br.cefetmg.RVCA.controle.Sistema;

public class UIProduto {
	private static Scanner scn = new Scanner(System.in);
	private Sistema banco;

	public UIProduto() { // Construtor
		banco = Sistema.getInstance();
	}

	public void adicionarProduto(int codigo) {
		System.out.println("\n------   Cadastrar um produto do Inventário do Estoque   ------\n");
		Produto produto = lerProduto(codigo);
		if (banco.adicionarProduto(produto)) {
			System.out.println("\nInsercao realizada com sucesso!!!\n");
		} else {
			System.out.println("\nFalha na inserção!!!\n");
		}
	}

	public void alterarProduto(int codigo) {
		System.out.println("\n------   Alterar um Produto do Inventario do Estoque   ------\n");
		boolean logico = listarInventario(banco.buscarEmpresa(codigo));
		int codigoProduto;
		if (logico != false) {
			codigoProduto = lerCodigo();
			Produto p = banco.buscarProduto(codigoProduto);
			alterarProduto(p);
			if (banco.alterarProduto(p)) {
				System.out.println("\nAlteracao realizada com sucesso!!!\n");
			} else {
				System.out.println("\nFalha na alteracao!!!\n");
			}
		}
	}

	public void excluirProduto(int codigo) {
		System.out.println("\n------   Excluir um Produto do Inventario do Estoque   ------\n");
		boolean logico = listarInventario(banco.buscarEmpresa(codigo));
		if (logico != false) {
			int codigoProduto = lerCodigo();
			if (banco.excluirProduto(codigoProduto)) {
				System.out.println("\nExclusão realizada com sucesso!!!\n");
			} else {
				System.out.println("\nFalha na exclusao!!!\n");
			}
		}
	}

	public void listarProduto(int codigo) {
		System.out.println("\n------   Listar o Inventario do Estoque   ------\n");
		listarInventario(banco.buscarEmpresa(codigo));
	}

	private Produto lerProduto(int codigo) { // OK
		System.out.print("\nInforme o Nome do Produto: ");
		String nome = scn.next();
		System.out.print("Informe a Categoria do Produto: ");
		String categoria = scn.next();
		System.out.print("Informe a Unidade de Medida do Produto: ");
		String unidadeMedida = scn.next();
		System.out.print("Informe o Valor por Unidade de Medida do Produto: ");
		double valorPorUnidadeMedida = scn.nextDouble();
		System.out.print("Informe a Quantidade do Produto: ");
		int quantidade = scn.nextInt();
		EmpresaCliente empresa = banco.buscarEmpresa(codigo);
		System.out.println();
		Produto p = Produto.newInstance(categoria, valorPorUnidadeMedida, nome, quantidade, unidadeMedida, empresa);
		return p;
	}

	public int lerCodigo() { // OK
		System.out.print("\nInforme o Codigo: ");
		int codigo = scn.nextInt();
		System.out.println();
		return codigo;
	}

	private boolean listarInventario(EmpresaCliente inventarioEmpresa) { // OK
		List<Produto> produtos = banco.listarProduto();
		int contador = 0;
		if (produtos != null && produtos.size() != 0) {
			for (int y = 0; y < produtos.size(); y++) {
				if (produtos.get(y).getEmpresa() == inventarioEmpresa) {
					contador++;
				}
			}
		}
		if (contador == 0) {
			System.out.println("\nInventário do Estoque:\n");
			System.out.println("\nNão há Produtos Cadastrados!!!\n");
			return false;
		} else {
			System.out.println("\nInventário do Estoque:\n");
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i).getEmpresa() == inventarioEmpresa) {
					System.out.println("\nCodigo do Produto: " + produtos.get(i).getCodigo());
					System.out.println("Nome do Produto: " + produtos.get(i).getNome());
					System.out.println("Categoria: " + produtos.get(i).getCategoria());
					System.out.println("Unidade de Medida do Produto: " + produtos.get(i).getUnidadeMedida());
					System.out.println("Valor Unitário do Produto: R$" + produtos.get(i).getValorPorUnidadeMedida());
					System.out.println("Quantidade do Produto: " + produtos.get(i).getQuantidade() + " "
							+ produtos.get(i).getUnidadeMedida());
					System.out.println("Valor Total do Produto: R$" + produtos.get(i).getValorTotal());
					System.out.println();
				}
			}
			return true;
		}
	}

	private static void alterarProduto(Produto p) { // OK
		if (p != null) {
			int opcao;

			do {
				System.out.println("\nCodigo do Produto: " + p.getCodigo());
				System.out.println("1 - Nome do Produto: " + p.getNome());
				System.out.println("2 - Unidade de Medida do Produto: " + p.getUnidadeMedida());
				System.out.println("3 - Valor Unitário do Produto: R$" + p.getValorPorUnidadeMedida());
				System.out.println("4 - Quantidade do Produto: " + p.getQuantidade());
				System.out.print("Escolha qual campo deseja alterar (0 - Sair): ");
				opcao = scn.nextInt();

				switch (opcao) {
				case 1:
					System.out.print("\nNovo Nome do Produto: ");
					String nome = scn.next();
					p.setNome(nome);
					break;
				case 2:
					System.out.print("\nNova Unidade de Medida do Produto: ");
					String unidadeMedida = scn.next();
					p.setUnidadeMedida(unidadeMedida);
					break;
				case 3:
					System.out.print("\nNovo Valor Unitário do Produto: ");
					double valorPorUnidadeMedida = scn.nextDouble();
					p.setValorPorUnidadeMedida(valorPorUnidadeMedida);
					break;
				case 4:
					System.out.print("\nNova Quantidade do Produto: ");
					int quantidade = scn.nextInt();
					p.setQuantidade(quantidade);
					break;
				default:
					break;
				}
			} while (opcao != 0);
		}
	}
}
