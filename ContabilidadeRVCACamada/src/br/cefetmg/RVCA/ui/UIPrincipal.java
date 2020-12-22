package br.cefetmg.RVCA.ui;

import java.util.Scanner;

public class UIPrincipal {
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		UIEmpresaCliente uiEmpresaCliente = new UIEmpresaCliente();
		UILogin uiLogin = new UILogin();
		UIProduto uiProduto = new UIProduto();
		Programa p = new Programa();
		int opcao = 0;
		int opcaoCC = 0;
		boolean logico; // Verifica se o usuário logou
		boolean logico1 = false; // Sair do programa

		p.inicializarObjetos();
		// ----------------------------------------------
		do {
			logico = false;
			System.out.println("------   RVCA Contabilidade   ------\n");
			System.out.println("1 - Logar");
			System.out.println("2 - Nova Conta");
			System.out.println("0 - Sair");
			opcao = scn.nextInt();

			switch (opcao) {
			case 1: // Logar
				logico = uiLogin.buscarLogin();
				break;
			case 2: // Criar Conta
				uiLogin.adicionarLogin();
				break;
			case 0: // Sair
				logico1 = true;
				System.out.println("\nAté mais!!!\n");
				break;
			default:
				System.out.println("\nOpcao inválida!!!\n");
			}

			if (logico == true) {
				do {
					System.out.println("------   RVCA Contabilidade   ------\n");
					System.out.println("1 - Entrar como Contador");
					System.out.println("2 - Entrar como Cliente");
					System.out.println("0 - Sair da Conta");
					opcao = scn.nextInt();

					switch (opcao) {
					case 0: // Sair da Conta
						break;
					case 1: // Entrar como Contador
						do {
							System.out.println("------   RVCA Contabilidade   ------\n");
							System.out.println("1 - Cadastrar uma Empresa Cliente");
							System.out.println("2 - Alterar uma Empresa Cliente");
							System.out.println("3 - Excluir uma Empresa Cliente");
							System.out.println("4 - Listar as Empresas Clientes");
							System.out.println("0 - Retornar");
							opcaoCC = scn.nextInt();
							switch (opcaoCC) {
							case 1: // Cadastrar uma Empresa Cliente
								uiEmpresaCliente.adicionarEmpresa();
								break;
							case 2: // Alterar uma Empresa Cliente
								uiEmpresaCliente.alterarEmpresa();
								break;
							case 3: // Excluir uma Empresa Cliente
								uiEmpresaCliente.excluirEmpresa();
								break;
							case 4: // Listar as Empresas Clientes
								uiEmpresaCliente.listarEmpresa();
								break;
							case 0: // Retornar
								logico = false;
								break;
							default:
								System.out.println("\nOpcao inválida!!!\n");
							}
						} while (opcaoCC != 0);
						break;
					case 2:
						System.out.println("\n------   Empresas Clientes Disponíveis   ------\n");
						logico = uiEmpresaCliente.empresaDisponivel();
						int codigo;
						if (logico != false) {
							codigo = uiEmpresaCliente.lerCodigo();
							if (uiEmpresaCliente.buscarEmpresa(codigo) != null) {
								do {
									System.out.println("------   " + uiEmpresaCliente.buscarEmpresa(codigo).getNome()
											+ "   ------\n");
									System.out.println("1 - Cadastrar um produto do Inventário do Estoque");
									System.out.println("2 - Alterar um produto do Inventário do Estoque");
									System.out.println("3 - Excluir um produto do Inventário do Estoque");
									System.out.println("4 - Listar o Inventário do Estoque");
									System.out.println("0 - Retornar");
									opcaoCC = scn.nextInt();
									switch (opcaoCC) {
									case 1: // Cadastrar um produto do Inventário do Estoque
										uiProduto.adicionarProduto(codigo);
										break;
									case 2: // Alterar um produto do Inventário do Estoque
										uiProduto.alterarProduto(codigo);
										break;
									case 3: // Excluir um produto do Inventário do Estoque
										uiProduto.excluirProduto(codigo);
										break;
									case 4: // Listar o Inventário do Estoque
										uiProduto.listarProduto(codigo);
										break;
									case 0: // Retornar
										break;
									default:
										System.out.println("\nOpcao invalida!!!\n");
									}
								} while (opcaoCC != 0);
							} else {
								System.out.println("\nOpção inválida!!!\n");
							}
						}
						break;
					default:
						System.out.println("\nOpcao inválida!!!\n");
					}
				} while (opcao != 0);
			}
		} while (logico1 == false);
	}
}
