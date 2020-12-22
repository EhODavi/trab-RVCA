package br.cefetmg.RVCA.ui;

import java.util.Scanner;

import br.cefetmg.RVCA.controle.Login;
import br.cefetmg.RVCA.controle.Sistema;

public class UILogin {
	private static Scanner scn = new Scanner(System.in);
	private Sistema banco;

	public UILogin() { // Construtor
		banco = Sistema.getInstance();
	}

	public boolean buscarLogin() {
		System.out.println("\n------   Tela de Login   ------\n");
		System.out.println("Usuario: ");
		String usuario = scn.next();
		System.out.println("Senha: ");
		String senha = scn.next();
		boolean logico;
		if (banco.buscarLogin(usuario, senha) == true) {
			System.out.println("\nLogin realizado com sucesso!!!\n");
			logico = true;
		} else {
			System.out.println("\nDados Inválidos!!!\n");
			logico = false;
		}
		return logico;
	}

	public boolean adicionarLogin() {
		System.out.println("\n------   Nova Conta   ------\n");
		System.out.println("Usuario: ");
		String usuario = scn.next();
		System.out.println("Senha: ");
		String senha = scn.next();
		boolean logico;
		if (banco.adicionarLogin(Login.newInstance(usuario, senha)) == true) {
			System.out.println("\nLogin cadastrado com sucesso!!!\n");
			logico = true;
		} else {
			System.out.println("\nDados Inválidos!!!\n");
			logico = false;
		}
		return logico;
	}
}
