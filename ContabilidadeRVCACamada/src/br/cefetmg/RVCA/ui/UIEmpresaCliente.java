package br.cefetmg.RVCA.ui;

import java.util.List;
import java.util.Scanner;

import br.cefetmg.RVCA.controle.EmpresaCliente;
import br.cefetmg.RVCA.controle.Produto;
import br.cefetmg.RVCA.controle.Sistema;

public class UIEmpresaCliente {
	private static Scanner scn = new Scanner(System.in);
	private Sistema banco;

	public UIEmpresaCliente() { // Construtor
		banco = Sistema.getInstance();
	}

	public void adicionarEmpresa() {
		System.out.println("\n------   Cadastrar um Empresa Cliente   ------\n");
		EmpresaCliente cliente = lerCliente();
		if (banco.adicionarEmpresa(cliente)) {
			System.out.println("\nInsercao realizada com sucesso!!!\n");
		} else {
			System.out.println("\nFalha na inserção!!!\n");
		}
	}

	public void alterarEmpresa() {
		System.out.println("\n------   Alterar uma Empresa Cliente   ------\n");
		List<EmpresaCliente> clientes = banco.listarEmpresa();
		boolean logico = listarEmpresa(clientes);
		int codigo;
		if (logico != false) {
			codigo = lerCodigo();
			EmpresaCliente c = banco.buscarEmpresa(codigo);
			alterarEmpresa(c);
			if (banco.alterarEmpresa(c)) {
				System.out.println("\nAlteracao realizada com sucesso!!!\n");
			} else {
				System.out.println("\nFalha na alteracao!!!\n");
			}
		}
	}

	public void excluirEmpresa() {
		System.out.println("\n------   Excluir uma Empresa Cliente   ------\n");
		List<EmpresaCliente> clientes = banco.listarEmpresa();
		boolean logico = listarEmpresa(clientes);
		if (logico != false) {
			int codigo = lerCodigo();
			if (banco.excluirEmpresa(codigo)) {
				System.out.println("\nExclusão realizada com sucesso!!!\n");
			} else {
				System.out.println("\nFalha na exclusao!!!\n");
			}
		}
	}

	public void listarEmpresa() {
		System.out.println("\n------   Listar as Empresas Clientes   ------\n");
		List<EmpresaCliente> clientes = banco.listarEmpresa();
		listarEmpresaInventario(clientes);
	}

	public EmpresaCliente buscarEmpresa(int codigo) {
		return this.banco.buscarEmpresa(codigo);
	}

	public boolean empresaDisponivel() { // Lista as empresa disponíveis para o
											// cliente
		boolean logico;
		List<EmpresaCliente> clientes = banco.listarEmpresa();
		logico = listarEmpresa(clientes);
		return logico;
	}

	private EmpresaCliente lerCliente() {
		System.out.println("\nInforme o nome da Empresa Cliente: ");
		String nome = scn.next();
		System.out.println("Informe o CNPJ da Empresa Cliente: ");
		String cnpj = scn.next();
		System.out.println("Informe a Inscricao Estadual da Empresa Cliente: ");
		String inscricaoEstadual = scn.next();
		System.out.println("Informe o Telefone da Empresa Cliente: ");
		String fone = scn.next();
		System.out.println();
		EmpresaCliente c = EmpresaCliente.newInstance(cnpj, inscricaoEstadual, nome, fone);
		return c;
	}

	private void listarEmpresaInventario(List<EmpresaCliente> clientes) {
		if (clientes == null || clientes.size() == 0) {
			System.out.println("\nNão há Empresas Clientes Cadastradas\n");
		} else {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println("\nCodigo da Empresa Cliente: " + clientes.get(i).getCodigo());
				System.out.println("Nome da Empresa Cliente: " + clientes.get(i).getNome());
				System.out.println("CNPJ da Empresa Cliente: " + clientes.get(i).getCNPJ());
				System.out.println("Inscricão Estadual da Empresa Cliente: " + clientes.get(i).getInscricaoEstadual());
				System.out.println("Telefone da Empresa Cliente: " + clientes.get(i).getTelefone());
				listarInventario(clientes.get(i));
				System.out.println("\n--------------------------------------------------\n");
			}
		}
	}

	private boolean listarInventario(EmpresaCliente inventarioEmpresa) {
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

	public boolean listarEmpresa(List<EmpresaCliente> clientes) { // OK
		if (clientes == null || clientes.size() == 0) {
			System.out.println("\nNão há Empresas Clientes Cadastradas\n");
			return false;
		} else {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println("\nCodigo da Empresa Cliente: " + clientes.get(i).getCodigo());
				System.out.println("Nome da Empresa Cliente: " + clientes.get(i).getNome());
				System.out.println("CNPJ da Empresa Cliente: " + clientes.get(i).getCNPJ());
				System.out.println("Inscricão Estadual da Empresa Cliente: " + clientes.get(i).getInscricaoEstadual());
				System.out.println("Telefone da Empresa Cliente: " + clientes.get(i).getTelefone());
				System.out.println("\n--------------------------------------------------\n");
			}
			return true;
		}
	}

	public int lerCodigo() {
		System.out.print("\nInforme o Codigo: ");
		int codigo = scn.nextInt();
		System.out.println();
		return codigo;
	}

	private static void alterarEmpresa(EmpresaCliente c) { // OK
		if (c != null) {

			int opcao;

			do {
				System.out.println("\nCodigo da Empresa Cliente: " + c.getCodigo());
				System.out.println("1 - CNPJ da Empresa Cliente: " + c.getCNPJ());
				System.out.println("2 - Nome da Empresa Cliente: " + c.getNome());
				System.out.println("3 - Inscricão Estadual da Empresa Cliente: " + c.getInscricaoEstadual());
				System.out.println("4 - Telefone da Empresa Cliente: " + c.getTelefone());
				System.out.print("Escolha qual campo deseja alterar (0 - Sair): ");
				opcao = scn.nextInt();

				switch (opcao) {
				case 1:
					System.out.print("\nNovo CNPJ da Empresa Cliente: ");
					String cnpj = scn.next();
					c.setCNPJ(cnpj);
					break;
				case 2:
					System.out.print("\nNovo Nome da Empresa Cliente: ");
					String nome = scn.next();
					c.setNome(nome);
					break;
				case 3:
					System.out.print("\nNova Inscricao Estadual da Empresa Cliente: ");
					String inscricaoEstadual = scn.next();
					c.setInscricaoEstadual(inscricaoEstadual);
					break;
				case 4:
					System.out.print("\nNovo Telefone da Empresa Cliente: ");
					String telefone = scn.next();
					c.setTelefone(telefone);
					break;
				default:
					break;
				}

			} while (opcao != 0);
		}
	}
}
